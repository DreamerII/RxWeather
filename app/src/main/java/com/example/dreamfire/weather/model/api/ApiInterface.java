package com.example.dreamfire.weather.model.api;

import com.example.dreamfire.weather.model.CurrentModel.CurrentWeatherDTO;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by dreamfire on 06.07.16.
 */
public interface ApiInterface {
    @GET("data/2.5/weather")
    Observable<CurrentWeatherDTO> getCurrentWeather(@Query("q") String city,
                                                    @Query("appid") String appid,
                                                    @Query("units") String metric);
}
