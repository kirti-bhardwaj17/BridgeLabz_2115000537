import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class ExpensiveComputation {
    private static final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int computeSquare(int num) {
        if (cache.containsKey(num)) {
            System.out.println("Returning cached result for: " + num);
            return cache.get(num);
        }
        System.out.println("Computing square for: " + num);
        int result = num * num;
        cache.put(num, result);
        return result;
    }
}

public class CacheDemo {
    public static void main(String[] args) throws Exception {
        ExpensiveComputation obj = new ExpensiveComputation();
        System.out.println(obj.computeSquare(5));
        System.out.println(obj.computeSquare(5));
        System.out.println(obj.computeSquare(10));
        System.out.println(obj.computeSquare(10));
    }
}
