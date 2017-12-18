package main.java.com.looye.lambda.test;


import main.java.com.looye.lambda.bean.Apple;
import main.java.com.looye.lambda.service.ApplePredicate;
import main.java.com.looye.lambda.util.AppleUtil;
import main.java.com.looye.lambda.util.CommonUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by looye on 2017/12/9.
 *
 * @author looye
 * @date 2017/12/9
 */
public class LambdaWay {

    public static void main(String[] args) {
        List<Apple> appleList = AppleUtil.generateList();

        /********************匿名类*******************/
        List<Apple> yellowAndSamllApples = AppleUtil.filterApples(appleList, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "yellow".equals(apple.getColor()) && apple.getWeight() < 15;
            }
        });
        System.out.println("----yellowAndSamllApples----" + yellowAndSamllApples.size());

        /********************Lambda*******************/
        List<Apple> yellowAndSamllApples2 = AppleUtil.filterApples(appleList,
                (Apple apple) -> "yellow".equals(apple.getColor()) && apple.getWeight() < 15);
        System.out.println("----yellowAndSamllApples2----" + yellowAndSamllApples2.size());

        List<Apple> yellowAndSamllApples3 = CommonUtil.filter(appleList,
                (Apple apple) -> "yellow".equals(apple.getColor()) && apple.getWeight() < 15);
        System.out.println("----yellowAndSamllApples3----" + yellowAndSamllApples3.size());

        List<Apple> yellowAndSamllApples4 = CommonUtil.filter(appleList,
                (Apple apple) -> {
                    return "yellow".equals(apple.getColor()) && apple.getWeight() < 15;
                });
        System.out.println("----yellowAndSamllApples4----" + yellowAndSamllApples4.size());

        List<Apple> yellowAndSamllApples5 = CommonUtil.filter(appleList,
                (Apple apple) -> methodCode(apple));
        System.out.println("----yellowAndSamllApples5----" + yellowAndSamllApples5.size());

        yellowAndSamllApples5.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() >= o2.getWeight() ? 1 : 0;
            }
        });
        yellowAndSamllApples5.sort((Apple apple1, Apple apple2) -> apple1.getWeight() >= apple2.getWeight() ? 1 : 0);

        List<Integer> evenNumbers = CommonUtil.filter(Arrays.asList(3, 4, 1, 7, 9, 6, 7, 8, 9, 2, 3), (Integer i) -> i % 2 == 0);
        System.out.println("----evenNumbers----" + evenNumbers.size());

        evenNumbers.sort((Integer i, Integer j) -> i <= j ? 1 : 0);
        System.out.println(evenNumbers.get(0));

        //线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("----wahaha----");
            }
        }).start();

        new Thread(() -> System.out.println("----wahaha2----")).start();

        Comparator<Apple> comparator = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() > o2.getWeight() ? 1 : 0;
            }
        };

        Comparator<Apple> comparator2 = (o1, o2) -> o1.getWeight() > o2.getWeight() ? 1 : 0;

    }

    public static boolean methodCode(Apple apple) {
        return "yellow".equals(apple.getColor()) && apple.getWeight() < 15;
    }
}
