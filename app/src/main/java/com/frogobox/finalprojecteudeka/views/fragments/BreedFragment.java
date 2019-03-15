package com.frogobox.finalprojecteudeka.views.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.frogobox.finalprojecteudeka.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BreedFragment extends Fragment {


    public BreedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_breed, container, false);
    }

}
