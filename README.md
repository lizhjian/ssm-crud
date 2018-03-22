# ssm-crud
基于Spring-mybatis简单的员工增删改查demo供大家学习
问题1：org.apache.ibatis.binding.BindingException: Invalid bound statement (not found)异常
将xml文件改到资源文件下加载
项目搭建过程

## 1、新建maven-webapp项目

## 2、引入项目依赖的jar包
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

## 3、配置web.xml
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
       
##  4、配置springmvc.xml
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
  
##  5、配置applicationContext.xml
  
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
  
  

## 6、mybaits-config.xml配置
 
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
  