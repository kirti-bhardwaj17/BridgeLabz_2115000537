import java.lang.reflect.Field;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }
}

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        Person person = new Person(25);

        Field ageField = Person.class.getDeclaredField("age");
        ageField.setAccessible(true);

        System.out.println("Original Age: " + ageField.get(person));

        ageField.set(person, 30);
        System.out.println("Modified Age: " + ageField.get(person));
    }
}
