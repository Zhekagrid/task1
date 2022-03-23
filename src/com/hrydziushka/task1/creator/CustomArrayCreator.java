package com.hrydziushka.task1.creator;

import com.hrydziushka.task1.entity.AbstractCustomArray;
import com.hrydziushka.task1.entity.CustomArray;

import java.util.List;

public interface CustomArrayCreator {
    CustomArray createCustomArray(List<Integer> dataList);

    CustomArray createRandomCustomArray(int maxAbsValue, int maxSize);

    List<? extends AbstractCustomArray> createRandomAllCustomArrays(int maxCountOfArrays, int maxSize, int maxAbsValue);

    List<? extends AbstractCustomArray> createAllCustomArray(List<List<Integer>> datalist);
}
