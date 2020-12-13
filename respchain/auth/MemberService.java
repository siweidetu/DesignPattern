package main.java.respchain.auth;

public class MemberService {
	public void login(String loginName,String loginPass){
		Handler validateHandler = new ValidateHandler();
		Handler loginHandler = new LoginHandler();
		Handler authHandler = new AuthHandler();
		validateHandler.next(loginHandler);
		loginHandler.next(authHandler);
		validateHandler.doHandle(new Member(loginName,loginPass));
	}
}
