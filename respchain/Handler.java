package main.java.respchain;

public abstract class Handler {
	/**继承者*/
	protected Handler successor = null;

	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}
	
	/**处理*/
	public final void handle(){
		boolean flag = doHandle();
		if(successor!=null&&!flag){
			successor.doHandle();
		}
	}
	
	/**业务处理方法*/
	protected abstract boolean doHandle();
	
}
