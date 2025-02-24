import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}

class JsonSerializer {
    public static String toJson(Object obj) throws IllegalAccessException {
        Map<String, Object> jsonMap = new HashMap<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);
                jsonMap.put(annotation.name(), field.get(obj));
            }
        }
        return jsonMap.toString().replace("=", ": ");
    }
}

public class JsonDemo {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("Alice", 25);
        String json = JsonSerializer.toJson(user);
        System.out.println(json);
    }
}

