package com.frogobox.finalprojecteudeka.data.local;

import android.content.Context;

import com.frogobox.finalprojecteudeka.data.CatDataSource;
import com.frogobox.finalprojecteudeka.model.Cat;

import java.util.List;

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
public class CatLocalDataSource implements CatDataSource {

    private Context context;
    private CatDao catDao;

    public CatLocalDataSource(Context context) {
        this.context = context;
        catDao = CatDB.getInstance(context).catDao();
    }

    @Override
    public void getListOfCats(final CatsGetCallback callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                List<Cat> listCat = catDao.getCats();
                if (listCat.isEmpty()) {
                    callback.onDataNotAvailable("Data kucing di database kosong");
                } else {
                    callback.onCatDataLoaded(listCat);
                }
            }
        };

        new Thread(runnable).start();
    }

    public void saveCatData(final List<Cat> data) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                catDao.insertCatData(data);
            }
        };

        new Thread(runnable).start();
    }
}
