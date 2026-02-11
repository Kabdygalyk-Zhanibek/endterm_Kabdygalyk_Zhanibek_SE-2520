package model;

public interface Searchable<T> {
    static boolean isNotNull(Object obj) {
        return obj != null;
    }
    T findById(int id);
}