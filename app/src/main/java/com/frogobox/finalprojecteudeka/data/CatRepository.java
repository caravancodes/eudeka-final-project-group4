package com.frogobox.finalprojecteudeka.data;

import com.frogobox.finalprojecteudeka.data.local.CatLocalDataSource;
import com.frogobox.finalprojecteudeka.data.remote.CatRemoteDataSource;
import com.frogobox.finalprojecteudeka.models.Cat;

import androidx.annotation.Nullable;

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
public class CatRepository implements CatDataSource {

    private CatRemoteDataSource catRemoteData;
    private CatLocalDataSource catLocalData;

    public CatRepository(CatRemoteDataSource catRemoteData, CatLocalDataSource catLocalData) {
        this.catRemoteData = catRemoteData;
        this.catLocalData = catLocalData;
    }

    @Override
    public void getListOfCats(final CatsGetCallback callback) {
        catLocalData.getListOfCats(new CatsGetCallback() {
            @Override
            public void onCatDataLoaded(Cat data) {
                callback.onCatDataLoaded(data);
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                getCatsFromRemoteData(callback);
            }
        });
    }

    private void getCatsFromRemoteData(@Nullable final CatsGetCallback callback) {
        catRemoteData.getListOfCats(new CatsGetCallback() {

            @Override
            public void onCatDataLoaded(Cat data) {
                catLocalData.saveCatData(data.getCats());

                callback.onCatDataLoaded(data);

            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                callback.onDataNotAvailable(errorMessage);
            }
        });
    }
}
