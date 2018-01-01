package main.java.com.looye.lambda.bean;

/**
 * Created by looye on 2017/12/9.
 *
 * @author looye
 * @date 2017/12/9
 */
public class Apple extends Fruit {
    public Apple() {
    }

    public Apple(Integer price, Integer weight, String color) {
        this.price = price;
        this.weight = weight;
        this.color = color;
    }

    public Apple(Integer weight, Integer price) {
        this.price = price;
        this.weight = weight;
    }

    public Apple(Integer price, String color) {
        this.price = price;
        this.color = color;
    }

    public Apple(String color) {
        this.color = color;
    }

    public Apple(String color, Integer weight, int day) {
        this.color = color;
        this.weight = weight;
        this.day = day;
    }

    private int day;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return new StringBuffer("color:").append(this.color).append(",")
                .append("price:").append(this.price).append(",")
                .append("weight:").append(this.weight).append(",")
                .append("day:").append(this.day)
                .toString();
    }
}
