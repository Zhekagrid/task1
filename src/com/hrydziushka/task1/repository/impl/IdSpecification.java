package com.hrydziushka.task1.repository.impl;

import com.hrydziushka.task1.entity.AbstractCustomArray;
import com.hrydziushka.task1.repository.Specification;

public class IdSpecification implements Specification<AbstractCustomArray> {
    private final int id;

    public IdSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean specify(AbstractCustomArray array) {
        return array.getCustomArrayId() == id;
    }
}
