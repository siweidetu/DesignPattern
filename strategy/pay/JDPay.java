package DesignPattern.strategy.pay;

public class JDPay extends Payment{

    public String getName() {
        return "京东";
    }

    protected double queryBalance(String uid) {
        return 500;
    }
}
