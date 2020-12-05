package main.java.guava2;
import java.util.List;
import java.util.concurrent.Executor;
import com.google.common.util.concurrent.MoreExecutors;

/**
 * 事件发布者
 * */
public class EventBus {
    private Executor executor;
    private ObserverRegistry registry = new ObserverRegistry();

    public EventBus(){
        this(MoreExecutors.directExecutor());
    }

    public EventBus(Executor executor){
        this.executor = executor;
    }

    public void register(Object object){
        registry.register(object);
    }

    public void post(final Object event){
        List<ObserverAction> ObserverActions= registry.getMatchedObserverActions(event);
        for(final ObserverAction observerAction:ObserverActions){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    observerAction.excute(event);
                }
            });
        }
    }
}
