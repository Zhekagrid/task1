package com.hrydziushka.task1.service.impl;

import com.hrydziushka.task1.entity.AbstractCustomArray;
import com.hrydziushka.task1.exception.CustomException;
import com.hrydziushka.task1.service.SortService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class SortServiceImpl implements SortService {
    static Logger logger = LogManager.getLogger();

    @Override
    public void bubbleSort(AbstractCustomArray customArray) throws CustomException {
        if (customArray == null) {
            logger.log(Level.ERROR, "Array equals null");
            throw new CustomException("Array equals null");
        }

        for (int i = 0; i + 1 < customArray.getSize(); ++i) {
            for (int j = 0; j + 1 < customArray.getSize() - i; ++j) {
                if (customArray.getElementAt(j + 1) < customArray.getElementAt(j)) {
                    int tmp = customArray.getElementAt(j);
                    customArray.setElementAt(j, customArray.getElementAt(j + 1));
                    customArray.setElementAt(j + 1, tmp);

                }
            }
        }
        logger.log(Level.INFO, "The custom array is sorted:");

    }


    @Override
    public void shakerSort(AbstractCustomArray customArray) throws CustomException {
        if (customArray == null) {
            logger.log(Level.ERROR, "Array equals null");
            throw new CustomException("Array equals null");
        }

        int left = 0;
        int right = customArray.getSize() - 1;
        while (left <= right) {
            for (int i = right; i > left; --i) {
                if (customArray.getElementAt(i - 1) > customArray.getElementAt(i)) {

                    int tmp = customArray.getElementAt(i);
                    customArray.setElementAt(i, customArray.getElementAt(i - 1));
                    customArray.setElementAt(i - 1, tmp);

                }
            }
            ++left;
            for (int i = left; i < right; ++i) {
                if (customArray.getElementAt(i) > customArray.getElementAt(i + 1)) {
                    int tmp = customArray.getElementAt(i);
                    customArray.setElementAt(i, customArray.getElementAt(i + 1));
                    customArray.setElementAt(i + 1, tmp);
                }
            }
            --right;
        }
        logger.log(Level.INFO, "The custom array is sorted:");

    }

    @Override
    public void selectionSort(AbstractCustomArray customArray) throws CustomException {
        if (customArray == null) {
            logger.log(Level.ERROR, "Array equals null");
            throw new CustomException("Array equals null");
        }

        for (int i = 0; i < customArray.getSize(); i++) {
            int pos = i;
            int min = customArray.getElementAt(i);

            for (int j = i + 1; j < customArray.getSize(); j++) {
                if (customArray.getElementAt(j) < min) {
                    pos = j;
                    min = customArray.getElementAt(j);
                }
            }
            customArray.setElementAt(pos, customArray.getElementAt(i));
            customArray.setElementAt(i, min);
        }
        logger.log(Level.INFO, "The custom array is sorted:");

    }

    @Override
    public void streamSort(AbstractCustomArray customArray) throws CustomException {
        if (customArray == null) {
            logger.log(Level.ERROR, "Array equals null");
            throw new CustomException("Array equals null");
        }

        customArray.setData(Arrays.stream(customArray.getData()).sorted().toArray());
        logger.log(Level.INFO, "The custom array is sorted:");

    }


}
