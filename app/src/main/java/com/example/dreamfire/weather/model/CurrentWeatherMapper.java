package com.example.dreamfire.weather.model;

import com.example.dreamfire.weather.model.CurrentModel.CurrentWeather;
import com.example.dreamfire.weather.model.CurrentModel.CurrentWeatherDTO;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by dreamfire on 07.07.16.
 */
public class CurrentWeatherMapper implements Func1<CurrentWeatherDTO, CurrentWeather>{
    @Override
    public CurrentWeather call(CurrentWeatherDTO currentWeatherDTO) {

        return null;
    }
}
