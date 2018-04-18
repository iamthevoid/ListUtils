package thevoid.iam.listutils;

public interface Function<T, R> {
    R apply(T t);
}