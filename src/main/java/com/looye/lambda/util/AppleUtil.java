package main.java.com.looye.lambda.util;

import main.java.com.looye.lambda.bean.Apple;
import main.java.com.looye.lambda.service.ApplePredicate;
import main.java.com.looye.lambda.service.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

/**
 * Created by looye on 2017/12/16.
 *
 * @author looye
 * @date 2017/12/16
 */
public class AppleUtil {

    public static void testMethod() {

    }

    public static void printApple(Apple apple, Consumer<Apple> consumer) {
        consumer.accept(apple);
    }

    public static List<Apple> generateList() {
        List<Apple> appleList = new ArrayList<>();
        Random random = new Random();
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
            apple.setPrice(random.nextInt(10) * i);
        }
        return appleList;
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
}
