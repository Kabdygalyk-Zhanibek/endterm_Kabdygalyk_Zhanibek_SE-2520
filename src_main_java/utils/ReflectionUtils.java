package utils;

public class ReflectionUtils {
    public static void inspect(Object obj) {
        Class<?> clazz = obj.getClass();
        System.out.println("Inspection of: " + clazz.getName());
        for (var field : clazz.getDeclaredFields()) {
            System.out.println("Field: " + field.getName());
        }
        for (var method : clazz.getDeclaredMethods()) {
            System.out.println("Method: " + method.getName());
        }
    }
}