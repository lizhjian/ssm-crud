package com.wuxin.test;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MGBTest {
    public static  void main(String[] args) throws Exception{
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
//private final static int threadCount = 200;
//
//    //static Logger logger = LoggerFactory.getLogger(MGBTest.class);
//
//
//    public static void main(String[] args) throws Exception {
//
//        MGBTest.testRun(11111);
//        MGBTest.testRun(22222);
//
//
//
//    }
//
//    private static void test(int flag,int threadNum) throws Exception {
//        Thread.sleep(100);
//        System.out.println("flag--->"+flag + "----->"+threadNum);
//        Thread.sleep(100);
//    }
//
//    public static void testRun(final int flag) throws Exception{
//
//        ExecutorService exec = Executors.newCachedThreadPool();
//
//        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
//
//        for (int i = 0; i < threadCount; i++) {
//            final int threadNum = i;
//            exec.execute(new Runnable() {
//                             public void run() {
//                                 try {
//                                     test( flag,threadNum);
//                                 } catch (Exception e) {
//                                     System.out.println("exception-->"+e);;
//                                 } finally {
//                                     countDownLatch.countDown();
//                                 }
//                             }
//                         }
//            );
//        }
//        countDownLatch.await();
//        System.out.println("finish");
//        exec.shutdown();
//
//    }
}
