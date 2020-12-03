package DesignPattern.gper;

public class Client {
    public static void main(String[] args) {
        Gper gper = Gper.getInstance();
        Teacher tom = new Teacher("Tom");
        Teacher jerry = new Teacher("jerry");
        gper.addObserver(tom);
        gper.addObserver(jerry);

        Question question = new Question();
        question.setUserName("张三");
        question.setContent("观察者模式学习");

        gper.publishQuestion(question);
    }
}
