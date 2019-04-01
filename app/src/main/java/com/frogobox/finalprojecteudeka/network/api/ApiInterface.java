package com.frogobox.finalprojecteudeka.network.api;

import com.frogobox.finalprojecteudeka.model.Cat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import static com.frogobox.finalprojecteudeka.network.bridge.ApiUrl.ListApiUrl.API_KEY;
import static com.frogobox.finalprojecteudeka.network.bridge.ApiUrl.ListApiUrl.HEADER_API_KEY;
import static com.frogobox.finalprojecteudeka.network.bridge.ApiUrl.ListApiUrl.URL_BREEDS;

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
public interface ApiInterface {

    @Headers(HEADER_API_KEY)
    @GET(URL_BREEDS)
    Call<List<Cat>> getCats(
        @Query("attach_breed") int attachBreed,
        @Query("page") int page,
        @Query("limit") int limit
    );

}
