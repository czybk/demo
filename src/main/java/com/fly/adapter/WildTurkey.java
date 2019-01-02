package main.java.com.fly.adapter;

/**
 * Created by Fly on 2017/5/17.
 */
public class WildTurkey implements Turkey {
    public void gobble() {
        System.out.println("Gobble gobble");
    }

    public void fly() {
        System.out.println("I m flying a short distance");
    }
}
