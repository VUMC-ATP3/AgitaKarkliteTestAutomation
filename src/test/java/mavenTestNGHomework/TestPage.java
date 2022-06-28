package mavenTestNGHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestPage {

    WebDriver chromeParluks;

    @Test
    public void testPage(){
        chromeParluks.navigate().to("https://www.mossacosmetics.com/lv/");
        String expectedTitle = "MOSSA Organic Skincare";
        String actualTitle = chromeParluks.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testSecondPage(){
        chromeParluks.navigate().to("https://dabasdots.lv/");
        String expectedTitle = "Dabas Dots – dabīga sula";
        String actualTitle = chromeParluks.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @BeforeMethod
    public void open(){
        chromeParluks = new ChromeDriver();
    }

    @AfterMethod
    public void close(){
        chromeParluks.quit();
    }

}
