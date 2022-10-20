package com.artfurniture.furniture.ui.views.activities;

import android.os.Bundle;

import com.artfurniture.furniture.R;
import com.artfurniture.furniture.databinding.ActivityHomeBinding;
import com.artfurniture.furniture.ui.views.fragments.home.FavoriteFragment;
import com.artfurniture.furniture.ui.views.fragments.home.HomeFragment;
import com.artfurniture.furniture.ui.views.fragments.home.OrdersFragment;
import com.artfurniture.furniture.ui.views.fragments.home.ProfileFragment;
import com.artfurniture.furniture.ui.views.fragments.home.ShoppingFragment;
import com.artfurniture.furniture.utils.HelperMethod;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import static com.artfurniture.furniture.utils.HelperMethod.replace;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;



    private NavigationBarView.OnItemSelectedListener onItemSelectedListener =
            item -> {

                switch (item.getItemId()){
                    case R.id.nav_home:
                        HomeFragment homeFragment = new HomeFragment();
                        replace(homeFragment, getSupportFragmentManager(), R.id.nav_host_fragment);
                        break;
                    case R.id.nav_shopping:
                        ShoppingFragment shoppingFragment = new ShoppingFragment();
                        replace(shoppingFragment, getSupportFragmentManager(), R.id.nav_host_fragment);
                        break;
                    case R.id.nav_favorite:
                        FavoriteFragment favoriteFragment = new FavoriteFragment();
                        replace(favoriteFragment, getSupportFragmentManager(), R.id.nav_host_fragment);
                        break;
                    case R.id.nav_profile:
                        ProfileFragment profileFragment = new ProfileFragment();
                        replace(profileFragment, getSupportFragmentManager(), R.id.nav_host_fragment);
                        break;
                    case R.id.nav_list:
                        OrdersFragment ordersFragment = new OrdersFragment();
                        replace(ordersFragment, getSupportFragmentManager(), R.id.nav_host_fragment);
                        break;
                }

                return true;

            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home );

        binding.activityHomeBottomNavBar.setOnItemSelectedListener(onItemSelectedListener);

        HomeFragment homeFragment = new HomeFragment();
        replace(homeFragment, getSupportFragmentManager(), R.id.nav_host_fragment);


    }
}