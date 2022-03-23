package test.com.hrydziushka.task1.observer;

import com.hrydziushka.task1.configurator.Configurator;
import com.hrydziushka.task1.configurator.impl.ConfiguratorImpl;
import com.hrydziushka.task1.entity.CustomArray;
import com.hrydziushka.task1.entity.CustomArrayParametrs;
import com.hrydziushka.task1.entity.Warehouse;
import com.hrydziushka.task1.exception.CustomException;
import com.hrydziushka.task1.repository.Repository;
import com.hrydziushka.task1.repository.impl.RepositoryImpl;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ObserverTest {
    CustomArray customArray;


    @BeforeClass
    public void setUp() {
        customArray = new CustomArray(1, 2, 3, 4, 5);
        Configurator configurator = new ConfiguratorImpl();
        configurator.configureApplication(customArray);
    }

    @AfterClass
    public void tierDown() {
        Repository repository = RepositoryImpl.getInstance();
        repository.clear();
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.clear();
        customArray = null;
    }

    @Test
    public void testArrayChanged() throws CustomException {
        Warehouse warehouse = Warehouse.getInstance();
        customArray.setElementAt(2, 2);
        customArray.setElementAt(3, -7);
        CustomArrayParametrs expected = new CustomArrayParametrs(customArray);
        CustomArrayParametrs actual = warehouse.get(customArray.getCustomArrayId());
        assertEquals(actual, expected);


    }
}
