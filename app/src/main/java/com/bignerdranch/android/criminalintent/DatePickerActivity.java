package com.bignerdranch.android.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.DatePicker;

import java.util.Date;
import java.util.UUID;

/**
 * Created by rober on 12/11/2017.
 */

public class DatePickerActivity extends SingleFragmentActivity {

    private static final String EXTRA_DATE = "date";

    public static Intent newIntent(Context packageContext, Date date) {
        Intent intent = new Intent(packageContext, DatePickerActivity.class);
        intent.putExtra(EXTRA_DATE, date);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return DatePickerFragment.newInstance((Date) getIntent().getExtras().getSerializable(EXTRA_DATE));
    }
}
