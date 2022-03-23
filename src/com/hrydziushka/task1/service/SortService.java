package com.hrydziushka.task1.service;

import com.hrydziushka.task1.entity.AbstractCustomArray;
import com.hrydziushka.task1.exception.CustomException;

public interface SortService {
    void bubbleSort(AbstractCustomArray customArray) throws CustomException;

    void streamSort(AbstractCustomArray customArray) throws CustomException;

    void shakerSort(AbstractCustomArray customArray) throws CustomException;

    void selectionSort(AbstractCustomArray customArray) throws CustomException;
}
