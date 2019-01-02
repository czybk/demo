package main.java.com.fly.decorator;

/**
 * Created by SWan on 2017/5/16.
 */
public class Sorbet extends Beverage {

    public Sorbet() {
        detail = "Sorbet";
    }
    //计算价格
    public double price() {
        return 3.0;
    }
}
