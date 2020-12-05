package main.java.guava2;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.google.common.base.Preconditions;

/**
 *观察者行为类模式
 * */
public class ObserverAction {
    private Object target;
    private Method method;

    public ObserverAction(Object target,Method method){
        this.target = Preconditions.checkNotNull(target);
        this.method = method;
        this.method.setAccessible(true);
    }

    public void excute(Object event){
        try {
            method.invoke(target,event);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
