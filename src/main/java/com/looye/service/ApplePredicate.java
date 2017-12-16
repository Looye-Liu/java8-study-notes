package main.java.com.looye.service;

import main.java.com.looye.bean.Apple;

/**
 * Created by looye on 2017/12/9.
 *
 * @author looye
 * @date 2017/12/9
 */
public interface ApplePredicate {
    boolean test(Apple apple);
}
