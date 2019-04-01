package com.frogobox.finalprojecteudeka.data;

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
public interface CatDataSource {
    void getListOfCats(CatsGetCallback callback);

    interface CatsGetCallback {
        void onCatDataLoaded(List<Cat> data);
        void onDataNotAvailable(String errorMessage);
    }
}
