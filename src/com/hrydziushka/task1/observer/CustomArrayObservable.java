package com.hrydziushka.task1.observer;

import com.hrydziushka.task1.exception.CustomException;

public interface CustomArrayObservable {
    void attach(CustomArrayObserver observer);

    void detach(CustomArrayObserver observer);

    void notifyObservers() throws CustomException;
}
