package DesignPattern.guava;

import com.google.common.eventbus.Subscribe;

public class GuavaEvent2 {
    @Subscribe
    public void subscribe(String str){
        //业务逻辑
        System.out.println(" 执行GuavaEvent2:subscribe 方法，传入的参数是：" + str);
    }
}
