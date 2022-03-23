package com.hrydziushka.task1.main;

import com.hrydziushka.task1.configurator.Configurator;
import com.hrydziushka.task1.configurator.impl.ConfiguratorImpl;
import com.hrydziushka.task1.entity.CustomArray;
import com.hrydziushka.task1.entity.CustomArrayParametrs;
import com.hrydziushka.task1.entity.Warehouse;
import com.hrydziushka.task1.exception.CustomException;
import com.hrydziushka.task1.observer.impl.CustomArrayObserverImpl;
import com.hrydziushka.task1.repository.Repository;
import com.hrydziushka.task1.repository.impl.RepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Configurator configurator = new ConfiguratorImpl();
        configurator.configureApplication("resources\\input.txt");
        Repository repository = RepositoryImpl.getInstance();
        Warehouse warehouse = Warehouse.getInstance();

        CustomArray customArray = new CustomArray(1, 2);
        repository.add(customArray);
        warehouse.put(customArray.getCustomArrayId(), new CustomArrayParametrs(customArray));
        customArray.attach(new CustomArrayObserverImpl());
        try {
            customArray.setElementAt(1, 55);
        } catch (CustomException e) {
            e.printStackTrace();
        }

        Random random=new Random();
        random.ints(0,-1,1).filter(x->x==1).forEach(System.out::println);
        //System.out.println(c);
    }
}
