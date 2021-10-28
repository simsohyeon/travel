package com.example.travel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.travel.ui.home.FallFragment;
import com.example.travel.ui.home.FestaFragment;
import com.example.travel.ui.home.HomeFragment;
import com.example.travel.ui.home.SpringFragment;
import com.example.travel.ui.home.SuggestFragment;
import com.example.travel.ui.home.SummerFragment;
import com.example.travel.ui.home.ThemeFragment;
import com.example.travel.ui.home.WinterFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.travel.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment;
    SuggestFragment SuggestFragment;
    FestaFragment festaFragment;
    ThemeFragment themeFragment;
    SpringFragment springFragment;
    SummerFragment summerFragment;
    FallFragment fallFragment;
    WinterFragment winterFragment;

    private ActivityMainBinding binding;
    private Object HomeFragment,FestaFragment,ThemeFragment, SpringFragment, SummerFragment, FallFragment, WinterFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //바텀네비게이션
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        //버튼 클릭 시 해당하는 프레그먼트로 화면전환
        HomeFragment= (HomeFragment) getSupportFragmentManager().findFragmentById(R.id.home);
        SuggestFragment= new SuggestFragment();
        FestaFragment= new FestaFragment();
        ThemeFragment= new ThemeFragment();
        SpringFragment= new SpringFragment();
        SummerFragment= new SummerFragment();
        FallFragment= new FallFragment();
        WinterFragment= new WinterFragment();

        Button button = (Button) findViewById(R.id.suggest);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getSupportFragmentManager().beginTransaction().replace(R.id.container,SuggestFragment).addToBackStack(null).commit();
            }
        });

        Button button1 = (Button) findViewById(R.id.festa);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, (Fragment) FestaFragment).addToBackStack(null).commit();
            }
        });

        Button button2 = (Button) findViewById(R.id.theme);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, (Fragment) ThemeFragment).addToBackStack(null).commit();
            }
        });

        Button button3 = (Button) findViewById(R.id.btn_spring);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, (Fragment) SpringFragment).addToBackStack(null).commit();
            }
        });

        Button button4 = (Button) findViewById(R.id.btn_summer);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, (Fragment) SummerFragment).addToBackStack(null).commit();
            }
        });

        Button button5 = (Button) findViewById(R.id.btn_fall);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, (Fragment) FallFragment).addToBackStack(null).commit();
            }
        });

        Button button6 = (Button) findViewById(R.id.btn_winter);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, (Fragment) WinterFragment).addToBackStack(null).commit();
            }
        });

    }


    public void onFragmentChanged(int index) {
        if(index==0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,SuggestFragment).addToBackStack(null).commit();
        } else if (index==1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, (Fragment) FestaFragment).addToBackStack(null).commit();
        }else if(index==2){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, (Fragment) ThemeFragment).addToBackStack(null).commit();
        }else if(index==3) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, (Fragment) SpringFragment).addToBackStack(null).commit();
        }else if(index==4) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, (Fragment) SummerFragment).addToBackStack(null).commit();
        }else if(index==5) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, (Fragment) FallFragment).addToBackStack(null).commit();
        }else if(index==6) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, (Fragment) WinterFragment).addToBackStack(null).commit();
        }else if(index==7) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, (Fragment) HomeFragment).addToBackStack(null).commit();
        }
    }
}