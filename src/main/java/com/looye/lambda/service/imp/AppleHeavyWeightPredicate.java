package main.java.com.looye.lambda.service.imp;

import main.java.com.looye.lambda.bean.Apple;
import main.java.com.looye.lambda.service.ApplePredicate;

/**
 * Created by looye on 2017/12/9.
 *
 * @author looye
 * @date 2017/12/9
 */
public class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() >= 10;
    }
}
