package main.java.iterator.general;

public class Client {
    //创建一个容器对象

    public static void main(String[] args) {
        //创建容器对象
        IAggregate<String> aggregate = new ConcreteAggregate<String>();
        //添加元素
        aggregate.add("one");
        aggregate.add("two");
        aggregate.add("three");
        //获取容器迭代器对象
        Iterator<String> iterator = aggregate.iterator();
        //遍历
        while(iterator.hasNext()){
            String element = iterator.next();
            System.out.println(element);
        }
    }
}
