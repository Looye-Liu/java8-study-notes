package main.java.com.looye.lambda.service;

/**
 * Created by looye on 2017/12/9.
 *
 * @author looye
 * @date 2017/12/9
 */
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
