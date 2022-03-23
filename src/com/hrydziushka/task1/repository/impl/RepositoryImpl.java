package com.hrydziushka.task1.repository.impl;

import com.hrydziushka.task1.entity.AbstractCustomArray;
import com.hrydziushka.task1.repository.Repository;
import com.hrydziushka.task1.repository.Specification;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class RepositoryImpl implements Repository {
    static Logger logger = LogManager.getLogger();
    private static RepositoryImpl instance;
    private final List<AbstractCustomArray> customArrayList;

    private RepositoryImpl() {

        customArrayList = new ArrayList<>();
        logger.log(Level.INFO,"Repository created");
    }

    public static RepositoryImpl getInstance() {
        if (instance == null) {
            instance = new RepositoryImpl();
        }
        return instance;
    }

    @Override
    public boolean add(AbstractCustomArray customArray) {
        return customArrayList.add(customArray);
    }

    @Override
    public AbstractCustomArray get(int index) throws CloneNotSupportedException {
        return (AbstractCustomArray) customArrayList.get(index).clone();
    }

    @Override
    public List<AbstractCustomArray> query(Specification specification) {
        List<AbstractCustomArray> answerArrayList = new ArrayList<>();
        for (AbstractCustomArray customArray : customArrayList) {
            if (specification.specify(customArray)) {
                answerArrayList.add(customArray);
            }

        }
        return answerArrayList;
    }

    public List<AbstractCustomArray> getCustomArrayList() {
        return customArrayList.stream().toList();
    }

    @Override
    public List<AbstractCustomArray> queryStream(Specification specification) {
        return customArrayList.stream().filter(o -> specification.specify(o)).toList();
    }

    @Override
    public List<AbstractCustomArray> sort(Comparator<AbstractCustomArray> comparator) {
        List<AbstractCustomArray> answerArrayList = new ArrayList<>(customArrayList);
        answerArrayList.sort(comparator);
        return answerArrayList;
    }

    @Override
    public List<AbstractCustomArray> sortStream(Comparator<AbstractCustomArray> comparator) {

        return customArrayList.stream().sorted(comparator).toList();
    }

    @Override
    public boolean remove(Object o) {
        return customArrayList.remove(o);
    }

    @Override
    public boolean addAll(Collection<? extends AbstractCustomArray> c) {
        return customArrayList.addAll(c);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RepositoryImpl{");
        sb.append("customArrayList=").append(customArrayList);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void clear() {
        customArrayList.clear();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return customArrayList.removeAll(c);
    }

}
