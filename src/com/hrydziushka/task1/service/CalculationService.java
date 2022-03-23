package com.hrydziushka.task1.service;

import com.hrydziushka.task1.entity.AbstractCustomArray;
import com.hrydziushka.task1.exception.CustomException;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface CalculationService {
    OptionalDouble findAverage(AbstractCustomArray customArray) throws CustomException;

    OptionalInt findSum(AbstractCustomArray customArray) throws CustomException;

    int countOfPositiveNumbers(AbstractCustomArray customArray) throws CustomException;

    int countOfNegativeNumbers(AbstractCustomArray customArray) throws CustomException;

    OptionalDouble findAverageStream(AbstractCustomArray customArray);

    OptionalInt findSumStream(AbstractCustomArray customArray);

    long countOfPositiveNumbersStream(AbstractCustomArray customArray);

    long countOfNegativeNumbersStream(AbstractCustomArray customArray);
}
