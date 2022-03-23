package test.com.hrydziushka.task1.reader;

import com.hrydziushka.task1.reader.ReaderFromFile;
import com.hrydziushka.task1.reader.impl.ReaderFromFileImpl;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ReaderFromFileImplTest {
    private static final String TEST_FILE_PATH = "resources\\test.txt";
    @Test
    public void readFileTest() {
        ReaderFromFile reader = new ReaderFromFileImpl();
        List<String> actual = reader.readLinesFromFile(TEST_FILE_PATH);
        List<String> expected = new ArrayList<>();
        expected.add("1;-2;3;-3;+100;0;0;");
        expected.add("1;3k;2");
        expected.add("1;-2;3;-3;+1;0;");
        expected.add("1l2.");
        expected.add("1;2;3;4;5;");
        expected.add("1;");
        expected.add("1;+3;");
        expected.add("1");
        assertEquals(actual, expected);
    }

}
