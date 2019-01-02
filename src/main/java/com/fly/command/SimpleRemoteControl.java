package main.java.com.fly.command;

import java.lang.ref.PhantomReference;

/**
 * Created by Fly on 2017/5/15.
 */
public class SimpleRemoteControl {

    private Command slot;

    public SimpleRemoteControl() {
    }

    public void setCommand(Command slot) {
        this.slot = slot;
    }

    public void buttonWasPressed() {
        slot.execute();
    }

    static class SimpleControlTest{
        public static void main(String[] args) {
            Command command = new LightOnCommand(new Light());

            SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();

            simpleRemoteControl.setCommand(command);
            simpleRemoteControl.buttonWasPressed();

            Command garageDoorOpenCommand = new GarageDoorOpenCommand(new GarageDoor());
            simpleRemoteControl.setCommand(garageDoorOpenCommand);
            simpleRemoteControl.buttonWasPressed();
        }
    }
}
