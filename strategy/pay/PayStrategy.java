package main.java.strategy.pay;

import java.util.HashMap;
import java.util.Map;

public class PayStrategy {
    public static final String ALI_PAY = "AliPay";
    public static final String JD_PAY = "JDPay";
    public static final String WECHAT_PAY = "WechatPay";
    public static final String UNION_PAY = "UnionPay";
    public static final String DEFAULT_PAY = "AliPay";

    private static Map<String,Payment> strategy = new HashMap<String,Payment>();

    static {
        strategy.put(ALI_PAY,new Alipay());
        strategy.put(JD_PAY,new JDPay());
        strategy.put(WECHAT_PAY,new WeChatPay());
        strategy.put(UNION_PAY,new UnionPay());
    }
    
    /***/
    public static Payment get(String payKey){
    	if(!strategy.containsKey(payKey)){
    		return strategy.get(DEFAULT_PAY);
    	}
    	return strategy.get(payKey);
    }

}

