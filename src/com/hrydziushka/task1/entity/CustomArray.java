package com.hrydziushka.task1.entity;

import com.hrydziushka.task1.exception.CustomException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class CustomArray extends AbstractCustomArray implements Cloneable {
    static Logger logger = LogManager.getLogger();
    private int[] data;

    public CustomArray() {
        this.data = new int[0];
        logger.log(Level.INFO, "Custom array was created");
    }

    public CustomArray(List<Integer> elements) {
        this.data = elements.stream().mapToInt(i -> i).toArray();
        logger.log(Level.INFO, "Custom array was created");
    }

    public CustomArray(int... elements) {
        this.data = elements;
        logger.log(Level.INFO, "Custom array was created");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int[] getData() {
        return data.clone();
    }

    @Override
    public void setData(int[] data) {
        this.data = data;
    }

    @Override
    public int getSize() {
        return data.length;
    }

    @Override
    public int getElementAt(int index) throws CustomException {
        if (index >= this.getSize() && index < 0) {
            logger.log(Level.ERROR, "Index out of bounds. Index: " + index);
            throw new CustomException("Index out of bounds. Index: " + index);

        }
        return data[index];
    }

    @Override
    public void setElementAt(int index, int element) throws CustomException {
        if (index >= this.getSize() && index < 0) {
            logger.log(Level.ERROR, "Index out of bounds. Index: " + index);
            throw new CustomException("Index out of bounds. Index: " + index);
        }
        data[index] = element;
        logger.log(Level.INFO, "The element at the " + index + " has been changed to " + element);
        notifyObservers();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArray that = (CustomArray) o;
        return Arrays.equals(data, that.data);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CustomArray{");
        sb.append("data=");
        if (data == null) sb.append("null");
        else {
            sb.append('[');
            for (int i = 0; i < data.length; ++i)
                sb.append(i == 0 ? "" : ", ").append(data[i]);
            sb.append(']');
        }
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }


}
