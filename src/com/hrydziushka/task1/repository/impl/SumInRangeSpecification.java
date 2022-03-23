package com.hrydziushka.task1.repository.impl;

import com.hrydziushka.task1.entity.AbstractCustomArray;
import com.hrydziushka.task1.entity.CustomArrayParametrs;
import com.hrydziushka.task1.entity.Warehouse;
import com.hrydziushka.task1.repository.Specification;

import java.util.OptionalInt;

public class SumInRangeSpecification implements Specification<AbstractCustomArray> {
    private final int minSum;
    private final int maxSum;

    public SumInRangeSpecification(int minSum, int maxSum) {
        this.minSum = minSum;
        this.maxSum = maxSum;
    }

    @Override
    public boolean specify(AbstractCustomArray array) {
        int id = array.getCustomArrayId();
        CustomArrayParametrs arrayParametrs = Warehouse.getInstance().get(id);
        OptionalInt sum = arrayParametrs.getSum();
        if (sum.isPresent()) {
            return (sum.getAsInt() >= minSum && sum.getAsInt() <= maxSum);
        }
        return false;
    }
}
