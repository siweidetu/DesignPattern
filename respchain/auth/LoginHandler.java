package main.java.respchain.auth;

public class LoginHandler extends Handler {

	@Override
	public void doHandle(Member member) {
		System.out.println("登录成功！");
		System.out.println("管理员");
		chain.doHandle(member);
	}

}
