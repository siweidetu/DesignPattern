package main.java.template.general;

public class Client {
	public static void main(String[] args) {
		//执行ConcreteClass1重写的方法
		AbstractClass test = new ConcreteClass1();
		test.templateMethod();
		//执行ConcreteClass2重写的方法
		test = new ConcreteClass2();
		test.templateMethod();
	}
}
