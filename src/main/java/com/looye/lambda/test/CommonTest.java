package main.java.com.looye.lambda.test;

import main.java.com.looye.lambda.bean.Apple;
import main.java.com.looye.lambda.util.AppleUtil;
import main.java.com.looye.lambda.util.CommonUtil;

import java.util.List;
import java.util.function.Function;

/**
 * Created by looye on 2017/12/16.
 *
 * @author looye
 * @date 2017/12/16
 */
public class CommonTest {
    public static void main(String[] args) {
        List<Apple> appleList = AppleUtil.generateList();

        //获取绿色苹果
        List<Apple> greenApples = CommonUtil.filter(appleList, (Apple apple) -> "green".equals(apple.getColor()));

        //设置绿色苹果已经有5天了
        CommonUtil.forEach(greenApples, (Apple apple) -> apple.setDay(5));

        //获取苹果的颜色
        List<String> collers = CommonUtil.map(appleList, (Apple apple) -> apple.getColor());

        Function<String, String> function = (String s) -> "this" + s;
    }
}
