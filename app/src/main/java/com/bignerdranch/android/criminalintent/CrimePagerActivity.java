package com.bignerdranch.android.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.List;
import java.util.UUID;

/**
 * Created by rober on 12/9/2017.
 */

public class CrimePagerActivity extends AppCompatActivity {
    private static final String EXTRA_CRIME_ID =
            "com.bignerdranch.android.criminalintent.crime_id";
    public static final int REQUEST_CODE = 0;


    private ViewPager mViewPager;
    private Button mFirstPageButton;
    private Button mLastPageButton;

    private List<Crime> mCrimes;

    public static Intent newIntent(Context packageContext, UUID crimeId) {
        Intent intent = new Intent(packageContext, CrimePagerActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_pager);

        UUID crimeId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_CRIME_ID);

        mViewPager = findViewById(R.id.crime_view_pager);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position == 0) {
                    mFirstPageButton.setEnabled(false);
                } else if(position == 1) {
                    mFirstPageButton.setEnabled(true);
                                                                                                                                                                                                                }

                if(position == mCrimes.size() - 1) {
                    mLastPageButton.setEnabled(false);
                } else if(position == mCrimes.size() - 2) {
                    mLastPageButton.setEnabled(true);
                }
            }

            @Override
            public void onPageSelected(int position) {
                if(position == 0) {
                    mFirstPageButton.setEnabled(false);
                } else {
                    mFirstPageButton.setEnabled(true);
                }

                if(position == mCrimes.size() - 1) {
                    mLastPageButton.setEnabled(false);
                } else {
                    mLastPageButton.setEnabled(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        mFirstPageButton = findViewById(R.id.first_skip_button);
        mFirstPageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(0);
            }
        });

        mLastPageButton = findViewById(R.id.last_skip_button);
        mLastPageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(mCrimes.size() - 1);
            }
        });

        mCrimes = CrimeLab.get(this).getCrimes();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {

            @Override
            public Fragment getItem(int position) {
                Crime crime = mCrimes.get(position);
                return CrimeFragment.newInstance(crime.getId());
            }

            @Override
            public int getCount() {
                return mCrimes.size();
            }
        });

        for(int i = 0; i < mCrimes.size(); i++) {
            if(mCrimes.get(i).getId().equals(crimeId)) {
                mViewPager.setCurrentItem(i);
                if(i == 0 ) {
                    mFirstPageButton.setEnabled(false);
                } else if(i == mCrimes.size() - 1) {
                    mLastPageButton.setEnabled(false);
                }
                break;
            }
        }

    }
}
















