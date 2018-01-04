package main.java.com.looye.stream.test;

import main.java.com.looye.stream.bean.DishInfo;
import main.java.com.looye.stream.util.DishUtil;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by looye on 2018/1/2.
 *
 * @author looye
 * @date 2018/1/2
 */
public class DemoOne {
    public static void main(String[] args) {
        List<DishInfo> dishInfoList = DishUtil.generateDishList();

        //获取价格低于50，并按价格排序的前20道菜品名称
        //串行处理
        List<String> lowPriceDishList = dishInfoList.stream()
                .filter(dishInfo -> dishInfo.getPrice() < 50)
                .sorted(Comparator.comparing(DishInfo::getPrice))
                .peek((dishInfo -> System.out.println("id :" + dishInfo.getId())))
                .map(DishInfo::getName)
                .peek((name) -> System.out.println("result name:" + name))
                .limit(20)
                .collect(toList());
        System.out.println("--------first end----------" + lowPriceDishList.size());

        //并行处理
        List<String> lowPriceDishList2 = dishInfoList.parallelStream()
                .filter(dishInfo -> dishInfo.getPrice() < 50)
                .sorted(Comparator.comparing(DishInfo::getPrice))
                .peek((dishInfo -> System.out.println("name:" + dishInfo.getName())))
                .map(DishInfo::getName)
                .peek((name) -> System.out.println("result name:" + name))
                .limit(20)
                .collect(toList());
        System.out.println("--------second end----------" + lowPriceDishList2.size());

        Stream<String> dishNameStream = lowPriceDishList.stream();
        dishNameStream.forEach(System.out::println);
        dishNameStream.forEach(System.out::println);
    }
}
