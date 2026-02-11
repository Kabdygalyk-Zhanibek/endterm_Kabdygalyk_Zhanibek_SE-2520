package model;

public interface Validatable<T> {
    void validate(T entity) throws Exception;

    default void printValidationStart(String type) {
        System.out.println("Validating " + type + "...");
    }

    static boolean isPositive(int val) {
        return val >= 0;
    }
}