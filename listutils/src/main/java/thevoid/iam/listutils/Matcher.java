package thevoid.iam.listutils;

public interface Matcher<T, E> {
    Predicate<E> predicate(T item);
}