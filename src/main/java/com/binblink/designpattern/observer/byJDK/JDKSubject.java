package com.binblink.designpattern.observer.byJDK;

import com.binblink.designpattern.observer.WeatherData;

import java.util.Observable;

/**
 * @author binblink
 * @version 1.0.0
 * @Description jdk 由于需要继承Observable类（而不是接口） ，导致扩展性不强（多继承的限制）
 *   所以一般不用jdk的API实现观察者模式
 * @Date 2020/11/21 23:04
 **/
public class JDKSubject extends Observable{

    private WeatherData weather = WeatherData.SUMMER;


    public void chargeWeather(WeatherData weather){

        if(this.weather != weather){
            this.setChanged();
        }
        this.weather = weather;

        this.notifyObservers(weather);
    }

}
