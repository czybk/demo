package main.java.com.fly.decorator.example;

/**
 * Created by SWan on 2017/5/16.
 */
public abstract class Decorator extends Component {
    Component componentObj;


    public void methodA() {
    }

    public void methodB() {

    }

    public abstract String getPropertyA();
    public abstract String getPropertyB();
}
