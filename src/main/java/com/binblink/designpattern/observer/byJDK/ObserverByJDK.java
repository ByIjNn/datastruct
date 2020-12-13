package com.binblink.designpattern.observer.byJDK;

import com.binblink.designpattern.observer.WeatherData;

import java.util.Observable;
import java.util.Observer;

/**
 * @author binblink
 * @version 1.0.0
 * @Description
 * @Date 2020/11/21 23:06
 **/
public class ObserverByJDK implements Observer {



    @Override
    public void update(Observable o, Object arg) {

        System.out.println((WeatherData) arg);
    }
}
