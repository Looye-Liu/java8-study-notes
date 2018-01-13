package main.java.com.looye.stream.test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by looye on 2018/1/13.
 *
 * @author looye
 * @date 2018/1/13
 */
public class StreamApp {

    public static void main(String[] args) {
        floatMapTest1();
        System.out.println("------------------------");
        floatMapTest2();
        System.out.println("------------------------");
        floatMapTest3();
    }

    /**
     * 给定一个数组
     * 返回其中唯一的字符集合
     */
    public static void floatMapTest1() {
        String[] testStr = new String[]{"Hello", "World"};
        //返回["H","e","l","o","w","r","d"]
        List<String> testStr2 = Arrays.stream(testStr)
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)//流合并
                .distinct()//唯一筛选
                .peek(System.out::print)
                .collect(toList());
    }

    /**
     * 给定一个[1,2,3,4,5]
     * 返回对应数的平方 [2,4,9,16,25]
     */
    public static void floatMapTest2() {
        int[] testInteger = new int[]{1, 2, 3, 4, 5};
        List<Integer> testInteger2 = Arrays.stream(testInteger)
                .map(i -> i * i)
                .peek(System.out::println)
                .boxed()//装箱操作
                .collect(toList());
    }

    /**
     * 给定两个数组
     * 返回数组的对应两两组合数对
     */
    public static void floatMapTest3() {
        int[] testInteger1 = new int[]{1, 2, 3, 4, 5};
        int[] testInteger2 = new int[]{11, 12, 13, 14, 15};
        List<int[]> a = Arrays.stream(testInteger1)
                .boxed()//装箱操作
                .flatMap(i -> Arrays.stream(testInteger2)
                        .boxed()
                        .map(j -> new int[]{i, j})
                )
                .peek((int[] temp) -> System.out.println(temp[0] + "," + temp[1]))
                .collect(toList());
        System.out.println("------------------------");
        /********************两数能被3整除的组合**************************************/
        List<Integer> testInteger3 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> testInteger4 = Arrays.asList(11, 12, 13, 14, 15);
        List<int[]> b = testInteger3.stream()
                .flatMap(i -> testInteger4.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .peek((int[] temp) -> System.out.println(temp[0] + "," + temp[1]))
                .collect(toList());
    }

}
