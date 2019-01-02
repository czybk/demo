package main.java.com.fly.singleton;

/**
 * Created by Fly on 2017/5/15.
 */
public class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton() {

    }

    public static  Singleton getInstance(){
        return instance;
    }
}
