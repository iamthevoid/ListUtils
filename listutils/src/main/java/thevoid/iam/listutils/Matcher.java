package thevoid.iam.listutils;

import java8.util.function.Predicate;

public interface Matcher<T, E> {
    Predicate<? super E> predicate(T item);
}