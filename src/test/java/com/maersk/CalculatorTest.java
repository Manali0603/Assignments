package com.maersk;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator c;
    TestInfo testinfo;
    TestReporter testReporter;

    @BeforeEach
    void init(TestInfo testinfo, TestReporter testReporter) {
        this.testinfo = testinfo;
        this.testReporter = testReporter;
        c = new Calculator();
        testReporter.publishEntry("Running " + testinfo.getDisplayName() + " with tags " + testinfo.getTags());
    }

    @Test
    @Tag("Math")
    @DisplayName("Addition method")
    void testAdd() {
        int expected = 18;
        int actual = c.add(8, 10);
        assertEquals(expected, actual);
    }

    @RepeatedTest(2)
    @Tag("Area")
    @DisplayName("Circle area method")
    void testfindCircleArea() {
        assertEquals(314.1592653589793, c.findCircleArea(10.0), "should give the area of circle ");
    }

    @Test
    @Tag("Math")
    @DisplayName("Division method")
    void testDivide() {

        assertThrows(ArithmeticException.class, () -> c.divide(4, 2), "Cannot divide by 0...");
    }

    @Test
    @Tag("Math")
    @DisplayName("Multiplication method")
    void testMultiply() {
        System.out.println("Running " + testinfo.getDisplayName() + " with tags " + testinfo.getTags());
        assertAll(
                () -> assertEquals(4, c.multiply(4, 1)),
                () -> assertEquals(10, c.multiply(5, 2)),
                () -> assertEquals(6, c.multiply(3, 2))
        );
    }

}
