package main.java.com.looye.java8;



import main.java.com.looye.bean.Apple;
import main.java.com.looye.service.ApplePredicate;
import main.java.com.looye.service.Predicate;
import main.java.com.looye.service.imp.AppleGreenColorPredicate;
import main.java.com.looye.service.imp.AppleRedAndHeavyPredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by looye on 2017/12/9.
 *
 * @author looye
 * @date 2017/12/9
 */
public class MyLambda {

    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Apple apple = new Apple();
            appleList.add(apple);

            String color;
            if (i % 3 == 0) {
                color = "green";
            } else if (i % 3 == 1) {
                color = "red";
            } else {
                color = "yellow";
            }
            apple.setColor(color);
            apple.setWeight(i);
        }

        /********************基本方式*******************/
        List<Apple> greenApples = filterGreenApples(appleList);
        System.out.println("----greenApples----" + greenApples.size());

        List<Apple> redApples = filterApplesByColor(appleList, "red");
        System.out.println("----redApples----" + redApples.size());

        List<Apple> bigApples = filterApplesByWeight(appleList, 10);
        System.out.println("----bigApples----" + bigApples.size());

        List<Apple> yellowApples = filterApples(appleList, 12, "yellow", true);
        System.out.println("----yellowApples----" + yellowApples.size());


        /********************策略模式*******************/
        List<Apple> greenApples2 = filterApples(appleList, new AppleGreenColorPredicate());
        System.out.println("----greenApples2----" + greenApples2.size());

        List<Apple> redAndBigApples = filterApples(appleList, new AppleRedAndHeavyPredicate());
        System.out.println("----redAndBigApples----" + redAndBigApples.size());

        /********************匿名类*******************/
        List<Apple> yellowAndSamllApples = filterApples(appleList, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "yellow".equals(apple.getColor()) && apple.getWeight() < 15;
            }
        });
        System.out.println("----yellowAndSamllApples----" + yellowAndSamllApples.size());


        /********************Lambda*******************/
        List<Apple> yellowAndSamllApples2 = filterApples(appleList, (Apple apple) -> "yellow".equals(apple.getColor()) && apple.getWeight() < 15);
        System.out.println("----yellowAndSamllApples2----" + yellowAndSamllApples2.size());

        List<Apple> yellowAndSamllApples3 = filter(appleList,
                (Apple apple) -> "yellow".equals(apple.getColor()) && apple.getWeight() < 15);
        System.out.println("----yellowAndSamllApples3----" + yellowAndSamllApples3.size());

        List<Apple> yellowAndSamllApples4 = filter(appleList, (Apple apple) -> {
            return "yellow".equals(apple.getColor()) && apple.getWeight() < 15;
        });
        System.out.println("----yellowAndSamllApples4----" + yellowAndSamllApples4.size());

        List<Apple> yellowAndSamllApples5 = filter(appleList, (Apple apple) -> methodCode(apple));
        System.out.println("----yellowAndSamllApples5----" + yellowAndSamllApples5.size());

        yellowAndSamllApples5.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() >= o2.getWeight() ? 1 : 0;
            }
        });
        yellowAndSamllApples5.sort((Apple apple1, Apple apple2) -> apple1.getWeight() >= apple2.getWeight() ? 1 : 0);

        List<Integer> evenNumbers = filter(Arrays.asList(3, 4, 1, 7, 9, 6, 7, 8, 9, 2, 3), (Integer i) -> i % 2 == 0);
        System.out.println("----evenNumbers----" + evenNumbers.size());

        evenNumbers.sort((Integer i, Integer j) -> i <= j ? 1 : 0);
        System.out.println(evenNumbers.get(0));

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

    }

    public static boolean methodCode(Apple apple) {
        return "yellow".equals(apple.getColor()) && apple.getWeight() < 15;
    }

    /**
     * 筛选绿色苹果
     *
     * @param appleList
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> appleList) {
        List<Apple> result = new ArrayList<>();
        for (Apple app : appleList) {
            if ("green".equals(app.getColor())) {
                result.add(app);
            }
        }
        return result;
    }

    /**
     * 通过颜色筛选苹果
     *
     * @param appleList
     * @param coller
     * @return
     */
    public static List<Apple> filterApplesByColor(List<Apple> appleList, String coller) {
        if (null == coller || coller.trim().length() == 0) {
            return new ArrayList<>();
        }
        List<Apple> result = new ArrayList<>();
        for (Apple app : appleList) {
            if (coller.equals(app.getColor())) {
                result.add(app);
            }
        }
        return result;
    }

    /**
     * 通过重量筛选苹果
     *
     * @param appleList
     * @param weight
     * @return
     */
    public static List<Apple> filterApplesByWeight(List<Apple> appleList, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple app : appleList) {
            if (weight <= app.getWeight()) {
                result.add(app);
            }
        }
        return result;
    }

    /**
     * 苹果筛选
     *
     * @param appleList
     * @param weight
     * @param colorFlag
     * @param color
     * @return
     */
    public static List<Apple> filterApples(List<Apple> appleList, int weight, String color, boolean colorFlag) {
        List<Apple> result = new ArrayList<>();
        for (Apple app : appleList) {
            if (colorFlag) {
                if (null != color && color.equals(app.getColor())) {
                    result.add(app);
                }
            } else {
                if (weight <= app.getWeight()) {
                    result.add(app);
                }
            }
        }
        return result;
    }

    /**
     * 通过筛选接口获取满足条件的苹果
     *
     * @param appleList
     * @param predicate
     * @return
     */
    public static List<Apple> filterApples(List<Apple> appleList, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : appleList) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 过滤list
     *
     * @param list
     * @param predicate
     * @param <T>
     * @return 满足predicate条件的list
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
}
