package com.hrydziushka.task1.comparator;

import com.hrydziushka.task1.entity.AbstractCustomArray;

import java.util.Comparator;

public class SizeComparator implements Comparator<AbstractCustomArray> {
    @Override
    public int compare(AbstractCustomArray o1, AbstractCustomArray o2) {
        int firstSize = o1.getSize();
        int secondSize = o2.getSize();
        return Integer.compare(firstSize, secondSize);
    }
}
