import java.lang.reflect.Method;

class SampleClass {
    public void fastMethod() {
        for (int i = 0; i < 1000; i++);
    }

    public void slowMethod() {
        for (int i = 0; i < 1000000; i++);
    }
}

public class MethodExecutionTimer {
    public static void measureExecutionTime(Object obj, String methodName) throws Exception {
        Method method = obj.getClass().getMethod(methodName);
        long startTime = System.nanoTime();
        method.invoke(obj);
        long endTime = System.nanoTime();
        System.out.println(methodName + " executed in " + (endTime - startTime) + " ns");
    }

    public static void main(String[] args) throws Exception {
        SampleClass sample = new SampleClass();
        measureExecutionTime(sample, "fastMethod");
        measureExecutionTime(sample, "slowMethod");
    }
}

