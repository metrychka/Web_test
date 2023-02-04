package Lesson_4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;


class TriangleTest {
    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @Test
    void triangleRеsult() throws MyExeption {
        Triangle triangle = new Triangle();
        Assertions.assertEquals(50, triangle.trianleFunction(12, 10, 15));
    }

    @Test
    void triangleExeption() throws MyExeption {
        Triangle triangle = new Triangle();
        Assertions.assertThrows(MyExeption.class,()->triangle.trianleFunction(12, -10, 15));
        }

     @ParameterizedTest
     @CsvSource({ "12,10,15,50","10, 15,20,60","30,40,50, 600"})
     void triangleParam(int a, int b, int c, int result) throws MyExeption {
         Triangle triangle = new Triangle();
         Assertions.assertEquals(result, triangle.trianleFunction(a, b, c));
        }
        @ParameterizedTest
        @CsvSource({ "12,10,-15,50","10, -15,20,60","30,-40,50,600"})
    void triangleParamNeg(int a, int b, int c, int result) throws MyExeption {
            Triangle triangle = new Triangle();
            Assertions.assertThrows(MyExeption.class,()->triangle.trianleFunction(a, b, c));
        }

        @Test
        void triangleRеsultNot() throws MyExeption {
            Triangle triangle = new Triangle();
            Assertions.assertNotEquals(60, triangle.trianleFunction(12, 10, 15));
        }
    }

