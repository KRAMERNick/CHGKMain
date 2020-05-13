package com.example.chgk;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private NavOptions navOptions;
    private NavOptions.Builder builder = new NavOptions.Builder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(nav);
        navView.setItemIconTintList(null);


        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.navigate(R.id.navigation_dashboard);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener nav = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selected = null;

            switch (item.getItemId())
            {
                case R.id.navigation_timetable:
                    navOptions = builder.setEnterAnim(R.anim.slide_in_right).setExitAnim(R.anim.slide_out_left).build();
                    navController.navigate(R.id.navigation_dashboard, null, navOptions);
                    break;
                case R.id.navigation_values:
                    navOptions = builder.setEnterAnim(R.anim.slide_in_right).setExitAnim(R.anim.slide_out_left).build();
                    navController.navigate(R.id.navigation_home, null, navOptions);
                    break;
                case R.id.navigation_settings:
                    navOptions = builder.setEnterAnim(R.anim.slide_in_right).setExitAnim(R.anim.slide_out_left).build();
                    navController.navigate(R.id.navigation_notifications, null, navOptions);
                    break;
            }

            //getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, selected).commit();
            return true;
        }
    };

}
