package HomeWork4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TriangleTest {
    int a;
    int b;
    int c;


    @ParameterizedTest
    @CsvSource({"3,2,2", "7,8,9", "13,15,18"})
    @DisplayName("triangle area tests")
    public void Test(int x, int y, int z) {
        double p = ((float) (x + y + z)) / 2;


        double sumTr =Triangle.Parties(x, y, z);
        assertTrue(sumTr >= 0, " It's not a triangle");
        Assertions.assertTrue(Math.abs(sumTr - Math.sqrt(p * (p - x) * (p - y) * (p - z))) <= 0.000001);
    }

    @DisplayName("It's not a triangle")
    @Test
    public void Test2() {
        double sumTr = Triangle.Parties(0, 0, 0);
        assertTrue(sumTr <= 0, " It's not a triangle");
        Assertions.assertEquals(sumTr, -1);
    }

    @DisplayName("Isosceles triangle")
    @Test
    public void Test3() {
        a = 2;
        b = a;
        c = 8;
        double sumTr = Triangle.Parties(a, b, c);
        assertTrue(sumTr >= 0, " It's not a triangle");
        Assertions.assertTrue(Math.abs(sumTr - 0.5 * c * Math.sqrt(a * a - ((double) c * c) / 4)) <= 0.000001);
    }

    @DisplayName("Negative values test")
    @Test
    public void Test4() {
        double sumTr = Triangle.Parties(-7, -8, -9);
        assertTrue(sumTr <= 0, " It's not a triangle");
        Assertions.assertEquals(sumTr, -1);
    }

    @DisplayName("Right angle test")
    @Test
    public void Test5() {
        a = 13;
        b = 15;
        c = 18;
        double sumTr = Triangle.Parties(a, b, c);
        assertTrue(sumTr >= 0, " It's not a triangle");
        Assertions.assertTrue(Math.abs(sumTr - 0.5 * a * b) <= 0.000001);
    }

    @Nested
    @DisplayName("Logging test")
    public static class MyTestLog {

        static Logger logger = LoggerFactory.getLogger(MyTestLog.class);

        @Test
        void logTest() {
            logger.debug("Debug");
            logger.error("Error");
        }
    }
}
