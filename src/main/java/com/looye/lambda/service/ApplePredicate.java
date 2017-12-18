package main.java.com.looye.lambda.service;

import main.java.com.looye.lambda.bean.Apple;

/**
 * Created by looye on 2017/12/9.
 *
 * @author looye
 * @date 2017/12/9
 */
public interface ApplePredicate {
    boolean test(Apple apple);
}
