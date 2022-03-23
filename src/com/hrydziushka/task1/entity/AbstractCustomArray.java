package com.hrydziushka.task1.entity;

import com.hrydziushka.task1.exception.CustomException;
import com.hrydziushka.task1.observer.CustomArrayEvent;
import com.hrydziushka.task1.observer.CustomArrayObservable;
import com.hrydziushka.task1.observer.CustomArrayObserver;
import com.hrydziushka.task1.util.IdGenerator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractCustomArray implements CustomArrayObservable, Cloneable {
    static Logger logger = LogManager.getLogger();
    private int customArrayId;
    private List<CustomArrayObserver> observerList = new ArrayList<>();


    public AbstractCustomArray() {
        this.customArrayId = IdGenerator.generateCustomArrayId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractCustomArray that = (AbstractCustomArray) o;
        return Objects.equals(observerList, that.observerList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(observerList);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getCustomArrayId() {

        return customArrayId;
    }

    public abstract int getSize();

    public abstract int getElementAt(int index) throws CustomException;

    public abstract void setElementAt(int index, int element) throws CustomException;

    public abstract int[] getData();

    public abstract void setData(int[] data);

    @Override
    public void attach(CustomArrayObserver observer) {
        if (observer != null) {
            observerList.add(observer);
            logger.log(Level.INFO, "Added new observer");
        }
    }

    @Override
    public void detach(CustomArrayObserver observer) {
        observerList.remove(observer);
        logger.log(Level.INFO, "Remove observer");
    }

    @Override
    public void notifyObservers() throws CustomException {
        CustomArrayEvent event = new CustomArrayEvent(this);
        for (CustomArrayObserver observer : observerList) {
            observer.arrayChanged(event);
        }
        logger.log(Level.INFO, "Observers are notifed");
    }
}
