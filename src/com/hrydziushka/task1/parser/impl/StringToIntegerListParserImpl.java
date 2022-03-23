package com.hrydziushka.task1.parser.impl;

import com.hrydziushka.task1.parser.StringToIntegerListParser;
import com.hrydziushka.task1.validator.ArrayStringValidator;
import com.hrydziushka.task1.validator.impl.ArrayStringValidatorImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class StringToIntegerListParserImpl implements StringToIntegerListParser {
    private static final String SEPARATOR = ";";
    static Logger logger = LogManager.getLogger();

    @Override
    public List<List<Integer>> parseLines(List<String> stringList) {
        List<List<Integer>> listOfIntegerLists = new ArrayList<>();
        ArrayStringValidator validator = new ArrayStringValidatorImpl();
        for (String line : stringList) {
            if (validator.isValidate(line)) {
                List<Integer> integerList = new ArrayList<>();
                for (String numbers : line.split(SEPARATOR)) {
                    integerList.add(Integer.parseInt(numbers));
                }
                listOfIntegerLists.add(integerList);
            } else {
                logger.log(Level.ERROR, "Invalid string, it will be skipped");
            }
        }

        return listOfIntegerLists;
    }
}
