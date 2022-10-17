package com.rnd.junit5;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    @DisplayName("shouldAnswerWithTrue ...")
    public void shouldAnswerWithTrue() {
        assertTrue(true);
        System.out.println("shouldAnswerWithTrue");
    }

    @Test
    @DisplayName("shouldAnswerWithTrue 2...")
    public void shouldAnswerWithTrue2() {
        System.out.println("shouldAnswerWithTrue 2");

        assertTrue(true);
    }

    @BeforeAll
    static void setup() {
        System.out.println("@BeforeAll - executes once before all test methods in this class");
    }

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach - executes before each test method in this class");
    }

    @AfterAll
    static void done() {
        System.out.println("@AfterAll - executed after all test methods.");
    }


    @Test
    public void testGroupAsserrsion() {
        int[] numbers = {0, 1, 2, 3, 4};
        assertAll("numbers",
                () -> assertEquals(numbers[0], 1),
                () -> assertEquals(numbers[3], 3),
                () -> assertEquals(numbers[4], 1)
        );


    }


    @Test
    public void testThrowExcption() {
        assertThrows(UnsupportedOperationException.class, () -> {
            throw new RuntimeException("I just don't like this");
        }, "should throw unsupportedOperationException");
    }

    @Test
    public void testLamdas() {
        final List<Integer> numbers = Arrays.asList(2, 3, 4);
        assertTrue(numbers.stream().mapToInt(Integer::intValue).sum() > 5, "sum should be greater than 5");
    }

}
