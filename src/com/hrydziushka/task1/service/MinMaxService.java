package com.hrydziushka.task1.service;

import com.hrydziushka.task1.entity.AbstractCustomArray;
import com.hrydziushka.task1.exception.CustomException;

import java.util.OptionalInt;

public interface MinMaxService {
    OptionalInt min(AbstractCustomArray customArray) throws CustomException;

    OptionalInt max(AbstractCustomArray customArray) throws CustomException;

    OptionalInt minStream(AbstractCustomArray customArray);

    OptionalInt maxStream(AbstractCustomArray customArray);
}
