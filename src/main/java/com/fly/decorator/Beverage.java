package main.java.com.fly.decorator;

/**
 * Created by SWan on 2017/5/16.
 */
public abstract class Beverage {
    private String size;
    String detail = "Unknown Beverage";

    public String getDetail() {
        return detail;
    }

    public abstract double price();

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
