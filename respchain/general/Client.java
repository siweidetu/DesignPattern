package main.java.respchain.general;

public class Client {
	
	public static void main(String[] args) {
		//创建责任链，并执行
		HandlerChain chain = new HandlerChain();
		chain.addHandler(new HandlerA());
		chain.addHandler(new HandlerB());
		chain.handle();
	}
}
