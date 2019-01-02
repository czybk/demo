package main.java.com.fly.decorator;

/**
 * Created by SWan on 2017/5/16.
 */
public class Client{

    public static void main(String[] args) {
        Beverage beverage = new MilkTea();
        //顾客订了一杯原味奶茶
        System.out.println("beverage:" + beverage.getDetail() + ",price:" + beverage.price());

        Beverage sorbet = new Sorbet();//顾客订了一杯冰沙
        sorbet = new Pearl(sorbet);//需要加入珍珠
        sorbet = new Mung(sorbet);//需要加入绿豆
        //计算价格
        System.out.println("sorbet:" + sorbet.getDetail() + ",price:" + sorbet.price());

        Beverage milkShake = new MilkShake();//顾客顶了一杯奶昔
        milkShake = new Pearl(milkShake);//需要加入珍珠
        milkShake = new Mung(milkShake);//需要加入绿豆
        milkShake = new Strawberry(milkShake);//需要加入草莓
        //计算价格
        System.out.println("milkShake:" + milkShake.getDetail() + ",milkShake:" + milkShake.price());
    }
}
