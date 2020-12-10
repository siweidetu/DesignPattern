package main.java.strategy.pay;

public class Order {
	private String uid;
	private String orderId;
	private double amount;
	
	public Order(String uid,String orderId,double amount){
		this.uid = uid;
		this.orderId = orderId;
		this.amount = amount;
	}
	
	public MsgResult pay(){
		return pay(PayStrategy.DEFAULT_PAY);
	}
	
	public MsgResult pay(String payKey){
		Payment payment = PayStrategy.get(payKey);
		System.out.println();
		System.out.println("欢迎使用："+payment.getName());
		System.out.println("本次交易金额："+amount);
		return  payment.pay(uid, amount);
	}
}
