package com.hrydziushka.task1.configurator;

import com.hrydziushka.task1.entity.AbstractCustomArray;

import java.util.List;

public interface Configurator {
    void configureApplication(String filePath);

    void configureApplication(AbstractCustomArray... customArrays);

    void configureApplication(List<? extends AbstractCustomArray> customArrayList);

    List<? extends AbstractCustomArray> createArraysFromFile(String filePath);

    void fillRepository(List<? extends AbstractCustomArray> customArrayList);

    void fillWarehouse(List<? extends AbstractCustomArray> customArrayList);

    void attachCustomObserver(List<? extends AbstractCustomArray> customArrayList);
}
