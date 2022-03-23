package test.com.hrydziushka.task1.service;

import com.hrydziushka.task1.entity.CustomArray;
import com.hrydziushka.task1.exception.CustomException;
import com.hrydziushka.task1.service.SortService;
import com.hrydziushka.task1.service.impl.SortServiceImpl;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SortServiceImplTest {
    SortService sortService;

    @BeforeClass
    public void setUp() {
        sortService = new SortServiceImpl();
    }


    @Test
    public void bubbleSortTest() throws CustomException {
        CustomArray actual = new CustomArray(5, 3, 4, 1, -5, 6, -7, 100);
        CustomArray expected = new CustomArray(-7, -5, 1, 3, 4, 5, 6, 100);
        sortService.bubbleSort(actual);
        assertEquals(actual, expected);
    }

    @Test
    public void shakerSortTest() throws CustomException {
        CustomArray actual = new CustomArray(5, 4, 7, 8);
        CustomArray expected = new CustomArray(4, 5, 7, 8);
        sortService.shakerSort(actual);
        assertEquals(actual, expected);
    }

    @Test
    public void selectionSortTest() throws CustomException {
        CustomArray actual = new CustomArray(1, 2, 3, 4, 0);
        CustomArray expected = new CustomArray(0, 1, 2, 3, 4);
        sortService.selectionSort(actual);
        assertEquals(actual, expected);
    }

    @Test
    public void streamSortTest() throws CustomException {
        CustomArray actual = new CustomArray(-5, 1, 3, 2, 4, 0);
        CustomArray expected = new CustomArray(-5, 0, 1, 2, 3, 4);
        sortService.streamSort(actual);
        assertEquals(actual, expected);
    }

    @AfterClass
    public void tierDown() {
        sortService = null;

    }
}
