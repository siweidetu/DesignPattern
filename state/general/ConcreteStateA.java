package main.java.state.general;

public class ConcreteStateA extends State{

    @Override
    public void handle() {
        System.out.println("StateA do Action");
        this.context.setState(Context.STATE_B);
        this.context.getState().handle();
    }
}
