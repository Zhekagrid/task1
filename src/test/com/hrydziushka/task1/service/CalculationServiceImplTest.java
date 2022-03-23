package test.com.hrydziushka.task1.service;


import com.hrydziushka.task1.creator.CustomArrayCreator;
import com.hrydziushka.task1.creator.impl.CustomArrayCreatorImpl;
import com.hrydziushka.task1.entity.CustomArray;
import com.hrydziushka.task1.exception.CustomException;
import com.hrydziushka.task1.parser.StringToIntegerListParser;
import com.hrydziushka.task1.parser.impl.StringToIntegerListParserImpl;
import com.hrydziushka.task1.reader.ReaderFromFile;
import com.hrydziushka.task1.reader.impl.ReaderFromFileImpl;
import com.hrydziushka.task1.service.CalculationService;
import com.hrydziushka.task1.service.impl.CalculationServiceImpl;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.OptionalDouble;

import static org.testng.Assert.assertEquals;

public class CalculationServiceImplTest {
    CalculationService calculationService;
    CustomArray customArray;

    private static final String FILE_PATH = "resources\\test.txt";
    @BeforeClass
    public void setUp() {
        calculationService = new CalculationServiceImpl();
        CustomArrayCreator creator = new CustomArrayCreatorImpl();
        ReaderFromFile reader = new ReaderFromFileImpl();
        StringToIntegerListParser parser = new StringToIntegerListParserImpl();
        List<String> linesFromFile = reader.readLinesFromFile(FILE_PATH);
        List<Integer> dataList = parser.parseLines(linesFromFile).get(0);
        customArray = creator.createCustomArray(dataList);
    }




    @Test
    public void calculateNegativeNumberTest() throws CustomException {
        Integer expected = 2;
        Integer actual = calculationService.countOfNegativeNumbers(customArray);
        assertEquals(actual, expected);
    }

    @Test
    public void calculatePositiveNumberTest() throws CustomException {
        Integer expected = 3;
        Integer actual = calculationService.countOfPositiveNumbers(customArray);
        assertEquals(actual, expected);
    }

    @Test
    public void calculateNegativeNumberStreamTest() {
        long expected = 2;
        long actual = calculationService.countOfNegativeNumbersStream(customArray);
        assertEquals(actual, expected);
    }

    @Test
    public void calculatePositiveNumberStreamTest()  {
        long expected = 3;
        long actual = calculationService.countOfPositiveNumbersStream(customArray);
        assertEquals(actual, expected);
    }

    @Test
    public void findSumTest() throws CustomException {
        Integer expected = 99;
        Integer actual = calculationService.findSum(customArray).getAsInt();
        assertEquals(actual, expected);
    }


    @Test
    public void findSumStreamTest()  {
        Integer expected = 99;
        Integer actual = calculationService.findSumStream(customArray).getAsInt();
        assertEquals(actual, expected);
    }

    @Test
    public void findAverageTest() throws CustomException {
        double expected = 14.142857;
        double actual = calculationService.findAverage(customArray).getAsDouble();
        assertEquals(actual, expected, 0.00001);
    }

    @Test
    public void findAverageStreamTest() {
        double expected =14.142857;
        OptionalDouble actual = calculationService.findAverageStream(customArray);
        assertEquals(actual.getAsDouble(), expected, 0.00001);
    }

    @AfterClass
    public void tierDown() {
        calculationService = null;
        customArray = null;
    }
}