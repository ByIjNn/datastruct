package com.binblink.designpattern.observer;

/**
 * @author binblink
 * @version 1.0.0
 * @Description
 * @Date 2020/11/21 15:30
 **/
public enum WeatherData {


    SPRING("spring"),SUMMER("summer"),FALL("fall"),WINTER("winter");

    private String name;

    private WeatherData(String name){
        this.name = name;
    }


    @Override
    public String toString() {
        return "WeatherData{" +
                "name='" + name + '\'' +
                '}';
    }
}
