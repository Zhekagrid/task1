package com.hrydziushka.task1.comparator;

import com.hrydziushka.task1.entity.AbstractCustomArray;

import java.util.Comparator;

public class IdComparator implements Comparator<AbstractCustomArray> {
    @Override
    public int compare(AbstractCustomArray o1, AbstractCustomArray o2) {
        int firstId = o1.getCustomArrayId();
        int secondId = o2.getCustomArrayId();
        return Integer.compare(firstId, secondId);
    }
}
