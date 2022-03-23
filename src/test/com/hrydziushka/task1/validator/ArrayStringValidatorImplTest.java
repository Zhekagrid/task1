package test.com.hrydziushka.task1.validator;

import com.hrydziushka.task1.validator.impl.ArrayStringValidatorImpl;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ArrayStringValidatorImplTest {
    ArrayStringValidatorImpl validator;

    @BeforeClass
    public void setUp() {
        validator = new ArrayStringValidatorImpl();
    }

    @AfterClass
    public void tierDown() {
        validator = null;
    }

    @Test
    public void correctValidateTest() {
        boolean actual = validator.isValidate("+1;-1;2;");
        assertTrue(actual);
    }

    @Test
    public void incorrectValidateTest() {
        boolean actual = validator.isValidate("-1;2k3");
        assertFalse(actual);

    }



}