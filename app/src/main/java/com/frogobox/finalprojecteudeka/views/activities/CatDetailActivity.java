package com.frogobox.finalprojecteudeka.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.frogobox.finalprojecteudeka.R;
import com.frogobox.finalprojecteudeka.model.Cat;
import com.frogobox.finalprojecteudeka.model.Favorite;
import com.frogobox.finalprojecteudeka.viewmodel.FavoriteViewModel;
import com.frogobox.finalprojecteudeka.viewmodel.handler.FavoriteNavigator;
import com.frogobox.finalprojecteudeka.viewmodel.handler.FavoriteWorkNavigator;
import com.frogobox.finalprojecteudeka.viewmodel.handler.Injection;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class CatDetailActivity extends AppCompatActivity implements FavoriteWorkNavigator, FavoriteNavigator {

    public static final String EXTRA_CAT = "extra_cat";
    public static final String EXTRA_FAVORITE = "extra_fav";
    private boolean isFavorite = false;
    private Menu mMenu = null;
    private Cat extraCat;
    private Favorite extraFavorite, extraFavoriteCat;
    private ScrollView scrollView;

    private ArrayList<Favorite> arrayList = new ArrayList<>();

    private FavoriteViewModel favoriteViewModel;

    private int extra_fav_id, extra_child_friendly, extra_affection_level, extra_intelligence;
    private String extra_id, extra_name, extra_origin, extra_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        favoriteViewModel = new FavoriteViewModel(Injection.provideFavRepository(this));
        favoriteViewModel.setFavoriteNavigator(this);
        favoriteViewModel.setFavoriteWorkNavigator(this);

        TextView name = findViewById(R.id.detail_name);
        TextView origin = findViewById(R.id.detail_origin);
        TextView overview = findViewById(R.id.detail_des);
        TextView inteligen = findViewById(R.id.detail_inteligen);
        TextView affection = findViewById(R.id.detail_affection);
        scrollView = findViewById(R.id.scrollViews);

        getExtraData();
        favoriteViewModel.getListFavById(extra_id);

        name.setText(extra_name);
        origin.setText(extra_origin);
        overview.setText(extra_description);
        inteligen.setText(String.valueOf(extra_intelligence));
        affection.setText(String.valueOf(extra_affection_level));
        setTitle(extra_name);




    }

    public void getExtraData() {

        extraCat = getIntent().getParcelableExtra(EXTRA_CAT);
        extraFavorite = getIntent().getParcelableExtra(EXTRA_FAVORITE);
        // -----------------------------------------------------------------------------------------

        if (extraCat != null) {
            extra_id = extraCat.getId();
            extra_name = extraCat.getName();
            extra_origin = extraCat.getOrigin();
            extra_description = extraCat.getDescription();
            extra_child_friendly = extraCat.getChild_friendly();
            extra_affection_level = extraCat.getAffection_level();
            extra_intelligence = extraCat.getIntelligence();
            setFavoriteState(extra_id);

            extraFavoriteCat = new Favorite(extra_id,
                    extra_name,
                    extra_origin,
                    extra_description,
                    extra_child_friendly,
                    extra_affection_level,
                    extra_intelligence);
        }
        // -----------------------------------------------------------------------------------------
        if (extraFavorite != null) {
            extra_id = extraFavorite.getId();
            extra_name = extraFavorite.getName();
            extra_origin = extraFavorite.getOrigin();
            extra_description = extraFavorite.getDescription();
            extra_child_friendly = extraFavorite.getChild_friendly();
            extra_affection_level = extraFavorite.getAffection_level();
            extra_intelligence = extraFavorite.getIntelligence();
            setFavoriteState(extra_id);
        }
        // -----------------------------------------------------------------------------------------
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail_favorite, menu);
        mMenu = menu;
        setIconFavorite();
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        } else if (item.getItemId() == R.id.menu_favorite){
            if (isFavorite) {
                setRemoveFromFavorite(extra_id);
            } else {
                setAddToFavorite();
            }

            isFavorite = !isFavorite;
            setIconFavorite();
        }
        return super.onOptionsItemSelected(item);
    }


    private void setIconFavorite(){
        if (isFavorite) {
            mMenu.getItem(0).setIcon(R.drawable.ic_added_to_favorite);
        } else {
            mMenu.getItem(0).setIcon(R.drawable.ic_add_to_favorite);
        }
    }

    private void setAddToFavorite(){
        try {

            if (extraFavoriteCat != null) {
                favoriteViewModel.insertFavDataFavorite(getString(R.string.sucsess_insert), extraFavoriteCat);
            }

            if (extraFavorite != null) {
                favoriteViewModel.insertFavDataFavorite(getString(R.string.sucsess_insert), extraFavorite);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void setRemoveFromFavorite(String mId){
        try {
            favoriteViewModel.deleteFav(getString(R.string.sucsess_delete),mId);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void setFavoriteState(String mId){
        isFavorite = arrayList.size() != 0;
    }



    @Override
    public void onSuccessEdit(String message) {
        Snackbar.make(scrollView, message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void loadFav(List<Favorite> favorites) {
        arrayList.clear();
        arrayList.addAll(favorites);
    }

    @Override
    public void onError(String message) {
        Snackbar.make(scrollView, message, Snackbar.LENGTH_SHORT).show();
    }
}
