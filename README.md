# ssm-crud
基于Spring-mybatis简单的员工增删改查demo供大家学习
问题1：org.apache.ibatis.binding.BindingException: Invalid bound statement (not found)异常
将xml文件改到资源文件下加载
项目搭建过程
## 创建sring-mybatis过程
### 1、新建maven-webapp项目

### 2、引入项目依赖的jar包
   * spring webmvc
   * spring jdbc
   * spring aspect(面向切面编程)
   * mybatis
   * mybaits spring(整合适配包)
   * c3p0(数据库连接池)
   * mysql connector(数据连接驱动)   
   * jstl
   * servlet-api
   * junit

### 3、配置web.xml
   * (1)启动spring容器，类路径下加载applicationContext.xml文件,主要配置和业务逻辑有关的内容
   
   <context-param>
       <param-name>contextConfigLocation</param-name>
       <param-value>classpath:applicationContext.xml</param-value>
     </context-param>
     <listener>
       <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
     </listener>
    
   * (2)springmvc 前端控制器
    <servlet>
        <servlet-name>DispatcherServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
          <param-name>contextConfigLocation</param-name>
          <param-value>classpath:springmvc.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
      </servlet>
      <servlet-mapping>
        <servlet-name>DispatcherServlet</servlet-name>
        <url-pattern>/</url-pattern>
      </servlet-mapping>
    
   * (3)字符编码过滤器
     <filter>
       <filter-name>CharacterEncodingFilter</filter-name>
       <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
       <init-param>
         <param-name>encoding</param-name>
         <param-value>utf-8</param-value>
       </init-param>
   
       <init-param>
         <param-name>forceRequestEncoding</param-name>
         <param-value>true</param-value>
       </init-param>
     </filter>
     <filter-mapping>
       <filter-name>CharacterEncodingFilter</filter-name>
       <url-pattern>/*</url-pattern>
     </filter-mapping>
     
   * (4)使用Rest风格的URI,将页面普通的post请求转为制定的delete或者put请求
   
     <filter>
       <filter-name>HiddenHttpMethodFilter</filter-name>
       <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
     </filter>
     <filter-mapping>
       <filter-name>HiddenHttpMethodFilter</filter-name>
       <url-pattern>/*</url-pattern>
     </filter-mapping>
       
###  4、配置springmvc.xml
        <beans>
            <!--      Springmvc配置文件的配置  跟包含网站跳转逻辑-->
                <context:component-scan base-package="com.wuxin" use-default-filters="false">
                    <!--让他只扫控制器-->
                   <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
                </context:component-scan>
             <!--   配置视图解析器  方便页面返回-->
                <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
                 <property name="prefix" value="/WEB-INF/views/"></property>
                 <property name="suffix" value=".jsp"></property>
                </bean>
                <!--两个标准配置-->
                <!--将springmvc不能处理的请求交给tomcat-->
                <mvc:default-servlet-handler/>
                <!--能支持spring更高级的功能  映射动态请求-->
                <mvc:annotation-driven/>
        </beans>
  
###  5、配置applicationContext.xml
  
    (1)数据库连接池
    <context:property-placeholder location="classpath:dbconfig.properties"/>
        <bean id="pooledDataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
           <property name="jdbcUrl" value="${jdbc.jdbcUrl}"></property>
            <property name="driverClass" value="${jdbc.driverClass}"></property>
            <property name="user" value="${jdbc.user}"></property>
            <property name="password" value="${jdbc.password}"></property>
        </bean>
     (2)配置和mybatis的整合
     <!-- 配置和mybatis的整合-->
         <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
             <!--指定mysql全局配置-->
             <property name="configLocation" value="classpath:mybatis-config.xml"></property>
             <property name="dataSource" ref="pooledDataSource"></property>
             <!--mybatis mapper文件的位置-->
             <property name="mapperLocations" value="classpath*:mapper/*.xml"></property>
         </bean>
          <!--配置扫描器，将mybatis接口的时间加入到ioc容器中-->
         <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
            <!--扫描所有的dao接口的实现，加入到ioc中-->
             <property name="basePackage" value="com.wuxin.mapper"></property>
         </bean>
      (3)事物的控制
       <!--事物控制的配置-->
          <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
              <!--控制数据源-->
               <property name="dataSource" ref="pooledDataSource"></property>
          </bean>
          <!--开启事务基于注解的事物，使用xml配置形式的事物（必要）-->
          <aop:config>
              <!--切入点-->
              <aop:pointcut expression="execution(* com.wuxin.service..* (..))" id="txPoint"/>
              <!--配置事务增强-->
              <aop:advisor  advice-ref="txAdvice" pointcut-ref="txPoint"/>
          </aop:config>
          <!--配置事物增强，事物如何切入-->
          <tx:advice id="txAdvice" transaction-manager="transactionManager">
              <tx:attributes>
                  <!--所有方法都是事物方法-->
                  <tx:method name="*"/>
                  <!--以get开头的所有方法-->
                  <tx:method name="get*" read-only="true"/>
          </tx:advice>     
  
  

### 6、mybaits-config.xml配置
 
        <settings>
            <!--驼峰命名规则-->
            <setting name="mapUnderscoreToCamelCase" value="true"/>
        </settings>
        <typeAliases>
            <package name="com.wuxin.entity"/>
        </typeAliases>
        <plugins>
            <plugin interceptor="com.github.pagehelper.PageInterceptor" >
                <!--分页合理化-->
                <property name="reasonable" value="true"/>
            </plugin>
        </plugins>
## 参数传递
  * 单个参数
    * mybatis不会做特殊处理
    * {参数名}，取出参数
  * 多个参数:mybaitis 会做特殊处理，多个参数会被封装成一个map,
     key：param1,param2,param3  value:传入的值 #{}就是从map中获取指定的key值
     注：select 要选择 resultType
     * 取值用 #{0},#{1}  或者#{param1}  #{param2}
     * 设置mapper列表@Param("id) 
     
  ```
    List<Recipe> findRecipeByPage(@Param("recipeName")String recipeName,@Param("recipeType")String recipeType);
    
       
   	<select id = "findRecipeByPage" resultType="wuxin.order.entity.RecipeDto">
   	   select id id,recipe_name recipeName ,recipe_code recipeCode  , recipe_type recipeType,week, create_time createTime, update_time updateTime ,effect_time effectTime from wx_recipe where 1=1
   	   <if test="recipeName !=null and recipeName !='' ">
   	       and recipe_name like CONCAT(CONCAT('%',#{recipeName}),'%')
   	   </if>
   		<if test="recipeType !=null and recipeType !='' ">
   			and recipe_type =#{recipeType}
   		</if>
   		order BY effect_time ASC
   	</select>    
       
  ```
  * 如果多个参数正好是业务的数据模型，可以传入POJO
   * POJO .#{属性名}取出传入的pojo的属性值
   * Map 如果多个参数不是业务模型中的数据，没有对应的pojo，为了方便，可以传入map
    * 支持map嵌套
    ```
       Map<String,Object> map = new HashMap<String, Object>();
       Map<String,Integer> mapch = new HashMap<String, Integer>();
       mapch.put("id",17);
       map.put("idtest",mapch);
       return employeeMapper.deleteById(map);
       
       <delete id="deleteById">
           delete FROM  tbl_emp where emp_id = #{idtest.id}
       </delete>       
    ```
  * 如果多个参数不是业务模型中的数据，但是经常要使用，推荐来编写一个TO(Transfer-Object)
    数据对象
  * 扩展
   * 第一种
   ```
   public Employee getEmp(@Param("id")Integer id,String lastName);
   取值：id===>#{id,param1}   lastName===>#{param2}
   ``` 
     
   * 第二种
   ```
   public Employee getEmp(Integer id,@Param("e")Employee emp)
   取值：id===>#{param1}  lastName===>#{param2.lastName/e.lastName}
   ```
   
   * 第三种
   ```
   !!!特别注意如果是Collection(List,Set) 类型或者是数组会特殊处理
       也是把传入的list或者数据封装在map中
       key:Collection(collection)，如果是List还可以使用这个key(list)
       数组(array)
   public Empoyee getEmpById(List<Integer> ids)
      取值：取出第一个id值，#{list[0]} 
  ```
    