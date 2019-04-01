package com.frogobox.finalprojecteudeka.data;

import com.frogobox.finalprojecteudeka.data.local.CatLocalDataSource;
import com.frogobox.finalprojecteudeka.data.remote.CatRemoteDataSource;
import com.frogobox.finalprojecteudeka.model.Cat;

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
public class CatRepository implements CatDataSource {

    private CatLocalDataSource catLocalDataSource;
    private CatRemoteDataSource catRemoteDataSource;

    public CatRepository(CatLocalDataSource catLocalDataSource, CatRemoteDataSource catRemoteDataSource) {
        this.catLocalDataSource = catLocalDataSource;
        this.catRemoteDataSource = catRemoteDataSource;
    }

    public void getCatFromRemote(final CatsGetCallback callback) {

        catRemoteDataSource.getListOfCats(new CatsGetCallback() {
            @Override
            public void onCatDataLoaded(List<Cat> data) {
                catLocalDataSource.saveCatData(data);
                callback.onCatDataLoaded(data);
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                callback.onDataNotAvailable(errorMessage);
            }
        });

    }

    @Override
    public void getListOfCats(final CatsGetCallback callback) {

        catLocalDataSource.getListOfCats(new CatsGetCallback() {
            @Override
            public void onCatDataLoaded(List<Cat> data) {
                callback.onCatDataLoaded(data);
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                getCatFromRemote(callback);
            }
        });

    }
}
