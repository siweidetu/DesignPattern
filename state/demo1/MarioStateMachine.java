package main.java.state.demo1;

public class MarioStateMachine {
    private int score;
    private State currentState;

    public MarioStateMachine(){
        this.score = 0;
        this.currentState = State.SMALL;
    }

    public void obtainMushRoom(){
         this.currentState  = State.SUPER;
         this.score = this.score + 100;
    }

    public void obtainCape(){
        this.currentState  = State.CAPE;
        this.score = this.score + 200;
    }

    public void obtainFireFlower(){
        this.currentState  = State.FIRE;
        this.score = this.score + 300;
    }

    public void meetMonster(){
       if(this.currentState == State.SUPER){
           this.score = this.score - 100;
       }else if(this.currentState == State.CAPE){
           this.score = this.score - 200;
       }else if(this.currentState == State.FIRE){
           this.score = this.score - 300;
       }
       this.currentState  = State.SMALL;
    }

    public int getScore(){
        return this.score;
    }

    public State getCurrentState(){
        return this.currentState;
    }

}
