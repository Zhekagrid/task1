package com.hrydziushka.task1.comparator;

import com.hrydziushka.task1.entity.AbstractCustomArray;
import com.hrydziushka.task1.entity.CustomArrayParametrs;
import com.hrydziushka.task1.entity.Warehouse;

import java.util.Comparator;
import java.util.OptionalInt;

public class SumComparator implements Comparator<AbstractCustomArray> {
    @Override
    public int compare(AbstractCustomArray o1, AbstractCustomArray o2) {
        int firstId = o1.getCustomArrayId();
        CustomArrayParametrs firstArrayParamets = Warehouse.getInstance().get(firstId);
        OptionalInt firstSum = firstArrayParamets.getSum();

        int secondId = o2.getCustomArrayId();
        CustomArrayParametrs secondArrayParamets = Warehouse.getInstance().get(secondId);
        OptionalInt secondSum = secondArrayParamets.getSum();

        if (firstSum.isPresent() && secondSum.isPresent()) {
            return Integer.compare(firstSum.getAsInt(), secondSum.getAsInt());
        }
        return Integer.compare(o1.getSize(), o2.getSize());
    }
}
