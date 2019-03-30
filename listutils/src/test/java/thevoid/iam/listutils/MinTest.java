package thevoid.iam.listutils;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MinTest {

    @Test
    public void testMin() {
        List<TestComp> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new TestComp(new Random().nextInt(100)));
        }

        System.out.println(Arrays.toString(list.toArray()));

        List<Integer> intList = ListUtil.map(list, t -> t.val);

        int min = intList.get(0);
        for (Integer i : intList) {
            min = Math.min(i, min);
        }

        TestComp testComp = ListUtil.min(list, (testComp1, t1) -> Long.compare(testComp1.val, t1.val));

        Assert.assertEquals(min, testComp.val);
        System.out.println("real min = " + min);
        System.out.println("defined min = " + testComp.val);
    }

    @Test
    public void testMin2() {
        List<TestComp> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(null);
        }

        System.out.println(Arrays.toString(list.toArray()));

        TestComp nullTestComp = ListUtil.min(list, (testComp1, t1) -> Long.compare(testComp1.val, t1.val));
        TestComp testComp = ListUtil.min(list, (testComp1, t1) -> Long.compare(testComp1.val, t1.val), new TestComp(5));

        Assert.assertNull(nullTestComp);
        Assert.assertNotNull(testComp);

        System.out.println("defined min = " + testComp);

        TestComp newMin = null;
        list.clear();
        for (int i = 0; i < 10; i++) {
            list.add(new Random().nextBoolean() ? null : new TestComp(new Random().nextInt(100)));
        }
        System.out.println(Arrays.toString(list.toArray()));
        for (TestComp tc : list) {
            if (newMin == null || (tc != null && tc.val < newMin.val))
                newMin = tc;

        }
        Assert.assertEquals(newMin, ListUtil.min(list, (testComp1, t1) -> Long.compare(testComp1.val, t1.val)));

        System.out.println("defined min = " + newMin);
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
