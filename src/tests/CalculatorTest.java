package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import calc.Calculator;

/**
 * Created by ronaynee on 2/26/2016.
 */
public class CalculatorTest {

    Calculator calc = null;

    @Before
    public void setUp() throws Exception {
        calc = new Calculator();
    }

    @After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void testAdd() throws Exception {
        List<Integer> integers = new ArrayList<Integer>();
        integers.add(1);
        integers.add(5);
        integers.add(7);

        Assert.assertEquals(13, calc.add(integers).intValue());
    }

    @org.junit.Test
    public void testSubtract() throws Exception {
        List<Integer> integers = new ArrayList<Integer>();
        integers.add(9);
        integers.add(2);
        integers.add(8);

        Assert.assertEquals(-1, calc.subtract(integers).intValue());
    }

    @org.junit.Test
    public void testMultiply() throws Exception {
        List<Integer> integers = new ArrayList<Integer>();
        integers.add(2);
        integers.add(3);
        integers.add(4);

        Assert.assertEquals(24, calc.multiply(integers).intValue());
    }

    @org.junit.Test
    public void testDivide() throws Exception {
        List<Integer> integers = new ArrayList<Integer>();
        integers.add(24);
        integers.add(2);
        integers.add(6);

        Assert.assertEquals(2.0, calc.divide(integers).intValue(), 0.001);

        integers.clear();
        integers.add(9);
        integers.add(0);
        integers.add(3);

        Assert.assertEquals(Double.NaN, calc.divide(integers).doubleValue(), 0.001);
    }

    @org.junit.Test
    public void testRoot() throws Exception {

    }

    @org.junit.Test
    public void testAddHistory() throws Exception {

    }

    @org.junit.Test
    public void testPrintHistory() throws Exception {

    }

    @org.junit.Test
    public void testGetHistoryValue() throws Exception {

    }

    @org.junit.Test
    public void testClearHistory() throws Exception {

    }
}