package com.frogobox.finalprojecteudeka.data.remote;

import com.frogobox.finalprojecteudeka.data.CatDataSource;
import com.frogobox.finalprojecteudeka.model.Cat;
import com.frogobox.finalprojecteudeka.network.bridge.ApiClient;
import com.frogobox.finalprojecteudeka.network.api.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
public class CatRemoteDataSource implements CatDataSource {

    private ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

    @Override
    public void getListOfCats(final CatsGetCallback callback) {
        Call<List<Cat>> call = apiInterface.getCats(3,3,10);
        call.enqueue(new Callback<List<Cat>>() {
            @Override
            public void onResponse(Call<List<Cat>> call, Response<List<Cat>> response) {
                callback.onCatDataLoaded(response.body());
            }

            @Override
            public void onFailure(Call<List<Cat>> call, Throwable t) {
                callback.onDataNotAvailable(t.toString());
            }
        });

    }
}
