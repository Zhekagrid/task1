package com.hrydziushka.task1.service.impl;

import com.hrydziushka.task1.entity.AbstractCustomArray;
import com.hrydziushka.task1.exception.CustomException;
import com.hrydziushka.task1.service.MinMaxService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.OptionalInt;

public class MinMaxServiceImpl implements MinMaxService {
    static Logger logger = LogManager.getLogger();

    @Override
    public OptionalInt min(AbstractCustomArray customArray) throws CustomException {

        OptionalInt minOptional;

        if (customArray.getSize() != 0) {
            int min = customArray.getElementAt(0);
            for (int i = 0; i < customArray.getSize(); i++) {
                min = Math.min(min, customArray.getElementAt(i));
            }
            minOptional = OptionalInt.of(min);
            logger.log(Level.INFO, "The minimum is calculated:" + min);
        } else {
            minOptional = OptionalInt.empty();
            logger.log(Level.INFO, "Array is empty.The minimum is not counted");
        }

        return minOptional;
    }

    @Override
    public OptionalInt max(AbstractCustomArray customArray) throws CustomException {

        OptionalInt maxOptional;
        if (customArray.getSize() != 0) {
            int max = customArray.getElementAt(0);
            for (int i = 0; i < customArray.getSize(); i++) {
                max = Math.max(max, customArray.getElementAt(i));
            }
            maxOptional = OptionalInt.of(max);
            logger.log(Level.INFO, "The maximum is calculated:" + max);
        } else {
            maxOptional = OptionalInt.empty();
            logger.log(Level.INFO, "Array is empty. The maximum is not counted");

        }

        return maxOptional;
    }

    @Override
    public OptionalInt minStream(AbstractCustomArray customArray) {

        return Arrays.stream(customArray.getData()).min();

    }

    @Override
    public OptionalInt maxStream(AbstractCustomArray customArray) {

        return Arrays.stream(customArray.getData()).max();
    }
}
