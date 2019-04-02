package com.frogobox.finalprojecteudeka.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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

@Entity(tableName = "all_fav")
public class Favorite implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "fav_id")
    private int fav_id;

    @ColumnInfo(name = "id")
    private String id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "origin")
    private String origin;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "affection_level")
    private int affection_level;

    @ColumnInfo(name = "child_friendly")
    private int child_friendly;

    @ColumnInfo(name = "intelligence")
    private int intelligence;

    public Favorite(String id, String name, String origin, String description, int affection_level, int child_friendly, int intelligence) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.description = description;
        this.affection_level = affection_level;
        this.child_friendly = child_friendly;
        this.intelligence = intelligence;
    }

    public int getFav_id() {
        return fav_id;
    }

    public void setFav_id(int fav_id) {
        this.fav_id = fav_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAffection_level() {
        return affection_level;
    }

    public void setAffection_level(int affection_level) {
        this.affection_level = affection_level;
    }

    public int getChild_friendly() {
        return child_friendly;
    }

    public void setChild_friendly(int child_friendly) {
        this.child_friendly = child_friendly;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.fav_id);
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.origin);
        dest.writeString(this.description);
        dest.writeInt(this.affection_level);
        dest.writeInt(this.child_friendly);
        dest.writeInt(this.intelligence);
    }

    protected Favorite(Parcel in) {
        this.fav_id = in.readInt();
        this.id = in.readString();
        this.name = in.readString();
        this.origin = in.readString();
        this.description = in.readString();
        this.affection_level = in.readInt();
        this.child_friendly = in.readInt();
        this.intelligence = in.readInt();
    }

    public static final Creator<Favorite> CREATOR = new Creator<Favorite>() {
        @Override
        public Favorite createFromParcel(Parcel source) {
            return new Favorite(source);
        }

        @Override
        public Favorite[] newArray(int size) {
            return new Favorite[size];
        }
    };
}
