package main.java.com.looye.lambda.service;

/**
 * Created by looye on 2018/1/1.
 *
 * @author looye
 * @date 2018/1/1
 */
@FunctionalInterface
public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
