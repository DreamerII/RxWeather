package com.example.dreamfire.weather.presenter;

import com.example.dreamfire.weather.model.Model;
import com.example.dreamfire.weather.model.ModelImpl;
import com.example.dreamfire.weather.view.IView;

import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by dreamfire on 07.07.16.
 */
public class PresenterImpl implements Presenter {
    private static final String TAG = "PresenterImpl";
    private IView view;
    private Model model = new ModelImpl();
    private Subscription subscription = Subscriptions.empty();

    public PresenterImpl(IView view){
        this.view = view;
    }
    @Override
    public void onStop() {
        if(!subscription.isUnsubscribed())
            subscription.unsubscribe();
    }



    @Override
    public void getWeather() {
        if(!subscription.isUnsubscribed())
            subscription.unsubscribe();

        subscription = model.getCurrentWeather("Kiev", "7d261ea6e556c0f4f08906ae8353f2bd", "metric")
                .subscribe(currentWeather -> view.showCurrentWeather(currentWeather),
                        throwable -> view.showError(throwable.getMessage().toString()));

    }
}
