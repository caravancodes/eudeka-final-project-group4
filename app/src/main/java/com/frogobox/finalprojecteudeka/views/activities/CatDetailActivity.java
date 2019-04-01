package com.frogobox.finalprojecteudeka.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.frogobox.finalprojecteudeka.R;

public class CatDetailActivity extends AppCompatActivity {

    public static final String EXTRA_CAT = "extra_cat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_detail);
    }
}
