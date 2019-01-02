package main.java.com.fly.decorator;

/**
 * Created by SWan on 2017/5/16.
 */
public class Strawberry extends CondimentDecorator {
    private Beverage beverage;

    public Strawberry(Beverage beverage) {
        this.beverage = beverage;
    }

    //获取详细信息 被装饰对象详细信息与装饰者详细信息组合
    public String getDetail() {
        return beverage.getDetail() + "Strawberry";
    }

    //计算装饰之后的价格 被装饰对象的价格加上装饰者的价格
    public double price() {
        return beverage.price() + 2.5;//草莓2.5元
    }
}
