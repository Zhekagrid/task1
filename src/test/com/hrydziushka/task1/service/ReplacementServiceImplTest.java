package test.com.hrydziushka.task1.service;

import com.hrydziushka.task1.service.condition.Condition;
import com.hrydziushka.task1.creator.CustomArrayCreator;
import com.hrydziushka.task1.creator.impl.CustomArrayCreatorImpl;
import com.hrydziushka.task1.entity.CustomArray;
import com.hrydziushka.task1.exception.CustomException;
import com.hrydziushka.task1.parser.StringToIntegerListParser;
import com.hrydziushka.task1.parser.impl.StringToIntegerListParserImpl;
import com.hrydziushka.task1.reader.ReaderFromFile;
import com.hrydziushka.task1.reader.impl.ReaderFromFileImpl;
import com.hrydziushka.task1.service.ReplacementService;
import com.hrydziushka.task1.service.impl.ReplacementServiceImpl;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ReplacementServiceImplTest {
    CustomArray customArray;
    ReplacementService replacementService;

    @BeforeClass
    public void setUp() {
        replacementService = new ReplacementServiceImpl();
        CustomArrayCreator creator = new CustomArrayCreatorImpl();
        ReaderFromFile reader = new ReaderFromFileImpl();
        StringToIntegerListParser parser = new StringToIntegerListParserImpl();
        List<String> linesFromFile = reader.readLinesFromFile("resources/test.txt");
        List<Integer> dataList = parser.parseLines(linesFromFile).get(0);
        customArray = creator.createCustomArray(dataList);
    }

    @Test
    public void replaceNegativeNumbersTest() throws CustomException {

        CustomArray expected = new CustomArray(1, 0, 3, 0, 100,0,0);
        CustomArray actual = new CustomArray(customArray.getData());
        replacementService.replaceElementsByCondition(actual, Condition.NEGATIVE);
        assertEquals(actual, expected);

    }

    @Test
    public void replacePositiveNumbersTest() throws CustomException {
        CustomArray expected = new CustomArray(0, -2, 0, -3, 0,0,0);
        CustomArray actual = new CustomArray(customArray.getData());
        replacementService.replaceElementsByCondition(actual, Condition.POSITIVE);
        assertEquals(actual, expected);

    }

    @AfterClass
    public void tierDown() {
        replacementService = null;
        customArray = null;
    }
}
