package thevoid.iam.listutils;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class MaxTest {

    @Test
    public void testMax() {
        List<TestComp> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new TestComp(new Random().nextInt(100)));
        }

        System.out.println(Arrays.toString(list.toArray()));

        List<Integer> intList = ListUtil.map(list, t -> t.val);

        int max = intList.get(0);
        for (Integer i : intList) {
            max = Math.max(i, max);
        }

        TestComp testComp = ListUtil.max(list, (testComp1, t1) -> Long.compare(testComp1.val, t1.val));

        Assert.assertEquals(max, testComp.val);
        System.out.println("real max = " + max);
        System.out.println("defined max = " + testComp.val);
    }

    @Test
    public void testMax2() {
        List<TestComp> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(null);
        }

        System.out.println(Arrays.toString(list.toArray()));

        TestComp nullTestComp = ListUtil.max(list, (testComp1, t1) -> Long.compare(testComp1.val, t1.val));
        TestComp testComp = ListUtil.max(list, (testComp1, t1) -> Long.compare(testComp1.val, t1.val), new TestComp(5));

        Assert.assertNull(nullTestComp);
        Assert.assertNotNull(testComp);

        System.out.println("defined max = " + testComp);

        TestComp newMax = null;
        list.clear();
        for (int i = 0; i < 10; i++) {
            list.add(new Random().nextBoolean() ? null : new TestComp(new Random().nextInt(100)));
        }
        System.out.println(Arrays.toString(list.toArray()));
        for (TestComp tc : list) {
            if (newMax == null || (tc != null && tc.val > newMax.val))
                newMax = tc;

        }
        Assert.assertEquals(newMax, ListUtil.max(list, (testComp1, t1) -> Long.compare(testComp1.val, t1.val)));

        System.out.println("defined max = " + newMax);
    }

    class TestComp {
        final int val;

        TestComp(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
