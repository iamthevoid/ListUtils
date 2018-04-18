package thevoid.iam.listutils;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Date> dates = new ArrayList<>();
        Date date = new Date();
        for (int i = 0; i < 5; i++) {
            long l = date.getTime() - Math.abs((new Random().nextLong() % 1000L * 60L * 60L * 24L * 31L));
            dates.add(new Date(l));
        }

        System.out.println(Arrays.toString(dates.toArray()));
        System.out.println(Arrays.toString(ListUtil.map(dates, Date::getTime).toArray()));
        System.out.println(ListUtil.maxByLong(dates, Date::getTime, new Date()));
        System.out.println(ListUtil.minByLong(dates, Date::getTime, new Date()));
    }
}
