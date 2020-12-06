package main.java.template.general;

public abstract class AbstractClass {
	
	public final void templateMethod(){
		//第一步执行
		method1();
		//第二步执行
		method2();
	}
	protected abstract void method1();
	protected abstract void method2();
}
