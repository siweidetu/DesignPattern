package DesignPattern.gper;

import java.util.Observable;
import java.util.Observer;

public class Teacher implements Observer {

    private String name;
    public Teacher(String name){
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Gper gper = (Gper) o;
        Question question = (Question)arg;
        System.out.println(name+" 老师，您好,您收到一个来自"+gper.getName()+"的提问。");
        System.out.println(" 问题内容如下："+question.getContent());
    }
}
