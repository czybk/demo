package main.java.com.fly.decorator.example;

/**
 * Created by SWan on 2017/5/16.
 */
public abstract class Component {
    private String propertyA;
    private String propertyB;

    public String getPropertyA() {
        return propertyA;
    }

    public String getPropertyB() {
        return propertyB;
    }

    public abstract void methodA();
    public abstract void methodB();
}
