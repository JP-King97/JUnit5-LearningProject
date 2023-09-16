package junit5Tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTests {

    @ParameterizedTest(name = "Iteration: {index} - value: {arguments}")
    @ValueSource(ints = {1,2,3,4,5,6,7})
    void intValues(int theParameter){
        System.out.println("theParameter = " + theParameter);
    }
}
