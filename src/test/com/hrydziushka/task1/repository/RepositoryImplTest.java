package test.com.hrydziushka.task1.repository;

import com.hrydziushka.task1.comparator.IdComparator;
import com.hrydziushka.task1.comparator.SizeComparator;
import com.hrydziushka.task1.comparator.SumComparator;
import com.hrydziushka.task1.configurator.Configurator;
import com.hrydziushka.task1.configurator.impl.ConfiguratorImpl;
import com.hrydziushka.task1.entity.AbstractCustomArray;
import com.hrydziushka.task1.entity.CustomArray;
import com.hrydziushka.task1.entity.Warehouse;
import com.hrydziushka.task1.repository.Repository;
import com.hrydziushka.task1.repository.impl.MaxSpecification;
import com.hrydziushka.task1.repository.impl.RepositoryImpl;
import com.hrydziushka.task1.repository.impl.SumInRangeSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class RepositoryImplTest {
    private static final int MAX_FOR_SPECIFICATION = 3;
    private static final int MAX_SUM_FOR_SPECIFICATION = 5;
    private static final int MIN_SUM_FOR_SPECIFICATION = 2;
    private static final String TEST_FILE_PATH = "resources\\test.txt";
    private Repository repository;

    @BeforeClass
    public void setUp() {
        Configurator configurator = new ConfiguratorImpl();
        repository = RepositoryImpl.getInstance();
        configurator.configureApplication(TEST_FILE_PATH);
    }

    @AfterClass
    public void tierDown() {

        repository.clear();
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.clear();

    }

    @Test
    public void sortIdComparatorTest() {
        List<AbstractCustomArray> actualCustomArrayList = repository.sort(new IdComparator());
        List<AbstractCustomArray> expectedCustomArrayList = new ArrayList<>();
        expectedCustomArrayList.add(new CustomArray(1, -2, 3, -3, 100, 0, 0));
        expectedCustomArrayList.add(new CustomArray(1, -2, 3, -3, +1, 0));

        expectedCustomArrayList.add(new CustomArray(1, 2, 3, 4, 5));
        expectedCustomArrayList.add(new CustomArray(1));
        expectedCustomArrayList.add(new CustomArray(1, 3));
        assertEquals(actualCustomArrayList, expectedCustomArrayList);
    }

    @Test
    public void sortStreamIdComparatorTest() {
        List<AbstractCustomArray> actualCustomArrayList = repository.sortStream(new IdComparator());
        List<AbstractCustomArray> expectedCustomArrayList = new ArrayList<>();
        expectedCustomArrayList.add(new CustomArray(1, -2, 3, -3, 100, 0, 0));
        expectedCustomArrayList.add(new CustomArray(1, -2, 3, -3, +1, 0));

        expectedCustomArrayList.add(new CustomArray(1, 2, 3, 4, 5));
        expectedCustomArrayList.add(new CustomArray(1));
        expectedCustomArrayList.add(new CustomArray(1, 3));
        assertEquals(actualCustomArrayList, expectedCustomArrayList);
    }

    @Test
    public void sortSumComparatorTest() {
        List<AbstractCustomArray> actualCustomArrayList = repository.sort(new SumComparator());
        List<AbstractCustomArray> expectedCustomArrayList = new ArrayList<>();
        expectedCustomArrayList.add(new CustomArray(1, -2, 3, -3, +1, 0));
        expectedCustomArrayList.add(new CustomArray(1));
        expectedCustomArrayList.add(new CustomArray(1, 3));
        expectedCustomArrayList.add(new CustomArray(1, 2, 3, 4, 5));
        expectedCustomArrayList.add(new CustomArray(1, -2, 3, -3, 100, 0, 0));
        assertEquals(actualCustomArrayList, expectedCustomArrayList);

    }

    @Test
    public void sortStreamSumComparatorTest() {
        List<AbstractCustomArray> actualCustomArrayList = repository.sortStream(new SumComparator());
        List<AbstractCustomArray> expectedCustomArrayList = new ArrayList<>();
        expectedCustomArrayList.add(new CustomArray(1, -2, 3, -3, +1, 0));
        expectedCustomArrayList.add(new CustomArray(1));
        expectedCustomArrayList.add(new CustomArray(1, 3));
        expectedCustomArrayList.add(new CustomArray(1, 2, 3, 4, 5));
        expectedCustomArrayList.add(new CustomArray(1, -2, 3, -3, 100, 0, 0));
        assertEquals(actualCustomArrayList, expectedCustomArrayList);
    }

    @Test
    public void sortSizeComparatorTest() {
        List<AbstractCustomArray> actualCustomArrayList = repository.sort(new SizeComparator());
        List<AbstractCustomArray> expectedCustomArrayList = new ArrayList<>();

        expectedCustomArrayList.add(new CustomArray(1));
        expectedCustomArrayList.add(new CustomArray(1, 3));
        expectedCustomArrayList.add(new CustomArray(1, 2, 3, 4, 5));

        expectedCustomArrayList.add(new CustomArray(1, -2, 3, -3, +1, 0));
        expectedCustomArrayList.add(new CustomArray(1, -2, 3, -3, 100, 0, 0));
        assertEquals(actualCustomArrayList, expectedCustomArrayList);

    }

    @Test
    public void sortStreamSizeComparatorTest() {
        List<AbstractCustomArray> actualCustomArrayList = repository.sortStream(new SizeComparator());
        List<AbstractCustomArray> expectedCustomArrayList = new ArrayList<>();

        expectedCustomArrayList.add(new CustomArray(1));
        expectedCustomArrayList.add(new CustomArray(1, 3));
        expectedCustomArrayList.add(new CustomArray(1, 2, 3, 4, 5));
        expectedCustomArrayList.add(new CustomArray(1, -2, 3, -3, +1, 0));
        expectedCustomArrayList.add(new CustomArray(1, -2, 3, -3, 100, 0, 0));
        assertEquals(actualCustomArrayList, expectedCustomArrayList);
    }

    @Test
    public void queryMaxSpecificationTest() {
        List<AbstractCustomArray> actualCustomArrayList = repository.query(new MaxSpecification(MAX_FOR_SPECIFICATION));
        List<AbstractCustomArray> expectedCustomArrayList = new ArrayList<>();
        expectedCustomArrayList.add(new CustomArray(1, -2, 3, -3, +1, 0));
        expectedCustomArrayList.add(new CustomArray(1));
        expectedCustomArrayList.add(new CustomArray(1, 3));

        assertEquals(actualCustomArrayList, expectedCustomArrayList);
    }


    @Test
    public void querySumInRangeSpecificationTest() {
        List<AbstractCustomArray> actualCustomArrayList = repository.query(new SumInRangeSpecification(MIN_SUM_FOR_SPECIFICATION, MAX_SUM_FOR_SPECIFICATION));
        List<AbstractCustomArray> expectedCustomArrayList = new ArrayList<>();
        expectedCustomArrayList.add(new CustomArray(1, 3));
        assertEquals(actualCustomArrayList, expectedCustomArrayList);
    }

    @Test
    public void queryStreamMaxSpecificationTest() {
        List<AbstractCustomArray> actualCustomArrayList = repository.queryStream(new MaxSpecification(MAX_FOR_SPECIFICATION));
        List<AbstractCustomArray> expectedCustomArrayList = new ArrayList<>();
        expectedCustomArrayList.add(new CustomArray(1, -2, 3, -3, +1, 0));
        expectedCustomArrayList.add(new CustomArray(1));
        expectedCustomArrayList.add(new CustomArray(1, 3));

        assertEquals(actualCustomArrayList, expectedCustomArrayList);
    }


    @Test
    public void queryStreamSumInRangeSpecificationTest()  {
        List<AbstractCustomArray> actualCustomArrayList = repository.queryStream(new SumInRangeSpecification(MIN_SUM_FOR_SPECIFICATION, MAX_SUM_FOR_SPECIFICATION));
        List<AbstractCustomArray> expectedCustomArrayList = new ArrayList<>();
        expectedCustomArrayList.add(new CustomArray(1, 3));
        assertEquals(actualCustomArrayList, expectedCustomArrayList);
    }
}
