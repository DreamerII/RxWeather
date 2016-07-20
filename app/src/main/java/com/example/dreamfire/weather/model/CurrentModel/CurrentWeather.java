package com.example.dreamfire.weather.model.CurrentModel;

import java.util.List;

/**
 * Created by dreamfire on 07.07.16.
 */
public class CurrentWeather {
    private String name;
    private Double temp;
    private Double temp_min;
    private Double temp_max;
    private Main main;
    private Wind wind;
    private List<Weather> weather;
    private Sys sys;

    public CurrentWeather(String name){
        this.name = name;
//        this.temp = temp;
//        this.temp_min = temp_min;
//        this.temp_max = temp_max;
//        this.main = main;
//        this.wind = wind;
//        this.weather = weather;
//        this.sys = sys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(Double temp_min) {
        this.temp_min = temp_min;
    }

    public Double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(Double temp_max) {
        this.temp_max = temp_max;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }
}
