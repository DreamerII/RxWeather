package com.example.dreamfire.weather.view.activitiy;

import android.content.Context;
import android.location.LocationManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dreamfire.weather.R;
import com.example.dreamfire.weather.base.BaseActivity;
import com.example.dreamfire.weather.base.BaseFragment;
import com.example.dreamfire.weather.view.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.container);

        if(fragment == null){
            fragment = new HomeFragment();
            fm.beginTransaction()
                    .add(R.id.container, fragment).commit();
        }
    }
}
