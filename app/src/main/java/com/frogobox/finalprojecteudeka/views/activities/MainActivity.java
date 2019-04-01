package com.frogobox.finalprojecteudeka.views.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.frogobox.finalprojecteudeka.R;
import com.frogobox.finalprojecteudeka.views.fragments.CatFragment;
import com.frogobox.finalprojecteudeka.views.fragments.FavoriteCatFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        openFragment(new CatFragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    openFragment(new CatFragment());
                    setTitle(getString(R.string.app_name));
                    return true;
                case R.id.navigation_add:
                    openFragment(new FavoriteCatFragment());
                    setTitle(getString(R.string.title_favorite));
                    return true;
            }
            return false;
        }
    };

    private void openFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}
