package com.frogobox.finalprojecteudeka.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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
@Entity(tableName = "cat")
public class CatDetail {
    @PrimaryKey(autoGenerate = true)
    public String id;

    @ColumnInfo(name = "cat_name")
    public String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CatDetail(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public CatWeight weight;
    public String cfa_url;
    public String vetstreet_url;
    public String vcahospitals_url;
    public String temperament;
    public String origin;
    public String country_code;
    public String description;
    public String life_span;
    public int indoor;
    public int lap;
    public String alt_names;
    public int adaptability;
    public int affection_level;
    public int child_friendly;
    public int dog_friendly;
    public int energy_level;
    public int grooming;
    public int health_issues;
    public int intelligence;
    public int shedding_level;
    public int social_needs;
    public int stranger_friendly;
    public int vocalisation;
    public int experimental;
    public int hairless;
    public int natural;
    public int rare;
    public int rex;
    public int suppressed_tail;
    public int short_legs;
    public String wikipedia_url;
    public int hypoallergenic;
}