package main.java.strategy.pay;

public class Client {
	public static void main(String[] args) {
		Order order = new Order("1","2020121401000323",324.5);
		System.out.println(order.pay(PayStrategy.JD_PAY));
	}
}
