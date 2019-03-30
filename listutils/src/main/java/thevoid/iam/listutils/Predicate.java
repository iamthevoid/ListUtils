package thevoid.iam.listutils;

import java.util.Objects;

public interface Predicate<T> {

    boolean test(T var1);

    default Predicate<T> and(Predicate<? super T> var1) {
        Objects.requireNonNull(var1);
        return var2 -> Predicate.this.test(var2) && var1.test(var2);
    }

    default Predicate<T> negate() {
        return var1 -> !Predicate.this.test(var1);
    }

    default Predicate<T> or(Predicate<? super T> var1) {
        Objects.requireNonNull(var1);
        return var2 -> Predicate.this.test(var2) || var1.test(var2);
    }

    static <T> Predicate<T> isEqual(Object var0) {
        return null == var0 ? var1 -> var1 == null : var0::equals;
    }
}