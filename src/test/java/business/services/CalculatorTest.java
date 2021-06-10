package business.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @Test
    void getBeams() {
        int expected = 15;
        int actual = calculator.getBeams(780);

        assertEquals(expected, actual);
    }

    @Test
    void testGetRaftersPrice() {
        double expected = 6300;
        double actual = calculator.getMaterialPrice(70, 600, 15);

        assertEquals(expected, actual, 0.01);
    }


}