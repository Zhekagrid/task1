package com.hrydziushka.task1.service.impl;

import com.hrydziushka.task1.entity.AbstractCustomArray;
import com.hrydziushka.task1.exception.CustomException;
import com.hrydziushka.task1.service.CalculationService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class CalculationServiceImpl implements CalculationService {
    static Logger logger = LogManager.getLogger();

    @Override
    public OptionalDouble findAverage(AbstractCustomArray customArray) throws CustomException {

        OptionalDouble averageOptional;
        if (customArray.getSize() != 0) {
            double average = ((double) findSum(customArray).getAsInt()) / customArray.getSize();
            averageOptional = OptionalDouble.of(average);
            logger.log(Level.INFO, "The average is calculated:" + average);

        } else {
            averageOptional = OptionalDouble.empty();
            logger.log(Level.INFO, "Array is empty.The average is not counted");
        }

        return averageOptional;
    }

    @Override
    public OptionalInt findSum(AbstractCustomArray customArray) throws CustomException {

        OptionalInt sumOptional;
        if (customArray.getSize() != 0) {
            int sum = 0;
            for (int i = 0; i < customArray.getSize(); i++) {
                sum += customArray.getElementAt(i);
            }
            sumOptional = OptionalInt.of(sum);
            logger.log(Level.INFO, "The sum is calculated:" + sum);
        } else {
            sumOptional = OptionalInt.empty();
            logger.log(Level.INFO, "Array is empty.The sum is not calculated ");
        }


        return sumOptional;
    }

    @Override
    public int countOfPositiveNumbers(AbstractCustomArray customArray) throws CustomException {

        int count = 0;
        for (int i = 0; i < customArray.getSize(); i++) {
            if (customArray.getElementAt(i) > 0) {
                count++;
            }
        }
        logger.log(Level.INFO, "The count of positive numbers is calculated:" + count);

        return count;
    }

    @Override
    public int countOfNegativeNumbers(AbstractCustomArray customArray) throws CustomException {
        int count = 0;
        for (int i = 0; i < customArray.getSize(); i++) {
            if (customArray.getElementAt(i) < 0) {
                count++;
            }
        }
        logger.log(Level.INFO, "The count of negative numbers is calculated:" + count);

        return count;
    }

    @Override
    public OptionalDouble findAverageStream(AbstractCustomArray customArray) {

        return Arrays.stream(customArray.getData()).average();

    }

    @Override
    public OptionalInt findSumStream(AbstractCustomArray customArray) {

        OptionalInt sumOptional;
        if (customArray.getSize() != 0) {
            int sum = Arrays.stream(customArray.getData()).sum();
            sumOptional = OptionalInt.of(sum);
            logger.log(Level.INFO, "The sum is calculated:" + sum);

        } else {
            sumOptional = OptionalInt.empty();
            logger.log(Level.INFO, "Array is empty.The sum is not calculated");
        }

        return sumOptional;
    }

    @Override
    public long countOfPositiveNumbersStream(AbstractCustomArray customArray) {

        long count = Arrays.stream(customArray.getData()).filter(elem -> elem > 0).count();
        logger.log(Level.INFO, "The count of positive numbers is calculated:" + count);

        return count;
    }

    @Override
    public long countOfNegativeNumbersStream(AbstractCustomArray customArray) {
        long count = Arrays.stream(customArray.getData()).filter(elem -> elem < 0).count();
        logger.log(Level.INFO, "The count of negative numbers is calculated:" + count);
        return count;

    }
}
