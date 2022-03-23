package com.hrydziushka.task1.entity;

import com.hrydziushka.task1.service.CalculationService;
import com.hrydziushka.task1.service.MinMaxService;
import com.hrydziushka.task1.service.impl.CalculationServiceImpl;
import com.hrydziushka.task1.service.impl.MinMaxServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class CustomArrayParametrs {
    static Logger logger = LogManager.getLogger();
    private OptionalInt sum;
    private OptionalDouble average;
    private OptionalInt min;
    private OptionalInt max;
    private long countNegativeNumbers;
    private long countPositiveNumbers;

    public CustomArrayParametrs(OptionalInt sum, OptionalDouble average, OptionalInt min, OptionalInt max, int countNegativeNumbers, int countPositiveNumbers) {
        this.sum = sum;
        this.average = average;
        this.min = min;
        this.max = max;
        this.countNegativeNumbers = countNegativeNumbers;
        this.countPositiveNumbers = countPositiveNumbers;
    }

    public CustomArrayParametrs(AbstractCustomArray customArray) {
        MinMaxService minMaxService = new MinMaxServiceImpl();
        CalculationService calculationService = new CalculationServiceImpl();
        this.sum = calculationService.findSumStream(customArray);
        this.average = calculationService.findAverageStream(customArray);
        this.min = minMaxService.minStream(customArray);
        this.max = minMaxService.maxStream(customArray);
        this.countNegativeNumbers = calculationService.countOfNegativeNumbersStream(customArray);
        this.countPositiveNumbers = calculationService.countOfPositiveNumbersStream(customArray);

        logger.log(Level.INFO, "Custom array parametrs was created");
    }

    public OptionalInt getSum() {
        return sum;
    }

    public void setSum(OptionalInt sum) {
        this.sum = sum;
    }

    public OptionalDouble getAverage() {
        return average;
    }

    public void setAverage(OptionalDouble average) {
        this.average = average;
    }

    public OptionalInt getMin() {
        return min;
    }

    public void setMin(OptionalInt min) {
        this.min = min;
    }

    public OptionalInt getMax() {
        return max;
    }

    public void setMax(OptionalInt max) {
        this.max = max;
    }

    public long getCountNegativeNumbers() {
        return countNegativeNumbers;
    }

    public void setCountNegativeNumbers(long countNegativeNumbers) {
        this.countNegativeNumbers = countNegativeNumbers;
    }

    public long getCountPositiveNumbers() {
        return countPositiveNumbers;
    }

    public void setCountPositiveNumbers(long countPositiveNumbers) {
        this.countPositiveNumbers = countPositiveNumbers;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CustomArrayParametrs{");
        sb.append("sum=").append(sum);
        sb.append(", average=").append(average);
        sb.append(", min=").append(min);
        sb.append(", max=").append(max);
        sb.append(", countNegativeNumbers=").append(countNegativeNumbers);
        sb.append(", countPositiveNumbers=").append(countPositiveNumbers);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArrayParametrs that = (CustomArrayParametrs) o;
        return countNegativeNumbers == that.countNegativeNumbers && countPositiveNumbers == that.countPositiveNumbers && sum.equals(that.sum) && average.equals(that.average) && min.equals(that.min) && max.equals(that.max);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sum, average, min, max, countNegativeNumbers, countPositiveNumbers);
    }
}
