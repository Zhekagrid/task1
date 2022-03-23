package com.hrydziushka.task1.service.impl;

import com.hrydziushka.task1.entity.AbstractCustomArray;
import com.hrydziushka.task1.exception.CustomException;
import com.hrydziushka.task1.service.ReplacementService;
import com.hrydziushka.task1.service.condition.Condition;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReplacementServiceImpl implements ReplacementService {
    static Logger logger = LogManager.getLogger();

    @Override
    public void replaceElementsByCondition(AbstractCustomArray customArray, Condition condition) throws CustomException {
        if (customArray == null) {
            logger.log(Level.ERROR, "Array equals null");
            throw new CustomException("Array equals null");
        }

        switch (condition) {
            case NEGATIVE -> {
                for (int i = 0; i < customArray.getSize(); i++) {
                    if (customArray.getElementAt(i) < 0) {
                        customArray.setElementAt(i, 0);
                    }
                }
                logger.log(Level.INFO, "The negative numbers are replaced:");
            }
            case POSITIVE -> {
                for (int i = 0; i < customArray.getSize(); i++) {
                    if (customArray.getElementAt(i) > 0) {
                        customArray.setElementAt(i, 0);
                    }
                }
                logger.log(Level.INFO, "The positive numbers are replaced:");

            }
        }
    }
}
