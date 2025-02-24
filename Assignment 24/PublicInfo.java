import java.lang.reflect.*;

public class PublicInfo {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName(args[0]);

        System.out.println("Fields:");
        for (Field field : cls.getDeclaredFields()) {
            System.out.println(field);
        }

        System.out.println("\nMethods:");
        for (Method method : cls.getDeclaredMethods()) {
            System.out.println(method);
        }

        System.out.println("\nConstructors:");
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            System.out.println(constructor);
        }
    }
}
