package com.bignerdranch.android.criminalintent;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.GregorianCalendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;

import java.time.Clock;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by rober on 12/10/2017.
 */

public class TimePickerFragment extends DialogFragment {
    private static final String ARG_HOUR = "hour";
    private static final String ARG_MINUTE = "minute";
    private static final String ARG_AM_PM = "am_pm";

    private TimePicker mTimePicker;
    private Button mCancelButton;
    private Button mOKButton;
    private int mHour;
    private int mMinute;
    private int mAM_PM;

    public static final String EXTRA_HOUR =
            "com.bignerdranch.android.ciminalintent.hour";
    public static final String EXTRA_MINUTE =
            "com.bignerdranch.android.ciminalintent.minute";
    public static final String EXTRA_AM_PM=
            "com.bignerdranch.android.ciminalintent.am_pm";


    public static TimePickerFragment newInstance(int hour, int minute, int AM_PM) {
        Bundle args = new Bundle();
        args.putInt(ARG_HOUR, hour);
        args.putInt(ARG_MINUTE, minute);
        args.putInt(ARG_AM_PM, AM_PM);

        TimePickerFragment fragment = new TimePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mHour = getArguments().getInt(ARG_HOUR);
        mMinute = getArguments().getInt(ARG_MINUTE);
        mAM_PM = getArguments().getInt(ARG_AM_PM);

        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialog_time, null);

        mTimePicker = v.findViewById(R.id.dialog_time_picker);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mTimePicker.setHour(mHour);
            mTimePicker.setMinute(mMinute);
        } else {
            mTimePicker.setCurrentHour(mHour);
            mTimePicker.setCurrentMinute(mMinute);
        }
        mTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                mOKButton.setEnabled(true);
            }
        });

        mCancelButton = v.findViewById(R.id.cancel_button);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendResult(Activity.RESULT_CANCELED, mHour, mMinute, mAM_PM);
            }
        });

        mOKButton = v.findViewById(R.id.ok_button);
        mOKButton.setEnabled(false);
        mOKButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    mHour = mTimePicker.getHour();
                    mMinute = mTimePicker.getMinute();
                } else {
                    mHour = mTimePicker.getCurrentHour();
                    mMinute = mTimePicker.getCurrentMinute();
                }
                mAM_PM = mHour < 12 ? Calendar.AM : Calendar.PM;
                sendResult(Activity.RESULT_OK, mHour, mMinute, mAM_PM);
            }
        });
      return v;
    }

    private void sendResult(int resultCode, int hour, int minute, int AM_PM) {
        Intent intent = new Intent();
        if(resultCode == Activity.RESULT_OK) {

            intent.putExtra(EXTRA_HOUR, hour);
            intent.putExtra(EXTRA_MINUTE, minute);
            intent.putExtra(EXTRA_AM_PM, AM_PM);
        }
        if(getTargetFragment() == null) {
            getActivity().setResult(resultCode, intent);
            getActivity().finish();
        } else {
            getTargetFragment()
                    .onActivityResult(getTargetRequestCode(), resultCode, intent);
            this.dismiss();
        }
    }
}
