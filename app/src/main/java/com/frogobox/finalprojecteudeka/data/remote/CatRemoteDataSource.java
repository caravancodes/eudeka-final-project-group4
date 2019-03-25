package com.frogobox.finalprojecteudeka.data.remote;

import com.frogobox.finalprojecteudeka.data.CatDataSource;
import com.frogobox.finalprojecteudeka.models.Cat;

import java.util.List;

import androidx.annotation.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
public class CatRemoteDataSource implements CatDataSource {

    private ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

    @Override
    public void getListOfCats(final CatsGetCallback callback) {
        Call<List<Cat>> call = apiInterface.getCats("", "", "");
        call.enqueue(new Callback<List<Cat>>() {
            @Override
            public void onResponse(@NonNull Call<List<Cat>> call, @NonNull Response<List<Cat>> response) {
                callback.onCatDataLoaded(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<Cat>> call, @NonNull Throwable t) {
                callback.onDataNotAvailable(t.getMessage());
            }
        });
    }
}
