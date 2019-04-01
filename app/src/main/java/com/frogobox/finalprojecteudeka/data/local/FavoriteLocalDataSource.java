package com.frogobox.finalprojecteudeka.data.local;

import android.content.Context;

import com.frogobox.finalprojecteudeka.data.CatDataSource;
import com.frogobox.finalprojecteudeka.data.FavoriteDataSource;
import com.frogobox.finalprojecteudeka.model.Cat;
import com.frogobox.finalprojecteudeka.model.Favorite;

import java.util.List;

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * Eudeka-Kel4-FinalProject
 * Copyright (C) 02/04/2019.
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
public class FavoriteLocalDataSource implements FavoriteDataSource {


    private Context context;
    private FavoriteDao favoriteDao;

    public FavoriteLocalDataSource(Context context) {
        this.context = context;
        favoriteDao = CatDB.getInstance(context).favoriteDao();
    }

    public void saveFavData(final List<Favorite> data) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                favoriteDao.insertFavData(data);
            }
        };

        new Thread(runnable).start();
    }

    @Override
    public void getListOfFavorite(final FavoriteGetCallback callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                List<Favorite> listFav = favoriteDao.getFavorite();
                if (listFav.isEmpty()) {
                    callback.onDataNotAvailable("Data kucing di database kosong");
                } else {
                    callback.onCatDataLoaded(listFav);
                }
            }
        };

        new Thread(runnable).start();
    }


    public void deleteFavData(final String id){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                favoriteDao.deleteFavData(id);
            }
        };

        new Thread(runnable).start();
    }


}
