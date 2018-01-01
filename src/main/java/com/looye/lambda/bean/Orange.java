package main.java.com.looye.lambda.bean;

/**
 * Created by looye on 2018/1/1.
 *
 * @author looye
 * @date 2018/1/1
 */
public class Orange extends Fruit {
    public Orange() {
    }

    public Orange(Integer price, Integer weight, String color) {
        this.price = price;
        this.weight = weight;
        this.color = color;
    }

    public Orange(Integer price, String color) {
        this.color = color;
        this.price = price;
    }

    public Orange(Integer weight, Integer price) {
        super.price = price;
        super.weight = weight;
    }
}
