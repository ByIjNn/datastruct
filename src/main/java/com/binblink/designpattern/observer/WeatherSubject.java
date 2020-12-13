package com.binblink.designpattern.observer;

import java.io.InputStream;
import java.util.List;

/**
 * @author binblink
 * @version 1.0.0
 * @Description
 * @Date 2020/11/21 22:28
 **/
public class WeatherSubject implements Subject {

    private List<Observer> observers;

    private WeatherData weather = WeatherData.SPRING;


    public WeatherSubject(List<Observer> observerList) {
        this.observers = observerList;
    }

    public void changeWeather(WeatherData weatherData){
        this.weather = weatherData;
        notifyObservers();
    }


    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {

        observers.forEach(o -> {
            o.update(this.weather);
        });

    }

    @Override
    public void removeObsever(Observer observer) {
        this.observers.remove(observer);
    }


}
