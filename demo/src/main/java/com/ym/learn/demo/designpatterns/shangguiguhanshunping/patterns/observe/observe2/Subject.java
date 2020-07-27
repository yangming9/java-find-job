package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.observe.observe2;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();

}
