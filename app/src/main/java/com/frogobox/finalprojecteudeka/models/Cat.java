package com.frogobox.finalprojecteudeka.models;

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
public class Cat {
    private List<CatDetail> breeds;
    public String id;
    public String url;

    public Cat(List<CatDetail> cats) {
        this.breeds = cats;
    }

    public List<CatDetail> getCats() {
        return breeds;
    }
}
