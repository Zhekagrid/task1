package com.hrydziushka.task1.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Warehouse {
    static Logger logger = LogManager.getLogger();
    private static Warehouse instance;
    private Map<Integer, CustomArrayParametrs> customArrayParametrsMap;

    private Warehouse() {
        customArrayParametrsMap = new HashMap<>();
        logger.log(Level.INFO, "Warehouse was created");
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public void clear() {
        customArrayParametrsMap.clear();
    }

    public CustomArrayParametrs get(Object key) {
        return customArrayParametrsMap.get(key);
    }

    public Map<Integer, CustomArrayParametrs> getCustomArrayParametrsMap() {
        return customArrayParametrsMap;
    }

    public void setCustomArrayParametrsMap(Map<Integer, CustomArrayParametrs> customArrayParametrsMap) {
        this.customArrayParametrsMap = customArrayParametrsMap;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Warehouse{");
        sb.append("customArrayParametrsMap=").append(customArrayParametrsMap);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warehouse warehouse = (Warehouse) o;
        return Objects.equals(customArrayParametrsMap, warehouse.customArrayParametrsMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customArrayParametrsMap);
    }

    public CustomArrayParametrs put(Integer key, CustomArrayParametrs value) {
        logger.log(Level.INFO, "new custom array parametrs was put to warehouse");
        return customArrayParametrsMap.put(key, value);
    }

    public CustomArrayParametrs remove(Object key) {
        return customArrayParametrsMap.remove(key);
    }
}
