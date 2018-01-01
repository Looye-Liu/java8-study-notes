package main.java.com.looye.lambda.test;

import java.util.function.DoubleFunction;
import java.util.function.Function;

/**
 * Created by looye on 2018/1/1.
 * 函数复合例子
 *
 * @author looye
 * @date 2018/1/1
 */
public class ExampleOne {

    public static void main(String[] args) {
        //f(x) = x + 1
        Function<Integer, Integer> f = x -> x + 1;
        //g(x) = x * 2;
        Function<Integer, Integer> g = x -> x * 2;
        //h = g(f(x))
        Function<Integer, Integer> h = f.andThen(g);

        //x=11时的g(f(x))
        int result = h.apply(11);
        System.out.println("g(f(11))=" + result);

        //x=11时的f(g(x))
        Function<Integer, Integer> w = f.compose(g);
        result = w.apply(11);
        System.out.println("f(g(11))=" + result);

        //f(x) = x + 10的面积
        double x1 = 3.12d;
        double x2 = 7.33d;
        double area = integrate((double x) -> x + 10, x1, x2);
        System.out.println("x1=" + x1 + ";x2=" + x2 + ";area=" + area);
    }

    private static double integrate(DoubleFunction<Double> f, double x1, double x2) {
        return (f.apply(x1) + f.apply(x2)) * Math.abs(x2 - x1) / 2.0;
    }
}
