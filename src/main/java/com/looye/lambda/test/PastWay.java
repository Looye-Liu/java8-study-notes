package main.java.com.looye.lambda.test;

import main.java.com.looye.lambda.bean.Apple;
import main.java.com.looye.lambda.util.AppleUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by looye on 2017/12/16.
 *
 * @author looye
 * @date 2017/12/16
 */
public class PastWay {
    public static void main(String[] args) {
        List<Apple> appleList = AppleUtil.generateList();

        /********************基本方式*******************/
        List<Apple> greenApples = filterGreenApples(appleList);
        System.out.println("----greenApples----" + greenApples.size());

        List<Apple> redApples = filterApplesByColor(appleList, "red");
        System.out.println("----redApples----" + redApples.size());

        List<Apple> bigApples = filterApplesByWeight(appleList, 10);
        System.out.println("----bigApples----" + bigApples.size());

        List<Apple> yellowApples = filterApples(appleList, 12, "yellow", true);
        System.out.println("----yellowApples----" + yellowApples.size());

    }

    /**
     * 筛选绿色苹果
     *
     * @param appleList
     * @return
     */
    private static List<Apple> filterGreenApples(List<Apple> appleList) {
        List<Apple> result = new ArrayList<>();
        for (Apple app : appleList) {
            if ("green".equals(app.getColor())) {
                result.add(app);
            }
        }
        return result;
    }

    /**
     * 筛选红色苹果
     *
     * @param appleList
     * @return
     */
    private static List<Apple> filterRedApples(List<Apple> appleList) {
        List<Apple> result = new ArrayList<>();
        for (Apple app : appleList) {
            if ("red".equals(app.getColor())) {
                result.add(app);
            }
        }
        return result;
    }

    /**
     * 通过颜色筛选苹果
     *
     * @param appleList
     * @param coler
     * @return
     */
    private static List<Apple> filterApplesByColor(List<Apple> appleList, String coler) {
        if (null == coler || coler.trim().length() == 0) {
            return new ArrayList<>();
        }
        List<Apple> result = new ArrayList<>();
        for (Apple app : appleList) {
            if (coler.equals(app.getColor())) {
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
    private static List<Apple> filterApplesByWeight(List<Apple> appleList, int weight) {
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
    private static List<Apple> filterApples(List<Apple> appleList, int weight, String color, boolean colorFlag) {
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
}
