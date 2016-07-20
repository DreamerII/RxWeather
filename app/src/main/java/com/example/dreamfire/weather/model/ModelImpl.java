package com.example.dreamfire.weather.model;

import com.example.dreamfire.weather.model.CurrentModel.CurrentWeatherDTO;
import com.example.dreamfire.weather.model.api.ApiInterface;
import com.example.dreamfire.weather.model.api.ApiModule;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dreamfire on 07.07.16.
 */
public class ModelImpl implements Model {
    ApiInterface apiInterface = ApiModule.getInterface();

    @Override
    public Observable<CurrentWeatherDTO> getCurrentWeather(String city, String appid, String metric) {
        return apiInterface.getCurrentWeather(city, appid, metric)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
