package com.bignerdranch.android.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by rober on 12/9/2017.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    private static final String EMPTY_CRIME_LIST_TAG =
            BuildConfig.APPLICATION_ID + ".EmptyCrimeListFragment";
    private static final String CRIME_LIST_TAG =
            BuildConfig.APPLICATION_ID + ".CrimeListFragment";

    @Override
    protected Fragment createFragment() {
        CrimeLab crimeLab = CrimeLab.get(this);
        int numCrimes = crimeLab.getCrimes().size();
        if(numCrimes > 0) {
            return new CrimeListFragment();
        } else {
            return new EmptyCrimeListFragment();
        }
    }
}
