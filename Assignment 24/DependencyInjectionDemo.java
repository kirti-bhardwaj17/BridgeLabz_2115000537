import java.lang.annotation.*;
import java.lang.reflect.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}


class ServiceA {
    public void doWork() {
        System.out.println("ServiceA is working.");
    }
}

class ServiceB {
    public void execute() {
        System.out.println("ServiceB is executing.");
    }
}

class Consumer {
    @Inject
    private ServiceA serviceA;

    @Inject
    private ServiceB serviceB;

    public void run() {
        serviceA.doWork();
        serviceB.execute();
    }
}


class DIContainer {
    public static void injectDependencies(Object obj) throws Exception {
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Object dependency = field.getType().getDeclaredConstructor().newInstance();
                field.set(obj, dependency);
            }
        }
    }
}

public class DependencyInjectionDemo {
    public static void main(String[] args) throws Exception {
        Consumer consumer = new Consumer();
        DIContainer.injectDependencies(consumer);
        consumer.run();
    }
}
