package main.java.guava2;
import com.google.common.base.Preconditions;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class ObserverRegistry {
    /**注册表*/
    private ConcurrentMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry = new ConcurrentHashMap<>();

    /**
     * 注册观察者
     * @param observer
     */
    public void register(Object observer){
        Map<Class<?>,Collection<ObserverAction>> observerActions = findAllObserverActions(observer);
        for(Map.Entry<Class<?>,Collection<ObserverAction>> entry: observerActions.entrySet()){
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions = entry.getValue();
            CopyOnWriteArraySet<ObserverAction> registeredEventActions = registry.get(eventType);
            if(registeredEventActions == null){
                registry.putIfAbsent(eventType,new CopyOnWriteArraySet<ObserverAction>());
                registeredEventActions = registry.get(eventType);
            }
            registeredEventActions.addAll(eventActions);
        }
    }

    /**
     * 获取匹配的观察行为
     * @param event
     * @return
     */
    public List<ObserverAction> getMatchedObserverActions(Object event){
        List<ObserverAction> matchedObservers = new ArrayList<>();
        Class<?> postEventType = event.getClass();
        for(Map.Entry<Class<?>,CopyOnWriteArraySet<ObserverAction>> entry : registry.entrySet()){
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions = entry.getValue();
            if(postEventType.isAssignableFrom(eventType)){
                matchedObservers.addAll(eventActions);
            }
        }
        return matchedObservers;
    }

    /**
     * 获取观察者所有观察行为
     * @param observer
     * @return
     */
    private Map<Class<?>,Collection<ObserverAction>> findAllObserverActions(Object observer){
        Map<Class<?>,Collection<ObserverAction>>  observerActions = new HashMap<>();
        Class<?>  clazz = observer.getClass();
        for(Method method : getAnnotationMethods(clazz)){
           Class<?>[] parameterTypes = method.getParameterTypes();
           Class<?> eventType = parameterTypes[0];
           if(!observerActions.containsKey(eventType)){
               observerActions.put(eventType,new ArrayList<ObserverAction>());
           }
            observerActions.get(eventType).add(new ObserverAction(observer,method));
        }
        return observerActions;
    }

    /**
     * 获取类中所有Subscribe注解的方法
     * @param clazz
     * @return
     */
    private List<Method> getAnnotationMethods(Class<?> clazz){
        List<Method> annotationMethods = new ArrayList<Method>();
        for(Method method : clazz.getDeclaredMethods()){
            if(method.isAnnotationPresent(Subscribe.class)){
                Class<?> [] parameterTypes = method.getParameterTypes();
                Preconditions.checkArgument(parameterTypes.length==1,
                        "Method %s has @Subscribe annotation but has %s parameters." +
                                "Subscriber methods must have exactly 1 parameter.",
                        method,parameterTypes.length);
                annotationMethods.add(method);
            }
        }
        return annotationMethods;
    }
}
