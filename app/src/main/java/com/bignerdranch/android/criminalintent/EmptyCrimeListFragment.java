package com.bignerdranch.android.criminalintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import static com.bignerdranch.android.criminalintent.CrimePagerActivity.REQUEST_CODE;

/**
 * Created by rober on 12/21/2017.
 */

public class EmptyCrimeListFragment extends Fragment {

    ImageButton mNewCrime;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_empty_crime_list, container, false);

        mNewCrime = view.findViewById(R.id.addCrimeButton);
        mNewCrime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCrime();
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_crime_list, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.new_crime:
                addCrime();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void addCrime() {
        Crime crime = new Crime();
        CrimeLab.get(getActivity()).addCrime(crime);
        Intent intent = CrimePagerActivity
                .newIntent(getActivity(), crime.getId());
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
       if(requestCode == REQUEST_CODE) {
           CrimeLab crimeLab = CrimeLab.get(getContext());
           if(crimeLab.getCrimes().size() > 0 ) {
               CrimeListFragment crimeList = new CrimeListFragment();
               getActivity().getSupportFragmentManager()
                       .beginTransaction()
                       //.disallowAddToBackStack()
                       .replace(R.id.fragment_container, crimeList)
                       .commit();
           }
       }
    }
}
