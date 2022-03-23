package com.hrydziushka.task1.configurator.impl;

import com.hrydziushka.task1.configurator.Configurator;
import com.hrydziushka.task1.creator.CustomArrayCreator;
import com.hrydziushka.task1.creator.impl.CustomArrayCreatorImpl;
import com.hrydziushka.task1.entity.AbstractCustomArray;
import com.hrydziushka.task1.entity.CustomArrayParametrs;
import com.hrydziushka.task1.entity.Warehouse;
import com.hrydziushka.task1.observer.impl.CustomArrayObserverImpl;
import com.hrydziushka.task1.parser.StringToIntegerListParser;
import com.hrydziushka.task1.parser.impl.StringToIntegerListParserImpl;
import com.hrydziushka.task1.reader.ReaderFromFile;
import com.hrydziushka.task1.reader.impl.ReaderFromFileImpl;
import com.hrydziushka.task1.repository.impl.RepositoryImpl;

import java.util.Arrays;
import java.util.List;

public class ConfiguratorImpl implements Configurator {

    @Override
    public void configureApplication(List<? extends AbstractCustomArray> customArrayList) {
        fillRepository(customArrayList);
        fillWarehouse(customArrayList);
        attachCustomObserver(customArrayList);
    }

    @Override
    public void configureApplication(String filePath) {

        List<? extends AbstractCustomArray> arrayList = createArraysFromFile(filePath);
        fillRepository(arrayList);
        fillWarehouse(arrayList);
        attachCustomObserver(arrayList);

    }

    @Override
    public void configureApplication(AbstractCustomArray... customArrays) {

        List<? extends AbstractCustomArray> arrayList = Arrays.stream(customArrays).toList();
        fillRepository(arrayList);
        fillWarehouse(arrayList);
        attachCustomObserver(arrayList);

    }

    @Override
    public List<? extends AbstractCustomArray> createArraysFromFile(String filePath) {
        ReaderFromFile reader = new ReaderFromFileImpl();
        StringToIntegerListParser parser = new StringToIntegerListParserImpl();
        CustomArrayCreator creator = new CustomArrayCreatorImpl();
        List<List<Integer>> dataList = parser.parseLines(reader.readLinesFromFile(filePath));
        List<? extends AbstractCustomArray> arrayList = creator.createAllCustomArray(dataList);
        return arrayList;
    }

    @Override
    public void fillRepository(List<? extends AbstractCustomArray> customArrayList) {
        RepositoryImpl.getInstance().addAll(customArrayList);
    }

    @Override
    public void fillWarehouse(List<? extends AbstractCustomArray> customArrayList) {
        Warehouse warehouse = Warehouse.getInstance();
        for (AbstractCustomArray customArray : customArrayList) {
            warehouse.put(customArray.getCustomArrayId(), new CustomArrayParametrs(customArray));
        }
    }

    @Override
    public void attachCustomObserver(List<? extends AbstractCustomArray> customArrayList) {

        for (AbstractCustomArray customArray : customArrayList) {
            customArray.attach(new CustomArrayObserverImpl());
        }
    }
}
