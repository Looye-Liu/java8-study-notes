package main.java.com.looye.stream.test;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * Created by looye on 2018/1/13.
 *
 * @author looye
 * @date 2018/1/13
 */
public class DemoThree {

    public static void main(String[] args) {
        int[] param = new int[]{1, 3, 4, 5, 6, 7, 8, 0, 4, 66, 44, 22, 11, 66};
        int sum = Arrays.stream(param).sum();
        int sum2 = Arrays.stream(param).reduce(0, (a, b) -> a + b);
        OptionalInt sum3 = Arrays.stream(param).reduce((a, b) -> a + b);
        System.out.println(sum + ";" + sum2 + ";" + sum3);

        OptionalInt max = Arrays.stream(param).max();
        OptionalInt max2 = Arrays.stream(param).reduce(Integer::max);
        System.out.println(max + ";" + max2);

        OptionalInt min = Arrays.stream(param).min();
        OptionalInt min2 = Arrays.stream(param).reduce(Integer::min);
        System.out.println(min + ";" + min2);

        int count = Arrays.stream(param).map(d -> 1).reduce(0, Integer::sum);
        long count2 = Arrays.stream(param).count();
        System.out.println(count + ";" + count2);
    }
}
