package main.java.respchain.auth;

public class Client {
	public static void main(String[] args) {
		MemberService service = new MemberService();
		service.login("tom", "666");
	}
}
