package com.binblink.designpattern.observer;

/**
 * @author binblink
 * @version 1.0.0
 * @Description
 * @Date 2020/11/21 22:57
 **/
public class ObserverB implements Observer {

    @Override
    public void update(WeatherData weatherData) {
        System.out.println("ObserverB oberser the weather change to " + weatherData);
    }
}
