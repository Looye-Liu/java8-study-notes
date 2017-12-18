package main.java.com.looye.lambda.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by looye on 2017/12/16.
 *
 * @author looye
 * @date 2017/12/16
 */
public class CommonUtil {
    /**
     * 根据条件p过滤集合
     *
     * @param list      需要过滤的集合
     * @param predicate 过滤规则
     * @param <T>
     * @return 满足条件p的集合
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        list.forEach((T t) -> {
            if (predicate.test(t)) {
                result.add(t);
            }
        });
        return result;
    }

    /**
     * 对于集合来说，总想做点什么
     *
     * @param list     需要操作集合
     * @param consumer 操作行为
     * @param <T>
     */
    public static <T> void forEach(List<T> list, Consumer<T> consumer) {
        list.forEach(consumer);
    }

    /**
     * 使用集合进行一些列操作
     * 并返回对应类型R的集合
     *
     * @param list     元数据集合
     * @param function 对集合操作行为
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        list.forEach((T t) -> result.add(function.apply(t)));
        return result;
    }
}
