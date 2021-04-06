package com.binblink.designpattern.observer;

import com.binblink.designpattern.observer.byJDK.JDKSubject;
import com.binblink.designpattern.observer.byJDK.ObserverByJDK;
import com.binblink.designpattern.observer.byJDK.ObserverByJDK2;

import java.util.ArrayList;

/**
 * @author binblink
 * @version 1.0.0
 * @Description
 * @Date 2020/11/21 22:58
 **/
public class App {

    public static void main(String[] args) {

        WeatherSubject weatherSubject = new WeatherSubject(new ArrayList<Observer>(16));

        ObserverA a = new ObserverA();
        ObserverB b = new ObserverB();

        weatherSubject.addObserver(a);
        weatherSubject.addObserver(b);

        JDKSubject jdkSubject = new JDKSubject();

        jdkSubject.addObserver(new ObserverByJDK());
        jdkSubject.addObserver(new ObserverByJDK2());

        jdkSubject.chargeWeather(WeatherData.WINTER);
//        weatherSubject.changeWeather(WeatherData.WINTER);

    }
}
