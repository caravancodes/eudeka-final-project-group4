package com.frogobox.finalprojecteudeka.data.remote;

import com.frogobox.finalprojecteudeka.models.Cat;
import com.frogobox.finalprojecteudeka.models.Favorite;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

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

    @GET(ApiUrl.ListApiUrl.PREFIX + "breeds")
    Call<List<Cat>> getCats(
        @Query("attach_breed") String attachBreed,
        @Query("page") String page,
        @Query("limit") String limit
    );

    @GET(ApiUrl.ListApiUrl.PREFIX + "favourites")
    Call<List<Favorite>> getFavourites(
        @Query("sub_id") String ib,
        @Query("limit") String limit,
        @Query("page") String page
    );
}
