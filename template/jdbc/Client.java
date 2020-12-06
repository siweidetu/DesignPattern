package main.java.template.jdbc;

import java.util.List;

public class Client {
	public static void main(String[] args) {
		//测试用例，需根据实际,调整
		MemberDao memberDao = new MemberDao(null);
		List<?> result = memberDao.selectAll();
		System.out.println(result);
	}
}
