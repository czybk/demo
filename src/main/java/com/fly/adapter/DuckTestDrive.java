package main.java.com.fly.adapter;

/**
 * Created by Fly on 2017/5/17.
 */
public class DuckTestDrive {
    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck();

        WildTurkey turkey = new WildTurkey();

        TurkeyAdapter turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("The Turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println("the duck says...");
        testDuck(duck);

        System.out.println("turkeyAdapter says...");
        testDuck(turkeyAdapter);
    }

    private static void testDuck(Duck duck){
        duck.quack();
        duck.fly();
    }
}
