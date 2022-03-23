package com.hrydziushka.task1.service;

import com.hrydziushka.task1.entity.AbstractCustomArray;
import com.hrydziushka.task1.exception.CustomException;
import com.hrydziushka.task1.service.condition.Condition;

public interface ReplacementService {
    void replaceElementsByCondition(AbstractCustomArray customArray, Condition condition) throws CustomException;
}
