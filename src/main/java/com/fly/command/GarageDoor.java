package main.java.com.fly.command;

/**
 * Created by Fly on 2017/5/16.
 */
public class GarageDoor {

    private String className = this.getClass().getName();

    public void up(){
        System.out.println(className + " up");
    }

    public void down(){
        System.out.println(className + " down");
    }

    public void stop(){
        System.out.println(className + " stop");
    }

    private void lightOn(){
        System.out.println(className + " lightOn");
    }

    private void lightOff(){
        System.out.println(className + " lightOff");
    }
}
