package com.frogobox.finalprojecteudeka.views.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.frogobox.finalprojecteudeka.R;
import com.frogobox.finalprojecteudeka.model.Cat;
import com.frogobox.finalprojecteudeka.views.activities.CatDetailActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * FinalProjectEudeka
 * Copyright (C) 15/03/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Line     : bullbee117
 * Phone    : 081357108568
 * Majors   : D3 Teknik Informatika 2016
 * Campus   : Telkom University
 * -----------------------------------------
 * id.amirisback.frogobox
 */
public class FavoriteRecyclerViewAdapter extends RecyclerView.Adapter<FavoriteRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Cat> data;

    public FavoriteRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void addItem(ArrayList<Cat> data){
        this.data = data;
        notifyDataSetChanged();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView catName, catOrigin, catDes;

        public ViewHolder(View itemView) {
            super(itemView);
            // -------------------------------------------------------------------------------------
            catName = itemView.findViewById(R.id.name_cat);
            catOrigin = itemView.findViewById(R.id.origin_cat);
            catDes = itemView.findViewById(R.id.des_cat);
            // -------------------------------------------------------------------------------------
        }
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.catName.setText(data.get(position).getName());
        holder.catOrigin.setText(data.get(position).getOrigin());
        holder.catDes.setText(data.get(position).getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentData = new Intent(context, CatDetailActivity.class);
                Cat parcelCat = data.get(position);
                intentData.putExtra(CatDetailActivity.EXTRA_FAVORITE, parcelCat);
                context.startActivity(intentData);
            }
        });

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_item_list_favorite, parent, false);
        return new FavoriteRecyclerViewAdapter.ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
