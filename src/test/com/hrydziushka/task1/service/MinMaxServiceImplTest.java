package test.com.hrydziushka.task1.service;

import com.hrydziushka.task1.creator.CustomArrayCreator;
import com.hrydziushka.task1.creator.impl.CustomArrayCreatorImpl;
import com.hrydziushka.task1.entity.CustomArray;
import com.hrydziushka.task1.exception.CustomException;
import com.hrydziushka.task1.parser.StringToIntegerListParser;
import com.hrydziushka.task1.parser.impl.StringToIntegerListParserImpl;
import com.hrydziushka.task1.reader.ReaderFromFile;
import com.hrydziushka.task1.reader.impl.ReaderFromFileImpl;
import com.hrydziushka.task1.service.MinMaxService;
import com.hrydziushka.task1.service.impl.MinMaxServiceImpl;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class MinMaxServiceImplTest {
    MinMaxService minMaxService;
    CustomArray customArray;

    @BeforeClass
    public void setUp() {
        minMaxService = new MinMaxServiceImpl();
        CustomArrayCreator creator = new CustomArrayCreatorImpl();
        ReaderFromFile reader = new ReaderFromFileImpl();
        StringToIntegerListParser parser = new StringToIntegerListParserImpl();
        List<String> linesFromFile = reader.readLinesFromFile("resources/test.txt");
        List<Integer> dataList = parser.parseLines(linesFromFile).get(0);
        customArray = creator.createCustomArray(dataList);
    }


    @DataProvider(name = "customArraysMin")
    public Object[][] createDataForMin() {
        return new Object[][]{{new CustomArray(1, 2, 3, -5, -50, 100), -50}, {new CustomArray(1, 2, 3, 0), 0}};
    }

    @Test(dataProvider = "customArraysMin")
    public void findMinTest(CustomArray array, Integer expected) throws CustomException {

        Integer actual = minMaxService.min(array).getAsInt();
        assertEquals(actual, expected);
    }

    @DataProvider(name = "customArraysMax")
    public Object[][] createDataForMax() {
        return new Object[][]{{new CustomArray(1, 2, 3, -5, -50, 100), 100}, {new CustomArray(1, 2, 3, 0), 3}};
    }

    @Test(dataProvider = "customArraysMax")
    public void findMaxTest(CustomArray array, Integer expected) throws CustomException {
        Integer actual = minMaxService.max(array).getAsInt();
        assertEquals(actual, expected);
    }

    @Test
    public void findMinStreamTest()  {
        Integer expected = -3;
        Integer actual = minMaxService.minStream(customArray).getAsInt();
        assertEquals(actual, expected);
    }

    @Test
    public void findMaxStreamTest()  {
        Integer expected = 100;
        Integer actual = minMaxService.maxStream(customArray).getAsInt();
        assertEquals(actual, expected);
    }

    @AfterClass
    public void tierDown() {
        minMaxService = null;
        customArray = null;
    }

}
