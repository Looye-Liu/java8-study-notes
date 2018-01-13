package main.java.com.looye.lambda.service;

import main.java.com.looye.lambda.bean.Apple;

/**
 * Created by looye on 2017/12/9.
 *
 * @author looye
 * @date 2017/12/9
 */
@FunctionalInterface
public interface ApplePredicate {
    boolean test(Apple apple);

    /**
     * 测试
     */
    default void test() {
        System.out.println("this is test interface");
    }

}
