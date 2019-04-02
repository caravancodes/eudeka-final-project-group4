package com.frogobox.finalprojecteudeka.data.local;

import android.telecom.Call;

import com.frogobox.finalprojecteudeka.model.Cat;
import com.frogobox.finalprojecteudeka.model.Favorite;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

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

@Dao
public interface FavoriteDao {
    @Query("SELECT * FROM all_fav")
    List<Favorite> getFavorite();

    @Insert
    void insertFavDataCat(Cat data);

    @Insert
    void insertFavDataFavorite(Favorite data);

    @Query("DELETE FROM all_fav WHERE id = :id")
    void deleteFavData(String id);

    @Query("SELECT * FROM all_fav WHERE id = :id")
    List<Favorite> getFavoriteById(String id);

}
