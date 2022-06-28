package mavenTestNGHomework;

import Homework.Calculators;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCalc {

    private Calculators calc;

   @Test
   public void TestAdd () {
       System.out.println("Tests saskaitīšanai");
       int actualResult = calc.add(9, 5);
       int expectedResult = 14;
       Assert.assertEquals(actualResult, expectedResult);
       Assert.assertEquals(calc.add(5, 3), 8);
       Assert.assertEquals(calc.add(1, 4), 5);
   }

    @Test
    public void TestSubst (){
        System.out.println("Tests atņemšanai ");
        Assert.assertEquals(calc.substract(5,4),1);
    }

    @Test
    public void TestMult (){
        System.out.println("Tests reizināšanai ");
        Assert.assertEquals(calc.multiply(4,2),8);
    }

    @Test
    public void TestDiv (){
        System.out.println("Tests dalīšanai ");
        Assert.assertEquals(calc.divide(10,5),2);
    }

    @BeforeClass
    public void BeforeClass() {
        this.calc = new Calculators();
    }

    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("Tests ir sācies!");
    }





}
