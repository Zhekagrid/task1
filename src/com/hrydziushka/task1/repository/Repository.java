package com.hrydziushka.task1.repository;

import com.hrydziushka.task1.entity.AbstractCustomArray;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public interface Repository {


    boolean add(AbstractCustomArray customArray);

    void clear();

    boolean remove(Object o);

    boolean addAll(Collection<? extends AbstractCustomArray> c);

    boolean removeAll(Collection<?> c);

    AbstractCustomArray get(int index) throws CloneNotSupportedException;

    List<AbstractCustomArray> getCustomArrayList();

    List<AbstractCustomArray> query(Specification specification);

    List<AbstractCustomArray> queryStream(Specification specification);

    List<AbstractCustomArray> sort(Comparator<AbstractCustomArray> comparator);

    List<AbstractCustomArray> sortStream(Comparator<AbstractCustomArray> comparator);
}
