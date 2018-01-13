package main.java.com.looye.stream.test;

import java.util.HashMap;

/**
 * Created by looye on 2018/1/8.
 *
 * @author looye
 * @date 2018/1/8
 */
public class HashTest {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>(16);
        map.put(1, 1);
        for (int i = 1; i < 10; i++) {
            map.put(i * 16, i * 16);
        }

        int h;
        String a = "a";
        h = a.hashCode();
        System.out.println(h);
        int j = h >>> 16;
        System.out.println(j);


        int mm;
        int kk = (mm = a.hashCode()) ^ (mm >>> 16);
        System.out.println(kk);
    }
}
