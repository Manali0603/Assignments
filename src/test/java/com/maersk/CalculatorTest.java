package com.maersk;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator c;
    @BeforeEach
    void init()
    {
        c=new Calculator();
    }
    @Test
    void testAdd() {
        int expected = 18;
        int actual = c.add(8, 10);
        assertEquals(expected, actual);
    }

    @Test
    void testfindCircleArea() {

        assertEquals(314.1592653589793, c.findCircleArea(10.0), "should give the area of circle ");
    }

    @Test
    void testDivide() {

        assertThrows(ArithmeticException.class,() -> c.divide(4, 2),"Cannot divide by 0...");
    }

}
