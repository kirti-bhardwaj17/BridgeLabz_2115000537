import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class JsonGenerator {
    public static String toJson(Object obj) throws IllegalAccessException {
        Map<String, Object> jsonMap = new HashMap<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            jsonMap.put(field.getName(), field.get(obj));
        }
        return jsonMap.toString().replace("=", ": ");
    }

    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person("Alice", 25);
        System.out.println(toJson(person));
    }
}
