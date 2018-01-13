package main.java.com.looye.stream.test;

import main.java.com.looye.lambda.bean.Apple;
import main.java.com.looye.lambda.util.AppleUtil;

import java.util.List;
import java.util.Optional;

/**
 * Created by looye on 2018/1/13.
 *
 * @author looye
 * @date 2018/1/13
 */
public class DemoTwo {
    static int i = 0;
    static int j = 0;
    static int k = 0;

    public static void main(String[] args) {
        List<Apple> dishInfoList = AppleUtil.generateList();
        Optional<Apple> testApple = dishInfoList.stream()
                .filter(apple -> "green".equals(apple.getColor()))
                .peek(apple -> System.out.println(apple.getColor()))
                .findAny();
        boolean hasGreen = testApple.isPresent();
        System.out.println(hasGreen);

        testApple.ifPresent(apple -> System.out.println(apple.getPrice()));
        Apple apple1 = testApple.get();
        Apple apple2 = testApple.orElse(new Apple());

        hasGreen = dishInfoList.stream()
                .peek(apple -> System.out.println(apple.getColor() + ++i))//遍历次数
                .anyMatch(apple -> "green".equals(apple.getColor()));
        System.out.println(hasGreen + ";i=" + i);

        boolean noGreen = dishInfoList.stream()
                .peek(apple -> System.out.println(apple.getColor() + ++j))//遍历次数
                .noneMatch(apple -> "green".equals(apple.getColor()));
        System.out.println(noGreen + ";j=" + j);

        boolean allGreen = dishInfoList.stream()
                .peek(apple -> System.out.println(apple.getColor() + ++k))//遍历次数
                .allMatch(apple -> "green".equals(apple.getColor()));
        System.out.println(allGreen + ";k=" + k);

    }


}
