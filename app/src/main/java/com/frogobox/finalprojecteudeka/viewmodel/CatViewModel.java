package com.frogobox.finalprojecteudeka.viewmodel;

import com.frogobox.finalprojecteudeka.data.CatDataSource;
import com.frogobox.finalprojecteudeka.data.CatRepository;
import com.frogobox.finalprojecteudeka.model.Cat;
import com.frogobox.finalprojecteudeka.viewmodel.handler.CatNavigator;

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
public class CatViewModel {

    private CatRepository catRepository;
    private CatNavigator catNavigator;

    public CatViewModel(CatRepository catRepository, CatNavigator catNavigator) {
        this.catRepository = catRepository;
        this.catNavigator = catNavigator;
    }

    public void getListCat() {

        catRepository.getListOfCats(new CatDataSource.CatsGetCallback() {
            @Override
            public void onCatDataLoaded(List<Cat> data) {
                catNavigator.loadCatList(data);
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                catNavigator.onError(errorMessage);
            }
        });

    }

}
