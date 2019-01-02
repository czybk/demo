package main.java.com.fly.singleton;

/**
 * Created by Fly on 2017/5/15.
 */
public class SingletonOne {

    private static SingletonOne instance;

    private SingletonOne() {

    }

    public static SingletonOne getInstance(){
        if(instance==null){
            instance = new SingletonOne();
        }
        return instance;
    }
}
