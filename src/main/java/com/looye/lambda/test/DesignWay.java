package main.java.com.looye.lambda.test;

import main.java.com.looye.lambda.bean.Apple;
import main.java.com.looye.lambda.service.ApplePredicate;
import main.java.com.looye.lambda.service.imp.AppleGreenColorPredicate;
import main.java.com.looye.lambda.service.imp.AppleRedAndHeavyPredicate;
import main.java.com.looye.lambda.util.AppleUtil;

import java.util.List;

/**
 * Created by looye on 2017/12/16.
 *
 * @author looye
 * @date 2017/12/16
 */
public class DesignWay {
    public static void main(String[] args) {
        List<Apple> appleList = AppleUtil.generateList();

        /********************策略模式*******************/
        List<Apple> greenApples2 = AppleUtil.filterApples(appleList, new AppleGreenColorPredicate());
        System.out.println("----greenApples2----" + greenApples2.size());

        List<Apple> redAndBigApples = AppleUtil.filterApples(appleList, new AppleRedAndHeavyPredicate());
        System.out.println("----redAndBigApples----" + redAndBigApples.size());

        /********************匿名类*******************/
        List<Apple> yellowAndSamllApples = AppleUtil.filterApples(appleList, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "yellow".equals(apple.getColor()) && apple.getWeight() < 15;
            }
        });
        System.out.println("----yellowAndSamllApples----" + yellowAndSamllApples.size());
    }

}
