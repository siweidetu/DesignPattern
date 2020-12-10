package main.java.strategy.pay;

public class WeChatPay extends Payment {
    public String getName() {
        return "微信支付";
    }

    protected double queryBalance(String uid) {
        return 263;
    }
}

