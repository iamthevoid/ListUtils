package thevoid.iam.listutils;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MatchTest {

    @Test
    public void simpleAllMatch() {
        List<Integer> list = ListUtil.createList(10, i -> new Random().nextInt(100));
        System.out.println(Arrays.asList(list.toArray()));
        Assert.assertTrue(ListUtil.allMatch(list, elm -> elm > 0));
        list = ListUtil.createList(10, i -> i == 5 ? -1 : new Random().nextInt(100));
        System.out.println(Arrays.asList(list.toArray()));
        Assert.assertFalse(ListUtil.allMatch(list, elm -> elm > 0));
    }

    @Test
    public void simpleAnyMatch() {
        Random random = new Random();
        List<Integer> list = ListUtil.createList(10, i -> (random.nextBoolean() ? 1 : -1) * random.nextInt(100));
        System.out.println(Arrays.asList(list.toArray()));
        boolean any = false;
        for (Integer i : list) {
            if (i < 0) {
                any = true;
                break;
            }
        }
        Assert.assertTrue(any ? ListUtil.anyMatch(list, elm -> elm < 0) : ListUtil.anyMatch(list, elm -> elm > 0));

        list = ListUtil.createList(10, i -> new Random().nextInt(100));
        System.out.println(Arrays.asList(list.toArray()));
        Assert.assertFalse(ListUtil.anyMatch(list, elm -> elm < 0));
    }

    @Test
    public void anyMatch() {
        List<Integer> list = ListUtil.createList(20, i -> new Random().nextInt(100));
        System.out.println(Arrays.asList(list.toArray()));
        List<Integer> list2 = ListUtil.createList(20, i -> new Random().nextInt(100));
        System.out.println(Arrays.asList(list2.toArray()));
        boolean any = false;
        main: for (int i : list) {
            for (int j : list2) {
                if (i == j) {
                    any = true;
                    break main;
                }
            }
        }

        List<Integer> integers = ListUtil.filterWithList(list, list2, item -> var1 -> item == var1);
        System.out.println(Arrays.asList(integers.toArray()));
        Assert.assertEquals(ListUtil.anyMatch(list, list2, item -> var1 -> item == var1), any);
    }
}
