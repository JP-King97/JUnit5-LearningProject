package junit5Tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTests {

    @ParameterizedTest(name = "Iteration: {index} - value: {arguments}")
    @ValueSource(ints = {1,2,3,4,5,6,7})
    void intValues(int theParameter){
        System.out.println("theParameter = " + theParameter);
    }

    @ParameterizedTest(name = "Iteration: {index} - value: {arguments}")
    @NullSource
    @EmptySource
    @ValueSource(strings = {"First String","Second String"})
    void stringValues(String theParameter){
        System.out.println("theParameter = " + theParameter);
    }
}
