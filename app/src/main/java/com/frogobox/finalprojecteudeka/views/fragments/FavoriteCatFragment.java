package com.frogobox.finalprojecteudeka.views.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.frogobox.finalprojecteudeka.R;
import com.frogobox.finalprojecteudeka.model.Cat;
import com.frogobox.finalprojecteudeka.model.Favorite;
import com.frogobox.finalprojecteudeka.viewmodel.CatViewModel;
import com.frogobox.finalprojecteudeka.viewmodel.FavoriteViewModel;
import com.frogobox.finalprojecteudeka.viewmodel.handler.FavoriteNavigator;
import com.frogobox.finalprojecteudeka.viewmodel.handler.Injection;
import com.frogobox.finalprojecteudeka.views.adapters.CatRecyclerViewAdapter;
import com.frogobox.finalprojecteudeka.views.adapters.FavoriteRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteCatFragment extends Fragment implements FavoriteNavigator {

    private FavoriteViewModel favoriteViewModel;
    private RecyclerView recyclerView;

    private FavoriteRecyclerViewAdapter adapter;
    private ArrayList<Favorite> arrayList = new ArrayList<>();

    public FavoriteCatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_favorite_cat, container, false);

        favoriteViewModel = new FavoriteViewModel(Injection.provideFavRepository(getContext()));
        favoriteViewModel.setFavoriteNavigator(this);
        adapter = new FavoriteRecyclerViewAdapter(getContext());
        recyclerView = rootView.findViewById(R.id.recyclerview);
        favoriteViewModel.getListFav();
        return rootView;
    }
    
    @Override
    public void loadFav(List<Favorite> favorites) {
        arrayList.clear();
        arrayList.addAll(favorites);
        adapter.addItem(arrayList);
        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            }
        });
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onError(final String message) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
