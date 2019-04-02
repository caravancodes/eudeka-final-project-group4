package com.frogobox.finalprojecteudeka.viewmodel;

import com.frogobox.finalprojecteudeka.data.FavoriteDataSource;
import com.frogobox.finalprojecteudeka.data.local.FavoriteLocalDataSource;
import com.frogobox.finalprojecteudeka.model.Cat;
import com.frogobox.finalprojecteudeka.model.Favorite;
import com.frogobox.finalprojecteudeka.viewmodel.handler.FavoriteNavigator;
import com.frogobox.finalprojecteudeka.viewmodel.handler.FavoriteWorkNavigator;

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
public class FavoriteViewModel {

    private FavoriteLocalDataSource favoriteLocalDataSource;
    private FavoriteNavigator favoriteNavigator;
    private FavoriteWorkNavigator favoriteWorkNavigator;

    public FavoriteViewModel(FavoriteLocalDataSource favoriteLocalDataSource) {
        this.favoriteLocalDataSource = favoriteLocalDataSource;
    }

    public void setFavoriteNavigator(FavoriteNavigator favoriteNavigator) {
        this.favoriteNavigator = favoriteNavigator;
    }

    public void setFavoriteWorkNavigator(FavoriteWorkNavigator favoriteWorkNavigator) {
        this.favoriteWorkNavigator = favoriteWorkNavigator;
    }

    public void getListFav() {

        favoriteLocalDataSource.getListOfFavorite(new FavoriteDataSource.FavoriteGetCallback() {
            @Override
            public void onCatDataLoaded(List<Favorite> data) {
                favoriteNavigator.loadFav(data);
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                favoriteNavigator.onError(errorMessage);
            }
        });

    }

    public void getListFavById(String id) {

        favoriteLocalDataSource.getListOfFavoriteById(new FavoriteDataSource.FavoriteGetCallback() {
            @Override
            public void onCatDataLoaded(List<Favorite> data) {
                favoriteNavigator.loadFav(data);
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                favoriteNavigator.onError(errorMessage);
            }
        }, id);

    }

    public void insertFavDataCat(String message, Cat cat) {
        if (cat != null) {
            favoriteLocalDataSource.saveFavDataCat(cat);
            favoriteWorkNavigator.onSuccessEdit(message);
        } else {
            favoriteWorkNavigator.onError(message);
        }
    }


    public void insertFavDataFavorite(String message, Favorite favorite) {
        if (favorite != null) {
            favoriteLocalDataSource.saveFavDataFavorite(favorite);
            favoriteWorkNavigator.onSuccessEdit(message);
        } else {
            favoriteWorkNavigator.onError(message);
        }
    }

    public void deleteFav(String message, String id) {

        if (!id.isEmpty()){
            favoriteLocalDataSource.deleteFavData(id);
            favoriteWorkNavigator.onSuccessEdit(message);
        } else {
            favoriteWorkNavigator.onError(message);
        }

    }


}
