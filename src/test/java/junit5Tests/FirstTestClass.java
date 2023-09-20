package junit5Tests;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FirstTestClass {

    @BeforeAll
    void setUp(){
        System.out.println("Environment set");
    }

    @BeforeEach
    void settingVariables(){
        System.out.println("Variables set");
    }

    @AfterEach
    void deletingVariablesValues(){
        System.out.println("Variables Deleted");
    }

    @AfterAll
    void tearDown(){
        System.out.println("Environment shut down");
    }

    @Test
    void firstMethod(){ // access modifier can be omitted but cannot be private
        System.out.println("This is the first test method");
    }


    @RepeatedTest(value = 5, name = "Running repetition: {currentRepetition}. Total is: {totalRepetitions}")
    void secondMethod(){
        System.out.println("This is the second test method");
    }
}
