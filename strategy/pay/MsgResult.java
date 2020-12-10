package main.java.strategy.pay;

public class MsgResult {
    private  int code;
    private Object data;
    private String msg;
    MsgResult(int code, String msg, Object data){
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "MsgResult{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
