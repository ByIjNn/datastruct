package com.binblink.designpattern.observer;

/**
 * @author binblink
 * @version 1.0.0
 * @Description
 * @Date 2020/11/21 22:41
 **/
public class ObserverA implements Observer {


    @Override
    public void update(WeatherData weatherData) {
        System.out.println("ObserverA oberser the weather change to " + weatherData);
    }
}
