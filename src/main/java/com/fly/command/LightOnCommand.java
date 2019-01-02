package main.java.com.fly.command;

/**
 * Created by Fly on 2017/5/15.
 */
public class LightOnCommand implements Command{

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }
}
