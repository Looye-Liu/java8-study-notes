package main.java.com.looye.lambda.test;

import main.java.com.looye.lambda.bean.Apple;
import main.java.com.looye.lambda.bean.Fruit;
import main.java.com.looye.lambda.bean.Orange;
import main.java.com.looye.lambda.service.TriFunction;
import main.java.com.looye.lambda.util.AppleUtil;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

/**
 * Created by looye on 2018/1/1.
 * 方法的引用
 *
 * @author looye
 * @date 2018/1/1
 */
public class MethodQuote {

    public static void main(String[] args) {
        List<Apple> appleList = AppleUtil.generateList();
        //匿名类
        appleList.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        //Lambda
        appleList.sort((apple1, apple2) -> apple1.getWeight().compareTo(apple2.getWeight()));

        //使用方法引用和java.util.Comparator
        appleList.sort(Comparator.comparing(Apple::getPrice));

        Consumer<String> consumer = System.out::print;
        consumer.accept("aaa");

        Function<String, Integer> function = Integer::valueOf;
        Function<Integer, String> function1 = String::valueOf;

        Function<Integer, String> function2 = "aa"::substring;
        function2.apply(3);
        BiFunction<Integer, String, String> biFunction = (Integer i, String str) -> str.substring(i);
        biFunction.apply(2, "bbb");

        BiFunction<String, Integer, String> biFunction2 = String::substring;
        biFunction2.apply("aa", 1);

        AppleUtil.printApple(appleList.get(0), System.out::print);


        //无参构造方法
        Supplier<Apple> appleSupplier1 = () -> new Apple();
        Supplier<Apple> appleSupplier = Apple::new;
        Apple apple = appleSupplier.get();

        //有参构造方法
        Function<String, Apple> appleFunction1 = (String green) -> new Apple(green);
        Function<String, Apple> appleFunction = Apple::new;
        Apple apple1 = appleFunction.apply("green");

        //水果生产
        Map<String, BiFunction<Integer, String, Fruit>> fruitMap = new HashMap<>(16);
        fruitMap.put("apple", Apple::new);
        fruitMap.put("orange", Orange::new);

        //来一杯10块钱的绿苹果
        Fruit fruitApple = fruitMap.get("apple").apply(10, "green");

        //来一杯8元的橙汁
        Fruit fruitOrange = fruitMap.get("orange").apply(8, "orange");

        //三个参数，自己构建函数接口TriFunction
        Map<String, TriFunction<Integer, Integer, String, Fruit>> fruitMap2 = new HashMap<>(16);
        fruitMap2.put("apple", Apple::new);
        //15元，重量为10的绿色苹果
        Fruit fruitApple1 = fruitMap2.get("apple").apply(15, 10, "green");
    }


}
