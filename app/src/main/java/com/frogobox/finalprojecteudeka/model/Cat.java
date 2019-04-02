package com.frogobox.finalprojecteudeka.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
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
@Entity(tableName = "all_cat")
public class Cat implements Parcelable {


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cat_id")
    private int cat_id;

    @ColumnInfo(name = "id")
    @SerializedName("id")
    private String id;

    @ColumnInfo(name = "name")
    @SerializedName("name")
    private String name;

    @ColumnInfo(name = "origin")
    @SerializedName("origin")
    private String origin;

    @ColumnInfo(name = "description")
    @SerializedName("description")
    private String description;

    @ColumnInfo(name = "affection_level")
    @SerializedName("affection_level")
    private int affection_level;

    @ColumnInfo(name = "child_friendly")
    @SerializedName("child_friendly")
    private int child_friendly;

    @ColumnInfo(name = "intelligence")
    @SerializedName("intelligence")
    private int intelligence;

    public Cat(int cat_id, String id, String name, String origin, String description, int affection_level, int child_friendly, int intelligence) {
        this.cat_id = cat_id;
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.description = description;
        this.affection_level = affection_level;
        this.child_friendly = child_friendly;
        this.intelligence = intelligence;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
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
        dest.writeInt(this.cat_id);
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.origin);
        dest.writeString(this.description);
        dest.writeInt(this.affection_level);
        dest.writeInt(this.child_friendly);
        dest.writeInt(this.intelligence);
    }

    protected Cat(Parcel in) {
        this.cat_id = in.readInt();
        this.id = in.readString();
        this.name = in.readString();
        this.origin = in.readString();
        this.description = in.readString();
        this.affection_level = in.readInt();
        this.child_friendly = in.readInt();
        this.intelligence = in.readInt();
    }

    public static final Creator<Cat> CREATOR = new Creator<Cat>() {
        @Override
        public Cat createFromParcel(Parcel source) {
            return new Cat(source);
        }

        @Override
        public Cat[] newArray(int size) {
            return new Cat[size];
        }
    };
}