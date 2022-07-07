package seleniumHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.ProductsPage;
import pageObjectsHomework.*;

import java.net.URL;
import java.time.Duration;

public class sauceDemoTests {

    WebDriver driver;

    private final String URL = "https://www.saucedemo.com/";

    @BeforeMethod
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void testScenarioOne() throws InterruptedException {
        driver.get(URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(3000);

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getPageTitle().getText(), "PRODUCTS");
        inventoryPage.addToCart();
        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getItemName().getText(), "Sauce Labs Bike Light");
        Thread.sleep(3000);
        cartPage.getCheckoutButton().click();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.insertData("Agita", "Karklite", "LV4201");
        checkoutPage.getContinueButton().click();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        Assert.assertEquals(checkoutOverviewPage.getOverviewTitle().getText(),"CHECKOUT: OVERVIEW");
        Assert.assertEquals(checkoutOverviewPage.getItemName().getText(),"Sauce Labs Bike Light");
        Thread.sleep(3000);
        checkoutOverviewPage.getFinishButton().click();

        CheckoutSuccessPage checkoutSuccessPage = new CheckoutSuccessPage(driver);
        Assert.assertEquals(checkoutSuccessPage.getPageTitle().getText(),"CHECKOUT: COMPLETE!");
        Assert.assertEquals(checkoutSuccessPage.getThankYouText().getText(),"THANK YOU FOR YOUR ORDER");
        Thread.sleep(3000);
        checkoutSuccessPage.getBackHomeButton().click();
        Thread.sleep(3000);
    }

    @Test
    public void testScenarioTwo(){
        driver.get(URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.getEmptyCartButton().click();

        CartPage cartPage = new CartPage(driver);
        cartPage.getCheckoutButton().click();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.getContinueButton().click();
        Assert.assertEquals(checkoutPage.getErrorFirstName().getText(),"Error: First Name is required");

        checkoutPage.insertData("Agita","","");
        checkoutPage.getContinueButton().click();
        Assert.assertEquals(checkoutPage.getErrorLastName().getText(),"Error: Last Name is required");

        checkoutPage.insertData("","Karklite","");
        checkoutPage.getContinueButton().click();
        Assert.assertEquals(checkoutPage.getErrorZipPostalCode().getText(),"Error: Postal Code is required");

    }

















    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}
