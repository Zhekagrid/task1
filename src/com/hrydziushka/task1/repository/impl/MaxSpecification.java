package com.hrydziushka.task1.repository.impl;

import com.hrydziushka.task1.entity.AbstractCustomArray;
import com.hrydziushka.task1.entity.Warehouse;
import com.hrydziushka.task1.repository.Specification;

import java.util.OptionalInt;

public class MaxSpecification implements Specification<AbstractCustomArray> {
    private final int max;

    public MaxSpecification(int max) {
        this.max = max;
    }

    @Override
    public boolean specify(AbstractCustomArray array) {
        int id = array.getCustomArrayId();
        Warehouse warehouse = Warehouse.getInstance();
        OptionalInt arrayMax = warehouse.get(id).getMax();
        if (arrayMax.isPresent()) {
            return arrayMax.getAsInt() <= max;
        }
        return false;
    }
}
