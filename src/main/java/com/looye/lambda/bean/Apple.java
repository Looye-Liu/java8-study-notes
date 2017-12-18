package main.java.com.looye.lambda.bean;

/**
 * Created by looye on 2017/12/9.
 *
 * @author looye
 * @date 2017/12/9
 */
public class Apple {
    public Apple() {
    }

    public Apple(String color, int weight, int day) {
        this.color = color;
        this.weight = weight;
        this.day = day;
    }

    private String color;

    private int weight;

    private int day;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
