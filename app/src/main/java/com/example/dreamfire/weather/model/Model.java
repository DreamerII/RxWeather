package com.example.dreamfire.weather.model;

import com.example.dreamfire.weather.model.CurrentModel.CurrentWeatherDTO;

import rx.Observable;

/**
 * Created by dreamfire on 06.07.16.
 */
public interface Model {
    Observable<CurrentWeatherDTO> getCurrentWeather(String city, String appid, String metric);
}
