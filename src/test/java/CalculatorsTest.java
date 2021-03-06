import classroomSix.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorsTest {

    private Calculator calculator;

    @Test
    public void testSum(){
        System.out.println("test sum");
        int actualResult = calculator.sum(5,3);
        int expectedResult = 8;
        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(calculator.sum(-5,3),-2);
        Assert.assertEquals(calculator.sum(-5,-3),-8);
        Assert.assertEquals(calculator.sum(0,-3),-3);
        Assert.assertEquals(calculator.sum(2,0),2);
        Assert.assertEquals(calculator.sum(0,0),0);

        System.out.println("This is my first test ever");
    }

    @Test
    public void dalisanasTests(){
        System.out.println("dalisanas tests");
        Assert.assertEquals(calculator.dalisana(8.2, 2.0), 4.1);
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Izpildās before CLASS");
        this.calculator=new Calculator();
    }

    @BeforeMethod
    public void izpilditPirmsKatraTesta(){
        System.out.println("Izpildas before test.");
    }





}
