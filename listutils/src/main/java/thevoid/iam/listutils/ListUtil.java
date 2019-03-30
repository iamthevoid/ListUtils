package thevoid.iam.listutils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class ListUtil {
    private ListUtil() {
    }

    /**
     * MAP
     */


    public static <T, E> List<E> map(Collection<T> list, Function<? super T, ? extends E> function) {
        List<E> mapped = new ArrayList<>(list.size());
        forEach(list, t -> mapped.add(function.apply(t)));
        return mapped;
    }

    public static <T, E> List<E> map(T[] array, Function<? super T, ? extends E> function) {
        return map(Arrays.asList(array), function);
    }

    public static <T, E> List<E> map(Iterable<T> iterable, Function<? super T, ? extends E> function) {
        return map(toList(iterable), function);
    }

    /**
     * FILTER
     */

    public static <T> List<T> filter(Collection<T> list, Predicate<? super T> predicate) {
        List<T> filtered = new ArrayList<>();
        forEach(list, t -> {
            if (predicate.test(t))
                filtered.add(t);
        });
        return filtered;
    }

    public static <T> List<T> filter(Iterable<T> iterable, Predicate<? super T> predicate) {
        return filter(toList(iterable), predicate);
    }

    public static <T> List<T> filter(T[] array, Predicate<? super T> predicate) {
        return filter(Arrays.asList(array), predicate);
    }

    public static <T, E> List<T> filterWithList(List<T> list, List<E> matchList, Matcher<T, E> matcher) {
        return filter(list, item -> anyMatch(matchList, matcher.predicate(item)));
    }

    /**
     * FOR EACH
     */

    public static <T> void forEach(Collection<T> collection, Consumer<? super T> action) {
        for (T t : collection)
            action.accept(t);
    }

    public static <T> void forEach(T[] array, Consumer<? super T> action) {
        forEach(Arrays.asList(array), action);
    }

    public static <T> void forEach(Iterable<T> collection, Consumer<? super T> action) {
        for (T otem : collection) {
            action.accept(otem);
        }
    }

    /**
     * SUM
     */

//    INT
    public static int intSum(List<Integer> list) {
        int sum = 0;
        for (Integer integer : list) {
            if (integer != null)
                sum += integer;
        }
        return sum;
    }

    public static int intSum(Integer[] array) {
        return intSum(Arrays.asList(array));
    }

    public static int intSum(Iterable<Integer> iterable) {
        return intSum(toList(iterable));
    }

//    INT with mapper

    public static <T> int intSum(List<T> list, ToIntFunction<T> mapper) {
        return intSum(map(list, mapper::applyAsInt));
    }

    public static <T> int intSum(T[] array, ToIntFunction<T> mapper) {
        return intSum(Arrays.asList(array), mapper);
    }

    public static <T> int intSum(Iterable<T> iterable, ToIntFunction<T> mapper) {
        return intSum(toList(iterable), mapper);
    }

//    DOUBLE

    public static double doubleSum(List<Double> list) {
        double sum = 0;
        for (Double aDouble : list) {
            if (aDouble != null)
                sum += aDouble;
        }
        return sum;
    }

    public static double doubleSum(Double[] array) {
        return doubleSum(Arrays.asList(array));
    }

    public static double doubleSum(Iterable<Double> iterable) {
        return doubleSum(toList(iterable));
    }

//    DOUBLE with mapper

    public static <T> double doubleSum(List<T> list, ToDoubleFunction<T> mapper) {
        return doubleSum(map(list, mapper::applyAsDouble));
    }

    public static <T> double doubleSum(T[] array, ToDoubleFunction<T> mapper) {
        return doubleSum(Arrays.asList(array), mapper);
    }

    public static <T> double doubleSum(Iterable<T> iterable, ToDoubleFunction<T> mapper) {
        return doubleSum(toList(iterable), mapper);
    }

//    LONG

    public static long longSum(List<Long> list) {
        long sum = 0;
        for (Long aLong : list) {
            if (aLong != null)
                sum += aLong;
        }
        return sum;
    }

    public static long longSum(Long[] array) {
        return longSum(Arrays.asList(array));
    }

    public static long longSum(Iterable<Long> iterable) {
        return longSum(toList(iterable));
    }

//    LONG with mapper

    public static <T> long longSum(List<T> list, ToLongFunction<T> mapper) {
        return longSum(map(list, mapper::applyAsLong));
    }

    public static <T> long longSum(T[] array, ToLongFunction<T> mapper) {
        return longSum(Arrays.asList(array), mapper);
    }

    public static <T> long longSum(Iterable<T> iterable, ToLongFunction<T> mapper) {
        return longSum(toList(iterable), mapper);
    }

    /**
     * MAX
     */

//    With custom comparator
    public static <T> T max(List<T> list, Comparator<T> function, T defaultValue) {
        T max = null;
        for (T t : list) {
            if (max == null || (t != null && function.compare(max, t) < 0))
                max = t;
        }
        return max == null ? defaultValue : max;
    }

    public static <T> T max(List<T> list, Comparator<T> function) {
        return max(list, function, null);
    }

//    By LONG value

    public static <T> T maxByLong(List<T> list, Function<T, Long> function) {
        return max(list, (f, s) -> Long.compare(function.apply(f), function.apply(s)));
    }

    public static <T> T maxByLong(List<T> list, Function<T, Long> function, T defaultItem) {
        return max(list, (f, s) -> Long.compare(function.apply(f), function.apply(s)), defaultItem);
    }

//    By INT value

    public static <T> T maxByInt(List<T> list, Function<T, Integer> function) {
        return max(list, (f, s) -> Integer.compare(function.apply(f), function.apply(s)));
    }


    public static <T> T maxByInt(List<T> list, Function<T, Integer> function, T defaultItem) {
        return max(list, (f, s) -> Integer.compare(function.apply(f), function.apply(s)), defaultItem);
    }

//    By DOUBLE value

    public static <T> T maxByDouble(List<T> list, Function<T, Double> function) {
        return max(list, (f, s) -> Double.compare(function.apply(f), function.apply(s)));
    }


    public static <T> T maxByDouble(List<T> list, Function<T, Double> function, T defaultItem) {
        return max(list, (f, s) -> Double.compare(function.apply(f), function.apply(s)), defaultItem);
    }

//    By FLOAT value

    public static <T> T maxByFloat(List<T> list, Function<T, Float> function) {
        return max(list, (f, s) -> Float.compare(function.apply(f), function.apply(s)));
    }

    public static <T> T maxByFloat(List<T> list, Function<T, Float> function, T defaultItem) {
        return max(list, (f, s) -> Float.compare(function.apply(f), function.apply(s)), defaultItem);
    }

//    Max LONG

    public static Long maxLong(List<Long> list) {
        return maxLong(list, l -> l);
    }

    public static <T> Long maxLong(List<T> list, ToLongFunction<T> toLongFunction) {
        return maxLong(map(list, toLongFunction::applyAsLong));
    }

//    Max INT

    public static Integer maxInt(List<Integer> list) {
        return maxInt(list, i -> i);
    }

    public static <T> Integer maxInt(List<T> list, ToIntFunction<T> toIntFunction) {
        return maxInt(map(list, toIntFunction::applyAsInt));
    }

//    Max FLOAT

    public static Float maxFloat(List<Float> list) {
        return maxByFloat(list, item -> item, 0f);
    }
//
//    Max DOUBLE

    public static Double maxDouble(List<Double> list) {
        return maxDouble(list, d -> d);
    }

    public static <T> Double maxDouble(List<T> list, ToDoubleFunction<T> toDoubleFunction) {
        return maxDouble(map(list, toDoubleFunction::applyAsDouble));
    }

    /**
     * MIN
     */

//    With custom comparator
    public static <T> T min(List<T> list, Comparator<T> function, T defaultValue) {
        T max = null;
        for (T t : list) {
            if (max == null || (t != null && function.compare(max, t) > 0))
                max = t;
        }

        return max == null ? defaultValue : max;
    }

    public static <T> T min(List<T> list, Comparator<T> function) {
        return min(list, function, null);
    }

//    By LONG value

    public static <T> T minByLong(List<T> list, Function<T, Long> function) {
        return min(list, (f, s) -> Long.compare(function.apply(f), function.apply(s)));
    }

    public static <T> T minByLong(List<T> list, Function<T, Long> function, T defaultItem) {
        return min(list, (f, s) -> Long.compare(function.apply(f), function.apply(s)), defaultItem);
    }

//    By INT value

    public static <T> T minByInt(List<T> list, Function<T, Integer> function) {
        return min(list, (f, s) -> Integer.compare(function.apply(f), function.apply(s)));
    }

    public static <T> T minByInt(List<T> list, Function<T, Integer> function, T defaultItem) {
        return min(list, (f, s) -> Integer.compare(function.apply(f), function.apply(s)), defaultItem);
    }

//    By DOUBLE value

    public static <T> T minByDouble(List<T> list, Function<T, Double> function) {
        return min(list, (f, s) -> Double.compare(function.apply(f), function.apply(s)));
    }

    public static <T> T minByDouble(List<T> list, Function<T, Double> function, T defaultItem) {
        return min(list, (f, s) -> Double.compare(function.apply(f), function.apply(s)), defaultItem);
    }

//    By FLOAT value

    public static <T> T minByFloat(List<T> list, Function<T, Float> function) {
        return min(list, (f, s) -> Float.compare(function.apply(f), function.apply(s)));
    }

    public static <T> T minByFloat(List<T> list, Function<T, Float> function, T defaultItem) {
        return min(list, (f, s) -> Float.compare(function.apply(f), function.apply(s)), defaultItem);
    }

//    Min LONG

    public static Long minLong(List<Long> list) {
        return minLong(list, l -> l);
    }

    public static <T> Long minLong(List<T> list, ToLongFunction<T> toLongFunction) {
        return minLong(map(list, toLongFunction::applyAsLong));
    }

//    Min INT

    public static Integer minInt(List<Integer> list) {
        return minInt(list, i -> i);
    }

    public static <T> Integer minInt(List<T> list, ToIntFunction<T> toIntFunction) {
        return minInt(map(list, toIntFunction::applyAsInt));
    }

//    Min FLOAT

    public static Float minFloat(List<Float> list) {
        return minByFloat(list, item -> item, 0f);
    }

//    Min DOUBLE

    public static Double minDouble(List<Double> list) {
        return minDouble(list, d -> d);
    }

    public static <T> Double minDouble(List<T> list, ToDoubleFunction<T> toDoubleFunction) {
        return minDouble(map(list, toDoubleFunction::applyAsDouble));
    }

    /**
     * SORT
     */

    /**
     * MAX
     */

//    With custom comparator
    public static <T> List<T> sort(List<T> list, Comparator<T> function) {
        List<T> sorted = new ArrayList<>();
        sorted.addAll(list);
        Collections.sort(sorted, function);
        return sorted;
    }

//    By LONG value

    public static <T> List<T> sortByLong(List<T> list, Function<T, Long> function) {
        return sort(list, (f, s) -> Long.compare(function.apply(f), function.apply(s)));
    }
//    By INT value

    public static <T> List<T> sortByInt(List<T> list, Function<T, Integer> function) {
        return sort(list, (f, s) -> Integer.compare(function.apply(f), function.apply(s)));
    }
//    By DOUBLE value

    public static <T> List<T> sortByDouble(List<T> list, Function<T, Double> function) {
        return sort(list, (f, s) -> Double.compare(function.apply(f), function.apply(s)));
    }

//    By FLOAT value

    public static <T> List<T> sortByFloat(List<T> list, Function<T, Float> function) {
        return sort(list, (f, s) -> Float.compare(function.apply(f), function.apply(s)));
    }

//    By COMPARABLE value

    public static <T extends Comparable<T>> List<T> sort(List<T> list) {
        return sort(list, Comparable::compareTo);
    }

    /**
     * FLATTEN
     */

    public static <T> List<T> flatten(List<List<T>> list) {
        List<T> flatten = new ArrayList<>();
        for (List<T> l : list) {
            flatten.addAll(l);
        }
        return flatten;
    }

    /**
     * ANY MATCH
     */

    // old  anyMatch with same params renamed to 'filterWithList'
    public static <T, E> boolean anyMatch(List<T> list, List<E> matchList, Matcher<T, E> matcher) {
        return anyMatch(list, item -> anyMatch(matchList, matcher.predicate(item)));
    }

    public static <T> boolean anyMatch(List<T> list, Predicate<T> predicate) {
        boolean anyMatch = false;
        for (T t  : list) {
            anyMatch = anyMatch || predicate.test(t);
        }
        return anyMatch;
    }


    /**
     * ALL MATCH
     */

    public static <T> boolean allMatch(List<T> list, Predicate<T> predicate) {
        boolean allMatch = true;
        for (T t  : list) {
            allMatch = allMatch && predicate.test(t);
        }
        return allMatch;
    }


    /**
     * MERGE
     */

    public static <T> List<T> merge(List<T> first, List<T> second) {
        List<T> list = new ArrayList<>();
        list.addAll(first);
        list.addAll(second);
        return list;
    }

    /**
     * CONVERSION
     */

    public static <T> List<T> toList(T item, T... items) {
        List<T> itemList = new ArrayList<>();
        itemList.add(item);
        itemList.addAll(Arrays.asList(items));
        return itemList;
    }


    public static <T> List<T> toList(Iterable<T> iterable) {
        if (iterable == null) {
            return new ArrayList<>();
        }
        if (iterable instanceof List) {
            return (List<T>) iterable;
        }

        List<T> list = new ArrayList<>();
        for (T item : iterable) {
            list.add(item);
        }

        return list;
    }

    public static <T> List<T> createList(int size, Function<Integer, T> creator) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(creator.apply(i));
        }
        return list;
    }
}