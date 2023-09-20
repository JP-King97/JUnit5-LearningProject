package junit5Tests.order;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderedTestClass {

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
   // @Disabled(value = "Test Disabled for learning reasons")
    @Order(2)
    void firstMethod(){ // access modifier can be omitted but cannot be private
        System.out.println("This is the first test method");
    }

    @Test
    @Order(3)
    @DisabledOnOs(value = OS.WINDOWS, disabledReason = "Disabled due to Operation System")
    void secondMethod(){
        System.out.println("This is the second test method");
    }

    @Test
    @DisabledIf(value = "booleanProvider" , disabledReason = "Disabled due to boolean condition met")
    @Order(1)
    void thirdMethod(){
        System.out.println("This is the third test method");
    }

    boolean booleanProvider(){
        return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.TUESDAY);
    }

}
