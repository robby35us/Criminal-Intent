package com.bignerdranch.android.criminalintent;

import android.os.Build;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Created by rober on 12/9/2017.
 */

public class Crime {

    private static Calendar sCalendar = Calendar.getInstance();

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private int mHour;
    private int mMinute;
    private int mAM_PM;
    private boolean mSolved;

    public Crime() {
        this(UUID.randomUUID());
    }

    public Crime(UUID id) {
        mId = id;
        mDate = new Date();
        sCalendar.setTime(mDate);
        mHour = sCalendar.get(Calendar.HOUR_OF_DAY);
        mMinute = sCalendar.get(Calendar.MINUTE);
        mAM_PM = sCalendar.get(Calendar.AM_PM);
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public int getHour() {
        return mHour;
    }

    public void setHour(int hour) {
        mHour = hour;
    }

    public int getMinute() {
        return mMinute;
    }

    public void setMinute(int minute) {
        mMinute = minute;
    }

    public int getAM_PM(){
        return mAM_PM;
    }

    public void setAM_PM(int AM_PM) {
        mAM_PM = AM_PM;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }
}
