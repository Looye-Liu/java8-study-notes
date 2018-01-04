package main.java.com.looye.stream.bean;

/**
 * Created by looye on 2018/1/2.
 *
 * @author looye
 * @date 2018/1/2
 */
public class DishInfo {
    private Integer id;
    private String name;
    private Double price;

    public DishInfo(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
