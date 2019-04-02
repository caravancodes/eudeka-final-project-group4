package com.frogobox.finalprojecteudeka.viewmodel.handler;

import android.content.Context;

import com.frogobox.finalprojecteudeka.data.CatRepository;
import com.frogobox.finalprojecteudeka.data.FavoriteDataSource;
import com.frogobox.finalprojecteudeka.data.local.CatLocalDataSource;
import com.frogobox.finalprojecteudeka.data.local.FavoriteLocalDataSource;
import com.frogobox.finalprojecteudeka.data.remote.CatRemoteDataSource;

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
public class Injection {

    public static CatRepository provideCatRepository(Context context){
        return new CatRepository(new CatLocalDataSource(context), new CatRemoteDataSource());
    }

    public static FavoriteLocalDataSource provideFavRepository(Context context) {
        return new FavoriteLocalDataSource(context);
    }

}
