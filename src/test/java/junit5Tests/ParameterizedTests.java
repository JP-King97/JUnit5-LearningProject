package junit5Tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParameterizedTests {

   // @BeforeAll
   // void setUp(){
   //     System.out.println("Environment set");
   // }

    @BeforeEach
    void settingVariables(){
        System.out.println("Variables set");
    }

    @AfterEach
    void deletingVariablesValues(){
        System.out.println("Variables Deleted");
    }

  // @AfterAll
  // void tearDown(){
  //     System.out.println("Environment shut down");
  // }

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

    @ParameterizedTest(name = "Iteration: {index} - value: {arguments}")
    @CsvSource(value={"FirstN1,LastN1","FirstN2,LastN2","FirstN3,LastN3"})
    void csvSource_StringString(String parameter1,String parameter2){
        System.out.println("parameter1 = " + parameter1 + ", parameter2 = " + parameter2);
    }

    @ParameterizedTest(name = "Iteration: {index} - value: {arguments}")
    @CsvSource(value = {"FirstN1,LastN1,'LastN1,FirstN1'", "FirstN2,LastN2,'LastN2,FirstN2'", "FirstN3,LastN3,'LastN3,FirstN3'"})
    void csvSource_StringWithComa(String parameter1, String parameter2, String parameter3){
        System.out.println("parameter1 = " + parameter1 + ", parameter2 = " + parameter2 + ", parameter3 = " + parameter3);
    }

    @ParameterizedTest(name = "Iteration: {index} - value: {arguments}")
    @CsvSource(value = {"FirstN1&LastN1","FirstN2&LastN2","FirstN3&LastN3"},delimiter = '&')
    void csvSource_StringWithDifferentDelimiter(String parameter1, String parameter2){
        System.out.println("parameter1 = " + parameter1 + ", parameter2 = " + parameter2);
    }

    @ParameterizedTest(name = "Iteration: {index} - value: {arguments}")
    @CsvFileSource(files = {"src/test/resources/parameters/CsvFile.csv","src/test/resources/parameters/CsvFile2.csv"},numLinesToSkip = 1)
    void csvFileSource_String(String parameter1, String parameter2, String parameter3, int parameter4){
        System.out.println("parameter1 = " + parameter1 + ", parameter2 = " + parameter2 + ", parameter3 = " + parameter3 + ", parameter = " + parameter4);
    }

    @ParameterizedTest(name = "Iteration: {index} - value: {arguments}")
    @MethodSource(value = "sourceString")
    void methodSource_StringStream(String Parameter1){
        System.out.println("Parameter1 = " + Parameter1);
    }


    Stream<String> sourceStringAsSteam(){
        return Stream.of("Apple","Watermelon","PineApple","grapes");
    }
    List<String> sourceString(){
        return Arrays.asList("Tomato","Carrot", "Onion");
    }
    List<Arguments> sourceList_StringDouble(){
        return Arrays.asList(Arguments.arguments("Tomato",2.0),Arguments.arguments("Carrot",4.5), Arguments.arguments("Onion",7.8));
    }
}
