package com.binblink.designpattern.observer;

/**
 * @author binblink
 * @version 1.0.0
 * @Description
 * @Date 2020/11/21 15:18
 **/
public interface Subject  {

     void addObserver(Observer observer);

     void notifyObservers();

     void removeObsever(Observer observer);

}
