package com.bignerdranch.android.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by rober on 12/11/2017.
 */

public class TimePickerActivity extends SingleFragmentActivity {

    public static final String EXTRA_HOUR = "hour";
    public static final String EXTRA_MINUTE = "minute";
    public static final String EXTRA_AM_PM = "am_pm";

    public static Intent newIntent(Context packageContext, int hour, int minute, int AM_PM) {
        Intent intent = new Intent(packageContext, TimePickerActivity.class);
        intent.putExtra(EXTRA_HOUR, hour);
        intent.putExtra(EXTRA_MINUTE, minute);
        intent.putExtra(EXTRA_AM_PM, AM_PM);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        Intent intent = getIntent();
        return TimePickerFragment.newInstance(
                intent.getIntExtra(EXTRA_HOUR, 0),
                intent.getIntExtra(EXTRA_MINUTE, 0),
                intent.getIntExtra(EXTRA_AM_PM, Calendar.AM));
    }
}
