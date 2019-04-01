package com.frogobox.finalprojecteudeka.views.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.frogobox.finalprojecteudeka.R;
import com.frogobox.finalprojecteudeka.model.Cat;
import com.frogobox.finalprojecteudeka.viewmodel.CatNavigator;
import com.frogobox.finalprojecteudeka.viewmodel.CatViewModel;
import com.frogobox.finalprojecteudeka.viewmodel.Injection;
import com.frogobox.finalprojecteudeka.views.adapters.CatRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CatFragment extends Fragment implements CatNavigator {

    private CatViewModel catViewModel;
    private RecyclerView recyclerView;

    private CatRecyclerViewAdapter adapter;
    private ArrayList<Cat> arrayCat = new ArrayList<>();

    public CatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_cat, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerview);
        adapter = new CatRecyclerViewAdapter(getContext());
        catViewModel = new CatViewModel(Injection.provideTeamRepository(getContext()), this);
        catViewModel.getListCat();

        return rootView;
    }

    @Override
    public void loadCatList(List<Cat> listCat) {

        arrayCat.clear();
        arrayCat.addAll(listCat);
        adapter.addItem(arrayCat);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void errorLoadListCat(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
