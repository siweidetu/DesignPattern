package main.java.state.demo2;

import main.java.state.demo2.MarioStateMachine;
import main.java.state.demo2.State;

public class ApplicationDemo {
    public static void main(String[] args) {
        main.java.state.demo2.MarioStateMachine mario = new MarioStateMachine();
        mario.obtainMushRoom();
        int score = mario.getScore();
        State state = mario.getCurrentState();
        System.out.println("mario score: " + score + "; state: " + state);
    }
}
