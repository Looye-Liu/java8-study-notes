package main.java.com.looye.stream.util;

import main.java.com.looye.stream.bean.DishInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by looye on 2018/1/2.
 *
 * @author looye
 * @date 2018/1/2
 */
public class DishUtil {
    private static Random random = new Random();

    public static List<DishInfo> generateDishList() {
        List<DishInfo> result = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            int ran = random.nextInt(99);
            DishInfo dishInfo = new DishInfo(i, UUID.randomUUID().toString().substring(0, 6), (double) ran);
            result.add(dishInfo);
        }
        return result;
    }
}
