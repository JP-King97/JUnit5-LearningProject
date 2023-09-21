package junit5Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class AssertionsTests {

    @Test
    void assertEqualsTest(){
        Assertions.assertEquals("firstString","secondString","The string values were not equals");
    }

    @Test
    void assertEqualListTest(){
        List<String> expectedValues = Arrays.asList("firstString","secondString","thirdString");
        List<String> actualValues = Arrays.asList("firstString","secondString","thirdString");
        Assertions.assertEquals(expectedValues,actualValues,"Lists' values were not equals");
    }

    @Test
    void assertArraysEqualsTest(){
        int[] expectedValues = {1,3,5};
        int[] actualValues = {1,3,5};
        Assertions.assertArrayEquals(expectedValues,actualValues,"Arrays were not Equals");
    }

    @Test
    void assertTrueTest(){
        Assertions.assertTrue(true, "The boolean variable is false");
    }

    @Test
    void assertFalseTest(){
        Assertions.assertFalse(false, "The boolean variable is true");
    }

    @Test
    void assertThrowsTest(){
        Assertions.assertThrows(NullPointerException.class,null);
    }

    @Test
    void assertAllTest(){
        Assertions.assertAll(
                () -> Assertions.assertEquals("firstString","secondString","The Stirndfff"),
                () ->Assertions.assertThrows(NullPointerException.class, null),
                () ->Assertions.assertTrue(false, "This boolean condition did not evaluate to true")
        );
    }
}
