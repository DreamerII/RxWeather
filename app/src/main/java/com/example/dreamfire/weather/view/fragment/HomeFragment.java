package com.example.dreamfire.weather.view.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dreamfire.weather.R;
import com.example.dreamfire.weather.model.CurrentModel.CurrentWeatherDTO;
import com.example.dreamfire.weather.presenter.Presenter;
import com.example.dreamfire.weather.presenter.PresenterImpl;
import com.example.dreamfire.weather.view.IView;

/**
 * Created by dreamfire on 06.07.16.
 */
public class HomeFragment extends Fragment implements IView {
    private static final String TAG = "HomeFragment";
    private Presenter mPresenter;
    private TextView mCityName, mMinTemp, mMaxTemp, mCurrTemp, mMain,
    mWind, mCloudiness, mPressure, mHumidity, mSunrise, mSunset;
    private ImageView mIcon;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new PresenterImpl(this);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        findUI(v);
        mPresenter.getWeather();
        return v;
    }

    private void findUI(View _v){
        mCityName = (TextView) _v.findViewById(R.id.tvCityName);
        mMinTemp = (TextView) _v.findViewById(R.id.tvMinTemp);
        mMaxTemp = (TextView) _v.findViewById(R.id.tvMaxTemp);
        mCurrTemp = (TextView) _v.findViewById(R.id.tvTemp);
        mMain = (TextView) _v.findViewById(R.id.tvMain);
        mWind = (TextView) _v.findViewById(R.id.tvWind);
        mCloudiness = (TextView) _v.findViewById(R.id.tvCloudiness);
        mPressure = (TextView) _v.findViewById(R.id.tvPressure);
        mHumidity = (TextView) _v.findViewById(R.id.tvHumidity);
        mSunrise = (TextView) _v.findViewById(R.id.tvSunrise);
        mSunset = (TextView) _v.findViewById(R.id.tvSunset);
        mIcon = (ImageView) _v.findViewById(R.id.ivWeatherIcon);
    }

    private void setData(CurrentWeatherDTO weather){
        mCityName.setText("Weather in " + weather.getName());
        mMinTemp.setText("Min Temp: " + weather.getMain().getTempMin());
        mCurrTemp.setText("Curr Temp: " + weather.getMain().getTemp());
        mMain.setText(weather.getWeather().get(0).getMain());
        mMaxTemp.setText("Max Temp: " + weather.getMain().getTempMax());
        mWind.setText("Wind: " + weather.getWind().getSpeed() + " m/s");
        mCloudiness.setText("Cloudiness: " + weather.getWeather().get(0).getDescription());
        mPressure.setText("Pressure: " + weather.getMain().getPressure() + "hpa");
        mHumidity.setText("Humidity: " + weather.getMain().getHumidity()+"%");
        mSunrise.setText("Sunrise: " + weather.getSys().getSunrise());
        mSunset.setText("Sunset: " + weather.getSys().getSunset());
        Glide.with(getActivity()).load("http://api.openweathermap.org/img/w/"+weather.getWeather().get(0).getIcon()+".png")
                .into(mIcon);
    }

    @Override
    public void showCurrentWeather(CurrentWeatherDTO weather) {
        Log.d(TAG, "showCurrentWeather " + weather.getName());
        setData(weather);
    }

    @Override
    public void showError(String error) {
        Log.d(TAG, "showError " + error);
        Toast.makeText(getActivity(), error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStop() {
        super.onStop();
        if(mPresenter != null)
            mPresenter.onStop();
    }
}
