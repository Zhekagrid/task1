package com.hrydziushka.task1.observer;

import com.hrydziushka.task1.exception.CustomException;

public interface CustomArrayObserver {
    void arrayChanged(CustomArrayEvent event) throws CustomException;

}
