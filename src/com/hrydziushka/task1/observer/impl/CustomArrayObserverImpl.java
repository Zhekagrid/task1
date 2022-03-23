package com.hrydziushka.task1.observer.impl;

import com.hrydziushka.task1.entity.AbstractCustomArray;
import com.hrydziushka.task1.entity.CustomArrayParametrs;
import com.hrydziushka.task1.entity.Warehouse;
import com.hrydziushka.task1.observer.CustomArrayEvent;
import com.hrydziushka.task1.observer.CustomArrayObserver;
import com.hrydziushka.task1.service.CalculationService;
import com.hrydziushka.task1.service.MinMaxService;
import com.hrydziushka.task1.service.impl.CalculationServiceImpl;
import com.hrydziushka.task1.service.impl.MinMaxServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class CustomArrayObserverImpl implements CustomArrayObserver {
    static Logger logger = LogManager.getLogger();

    @Override
    public void arrayChanged(CustomArrayEvent event) {
        AbstractCustomArray customArray = event.getSource();
        int id = customArray.getCustomArrayId();
        CustomArrayParametrs arrayParametrs = Warehouse.getInstance().get(id);
        updateCalculatedParametrs(customArray, arrayParametrs);
        updateMinMax(customArray, arrayParametrs);
        logger.log(Level.INFO, "Observer has updateda array parametrs");
    }

    private void updateMinMax(AbstractCustomArray customArray, CustomArrayParametrs arrayParametrs) {
        MinMaxService minMaxService = new MinMaxServiceImpl();
        OptionalInt max = minMaxService.maxStream(customArray);
        OptionalInt min = minMaxService.minStream(customArray);

        arrayParametrs.setMax(max);
        arrayParametrs.setMin(min);


    }


    private void updateCalculatedParametrs(AbstractCustomArray customArray, CustomArrayParametrs arrayParametrs) {

        CalculationService calculationService = new CalculationServiceImpl();
        OptionalInt sum = calculationService.findSumStream(customArray);
        OptionalDouble average = calculationService.findAverageStream(customArray);
        long countPositiveNumbers = calculationService.countOfPositiveNumbersStream(customArray);
        long countNegativeNumbers = calculationService.countOfNegativeNumbersStream(customArray);

        arrayParametrs.setAverage(average);
        arrayParametrs.setSum(sum);
        arrayParametrs.setCountNegativeNumbers(countNegativeNumbers);
        arrayParametrs.setCountPositiveNumbers(countPositiveNumbers);
    }


}
