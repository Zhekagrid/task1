package com.hrydziushka.task1.creator.impl;

import com.hrydziushka.task1.creator.CustomArrayCreator;
import com.hrydziushka.task1.entity.AbstractCustomArray;
import com.hrydziushka.task1.entity.CustomArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class CustomArrayCreatorImpl implements CustomArrayCreator {

    @Override
    public CustomArray createRandomCustomArray(int maxAbsValue, int maxSize) {
        Random random = new Random();
        int size = random.nextInt(maxSize);
        return new CustomArray(random.ints(size, -maxAbsValue, maxAbsValue).toArray());
    }

    @Override
    public List<? extends AbstractCustomArray> createRandomAllCustomArrays(int maxCountOfArrays, int maxSize, int maxAbsValue) {
        List<AbstractCustomArray> customArrayList = new ArrayList<>();
        Random random = new Random();
        int count = random.nextInt(maxCountOfArrays);
        for (int i = 0; i < count; i++) {
            int maxArraySize = random.nextInt(maxSize) + 1;
            int maxArrayValue = random.nextInt(maxAbsValue) + 1;
            CustomArray customArray = createRandomCustomArray(maxArrayValue, maxArraySize);
            customArrayList.add(customArray);
        }
        return customArrayList;

    }

    @Override
    public CustomArray createCustomArray(List<Integer> dataList) {
        return new CustomArray(dataList);
    }

    @Override
    public List<? extends AbstractCustomArray> createAllCustomArray(List<List<Integer>> datalist) {
        List<CustomArray> customArrayList = new ArrayList<>();
        for (List<Integer> integerList : datalist) {
            CustomArray customArray = createCustomArray(integerList);
            customArrayList.add(customArray);
        }
        return customArrayList;
    }
}
