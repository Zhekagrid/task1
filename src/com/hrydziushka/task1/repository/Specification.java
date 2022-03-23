package com.hrydziushka.task1.repository;

public interface Specification<T> {
    boolean specify(T array);
}
