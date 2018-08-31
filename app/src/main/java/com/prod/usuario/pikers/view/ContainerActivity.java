package com.prod.usuario.pikers.view;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.prod.usuario.pikers.R;
import com.prod.usuario.pikers.view.fragment.HomeFragment;
import com.prod.usuario.pikers.view.fragment.ProfileFragment;
import com.prod.usuario.pikers.view.fragment.SearchFragment;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        BottomNavigationView nav = (BottomNavigationView) findViewById(R.id.navigation);
        nav.setSelectedItemId(R.id.menu_home);
        HomeFragment homeFragment = new HomeFragment();
        changeFragment(homeFragment, R.id.container);
        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.menu_home :
                        HomeFragment homeFragment = new HomeFragment();
                        changeFragment(homeFragment, R.id.container);
                    break;
                    case R.id.menu_profile :
                        ProfileFragment profileFragment = new ProfileFragment();
                        changeFragment(profileFragment, R.id.container);
                    break;
                    case R.id.menu_search:
                        SearchFragment searchFragment = new SearchFragment();
                        changeFragment(searchFragment, R.id.container);
                    break;
                }
                return true;
            }
        });

    }

    public void changeFragment(android.support.v4.app.Fragment fragment, int idContainer)
    {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(idContainer,fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null)
                .commit();
    }
}
