package main.java.com.looye.lambda.test;

import main.java.com.looye.lambda.bean.Apple;
import main.java.com.looye.lambda.util.AppleUtil;

import java.util.List;

/**
 * Created by looye on 2017/12/25.
 *
 * @author looye
 * @date 2017/12/25
 */
public class LambdaWarning {

    public static void main(String[] args) {
        List<Apple> appleList = AppleUtil.generateList();
        final String finalString = "finalString";//显示声明final
        String onceString = "onceString";//只赋值一次
        String tempString = "tempString";//存在多次赋值
        List<Apple> greenApples = AppleUtil.filterApples(appleList, apple -> {
            System.out.println("finalString:" + finalString);
            System.out.println("onceString" + onceString);
            System.out.println("tempString:" + tempString);
            return "green".equals(apple.getColor());
        });
        //tempString = "tempString";

        new Thread(() -> {
            appleList.forEach(apple -> apple.setColor("yellow"));
        }).start();

        new Thread(() -> {
            appleList.forEach((apple) -> apple.setColor("red"));
        }).start();

        appleList.forEach((Apple apple) -> System.out.println("color:" + apple.getColor()));
    }
}
