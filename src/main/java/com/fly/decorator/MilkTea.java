package main.java.com.fly.decorator;

/**
 * Created by SWan on 2017/5/16.
 */
public class MilkTea extends Beverage {

    public MilkTea(){
        detail = "MilkTea";
    }

    //计算价格
    public double price() {
        return 4.0;
    }
}
