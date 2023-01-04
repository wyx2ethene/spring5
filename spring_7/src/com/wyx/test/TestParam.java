package com.wyx.test;

import com.wyx.config.TxConfig;
import com.wyx.service.TotalService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//探究propagation参数
public class TestParam {

    @Test
    /**
     * propagation=required，当前方法不是事务方法，其子方法是事务方法
     * 测试结果：一切正常执行
     */
    public void testParam_1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        TotalService totalService = context.getBean("totalService", TotalService.class);
        //当前方法不是事务方法，其子方法是事务方法
        totalService.transfer("1", "add");
    }

    @Test
    /**
     * propagation=required，当前方法不是事务方法，其子方法是事务方法，在当前方法的子方法之间模拟异常
     * 测试结果：当前方法报错，但第一个子方法完成事务操作，第二个子方法由于主方法报错未能执行
     */
    public void testParam_2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        TotalService totalService = context.getBean("totalService", TotalService.class);
        totalService.transfer("1", "add");
    }

    @Test
    /**
     * 1. propagation=required，当前方法不是事务方法，其子方法是事务方法，
     * 测试结果：若在当前方法结尾模拟异常，则当前方法报错，但两个子方法均完成事务操作，若在当前方法开头模拟异常，则直接报错，子方法根本执行不到
     *
     * 2. propagation=required，当前方法不是事务方法，其子方法是事务方法，在子方法中模拟异常，
     * 测试结果：若在第一个子方法中模拟异常，则第一个子方法事务回滚，由于第一个子方法抛出异常，代码根本执行不到第二个子方法
     * 若在第二个子方法中模拟异常，则第一个子方法完成事务操作，第二个子方法抛出异常，回滚事务
     */
    public void testParam_3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        TotalService totalService = context.getBean("totalService", TotalService.class);
        totalService.transfer("1", "add");
    }

    @Test
    /**
     * 1. propagation=required, 当前方法是事务方法, 其子方法不是事务方法，测试结果正常
     * 2. propagation=required, 当前方法是事务方法, 其子方法不是事务方法，当前方法中模拟异常，测试结果，事务回滚，数据库未发生变化
     * 3. propagation=required, 当前方法是事务方法，其子方法不是事务方法，在子方法中模拟异常，测试结果，事务回滚，数据库未发生变化
     */
    public void testParam_4() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        TotalService totalService = context.getBean("totalService", TotalService.class);
        totalService.transfer("1", "add");
    }

    @Test
    /**
     * 1. propagation=required，当前方法和子方法均为事务方法，当前方法中模拟异常，测试结果，事务回滚，数据库未发生变化
     * 2. propagation=required，当前方法和子方法均为事务方法，子方法中模拟异常，测试结果，事务回滚，数据库未发生变化，即子方法加入了当前方法所在事务
     */
    public void testParam_5() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        TotalService totalService = context.getBean("totalService", TotalService.class);
        totalService.transfer("1", "add");
    }

    @Test
    /**
     * 当前方法的propagation=required
     * UserService的propagation=required_new
     * LogService的propagation=required
     * 当前方法中模拟异常，测试结果：
     * 当前方法开头模拟，程序也就跑不下去，数据库不动
     * 当前方法中间模拟，由于UserService在程序最后，执行不到，而LogService加入当前方法的事务回滚事务，不做操作
     * 当前方法尾部模拟，UserService完成事务操作，而LogService由于加入了当前方法的事务而回滚
     *
     * required_new对应的子方法中模拟异常，测试结果：当前方法感知到异常，回滚事务，数据库不变化
     * required对应的子方法中模拟异常，测试结果：当前方法感知到异常，回滚事务，UserService在下面根本执行不到，如果二者位置交换，则UserService完成事务操作
     *
     */
    public void testParam_6() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        TotalService totalService = context.getBean("totalService", TotalService.class);
        totalService.transfer("1", "add");
    }
}
