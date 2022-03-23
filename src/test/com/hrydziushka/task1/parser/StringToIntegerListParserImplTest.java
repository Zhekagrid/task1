package test.com.hrydziushka.task1.parser;

import com.hrydziushka.task1.parser.StringToIntegerListParser;
import com.hrydziushka.task1.parser.impl.StringToIntegerListParserImpl;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class StringToIntegerListParserImplTest {
    @Test
    public void parseTest() {

        List<String> data = new ArrayList<>();
        data.add("1;-2;+3;");

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(-2);
        expected.add(3);

        StringToIntegerListParser parser = new StringToIntegerListParserImpl();
        List<Integer> actual = new ArrayList<>(parser.parseLines(data)).get(0);
        assertEquals(actual, expected);
    }

    @Test
    public void parseCorrectAndUncorrectLinesTest() {
        List<String> data = new ArrayList<>();

        data.add("1;-2;+3;");
        data.add("0;-5;+100;");
        data.add("1;-7;+9");
        data.add("1;-2k+3;");
        data.add("+5;-2;+3;");


        StringToIntegerListParser parser = new StringToIntegerListParserImpl();
        List<List<Integer>> actual = new ArrayList(parser.parseLines(data));
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> firstCorrectLine = new ArrayList<>();
        firstCorrectLine.add(1);
        firstCorrectLine.add(-2);
        firstCorrectLine.add(3);
        List<Integer> secondCorrectLine = new ArrayList<>();
        secondCorrectLine.add(0);
        secondCorrectLine.add(-5);
        secondCorrectLine.add(100);
        List<Integer> thirdCorrectLine = new ArrayList<>();
        thirdCorrectLine.add(5);
        thirdCorrectLine.add(-2);
        thirdCorrectLine.add(3);

        expected.add(firstCorrectLine);
        expected.add(secondCorrectLine);
        expected.add(thirdCorrectLine);
        assertEquals(actual, expected);
    }
}
