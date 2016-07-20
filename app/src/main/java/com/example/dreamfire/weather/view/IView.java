package com.example.dreamfire.weather.view;

import com.example.dreamfire.weather.model.CurrentModel.CurrentWeatherDTO;

/**
 * Created by dreamfire on 06.07.16.
 */
public interface IView {
    void showCurrentWeather(CurrentWeatherDTO weather);
    void showError(String error);
}
