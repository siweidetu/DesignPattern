package DesignPattern.gper;

import java.util.Observable;

public class Gper extends Observable {
    private String name = "Gper生态圈";
    private static Gper gper = null;
    private  Gper(){}
    public static Gper getInstance(){
        if(null==gper){
            gper = new Gper();
        }
        return gper;
    }
    public String getName(){
        return name;
    }

    public void publishQuestion(Question question){
        System.out.println(question.getUserName() + " 在" + this.name + "上提交了一个问题。");
        setChanged();
        notifyObservers(question);
    }
}
