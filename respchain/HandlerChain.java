package main.java.respchain;

public class HandlerChain {
	private Handler head = null;
	private Handler tail = null;
	
	/**
	 * 增加节点
	 */
	public void addHandler(Handler handler){
		handler.setSuccessor(null);
		
		//没有任何处理器
		if(head==null){
			head = handler;
			tail = handler;
		}
		
		tail.setSuccessor(handler);
		tail = handler;
	}
	public void handle(){
		if(head!=null){
			head.handle();
		}
	}
}
