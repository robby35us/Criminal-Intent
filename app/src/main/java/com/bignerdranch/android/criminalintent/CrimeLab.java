package com.bignerdranch.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by rober on 12/9/2017.
 */

public class CrimeLab {

    private static CrimeLab sCrimeLab;

    private List<Crime> mCrimes;

    public static CrimeLab get(Context context) {
         if(sCrimeLab == null) {
             sCrimeLab = new CrimeLab(context);
         }
         return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mCrimes= new ArrayList<>();
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public void addCrime(Crime c) {
        mCrimes.add(c);
    }

    public boolean deleteCrime(Crime c) {
        return mCrimes.remove(c);
    }

    public Crime getCrime(UUID id) {
        for(Crime crime : mCrimes) {
            if(crime.getId().equals((id))) {
                return crime;
            }
        }

        return null;
    }
}
