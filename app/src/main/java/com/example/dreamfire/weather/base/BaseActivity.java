package com.example.dreamfire.weather.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by dreamfire on 06.07.16.
 */
public abstract class BaseActivity<T extends BaseActivityPresenter> extends AppCompatActivity {
    private T mPresenter;

    protected abstract T initPresenter();
    protected abstract void findUI();
    protected abstract int getLayoutResource();
    protected abstract void setupUI(Bundle savedInstanceState);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getLayoutResource() != 0)
            setContentView(getLayoutResource());
        findUI();
        setupUI(savedInstanceState);
    }
}
