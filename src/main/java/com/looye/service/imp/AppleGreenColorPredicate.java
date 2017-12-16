package main.java.com.looye.service.imp;


import main.java.com.looye.bean.Apple;
import main.java.com.looye.service.ApplePredicate;

/**
 * Created by looye on 2017/12/9.
 *
 * @author looye
 * @date 2017/12/9
 */
public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
