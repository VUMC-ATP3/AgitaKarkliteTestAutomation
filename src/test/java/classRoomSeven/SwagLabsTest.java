package classRoomSeven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Footer;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;

import java.time.Duration;
import java.util.List;

public class SwagLabsTest {
    WebDriver driver;
    private final String SWAGLABS_URL = "https://www.saucedemo.com/";
    private final String LOCAL_URL = "file://D:\\Lekcija4\\JavaLekcija4\\New folder\\AgitaKarkliteTestAutomation\\elements.html";

    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){
        //atveram browseri
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Atveram browseri");
    }

    @Test
    public void testErorrMessage() throws InterruptedException {

        driver.get(SWAGLABS_URL);

        //atrod un ieraksta lietotajvarda lauku
        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("standard_user");

        //atrod un ieraksta paroli
        WebElement passwordInputField = driver.findElement(By.name("password"));
        passwordInputField.sendKeys("");

        //atrod login pogu
        WebElement loginButton = driver.findElement(By.cssSelector("input#login-button"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "Epic sadface: Password is required";

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);


        System.out.println("Izpildam testu");
    }

    @Test
    public void testErrorMessageWithoutPasswordPOM(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Juris", "");
        String actualText = loginPage.getErrorMessageTextField().getText();
        String expectedErrorMessage = "Epic sadface: Password is required";
        Assert.assertEquals(actualText,expectedErrorMessage);
    }

    @Test
    public void testErrorMessageWithoutUsernamePOM(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "parole");
        String actualText = loginPage.getErrorMessageTextField().getText();
        String expectedErrorMessage = "Epic sadface: Username is required";
        Assert.assertEquals(actualText,expectedErrorMessage);
    }

    @Test
    public void testSuccessLogin(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.getPageTitle().getText(), "PRODUCTS");
    }

    @Test
    public void testFooterCopyRightText() {
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Footer footer = new Footer(driver);
        String actualString = footer.getCopyRightTextField().getText();
        String expectedString = "© 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
        Assert.assertEquals(actualString, expectedString);
    }

    @Test
    public void testSuccessfulLogin() throws InterruptedException {
        driver.get(SWAGLABS_URL);
        WebElement userNameInputField =  driver.findElement(By.id("user-name"));
//        WebElement userNameInputField =  driver.findElement(By.cssSelector("input[id='user-name']"));
        userNameInputField.sendKeys("standard_user");

        //tagad uzrakstam paroles lauku un ievadam tur vertibu
        WebElement passwordInputField = driver.findElement(By.name("password"));
        passwordInputField.sendKeys("secret_sauce");

        //atradisim Login pogu

        WebElement loginButton = driver.findElement(By.cssSelector("input#login-button"));
        loginButton.click();

        WebElement titleText = driver.findElement(By.cssSelector("span[class='title']"));
        Assert.assertEquals(titleText.getText(),"PRODUCTS");

        WebElement linkedInLink = driver.findElement(By.linkText("LinkedIn"));
        // WebElement linkedInLink = driver.findElement(By.cssSelector("li[class='social_linkedin'] > a"));

        //linkedInLink.click();

        Select sortDropDown = new Select(driver.findElement(By.className("product_sort_container")));
        sortDropDown.selectByValue("hilo");

        WebElement addFleeceJacketToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']"));
        addFleeceJacketToCartButton.click();

        Thread.sleep(5000);
    }

    @Test
    public void testSamplePage() throws InterruptedException {
        driver.get(LOCAL_URL);
        WebElement vards = driver.findElement(By.id("fNameID"));
        vards.sendKeys("Agita");

        WebElement uzvards = driver.findElement(By.id("lNameID"));
        vards.sendKeys("Karklite");

        WebElement informacija = driver.findElement(By.name("description"));
        informacija.clear();
        informacija.sendKeys("Šī ir info par mani");

        WebElement studentCheckbox = driver.findElement(By.id("studentID"));
        studentCheckbox.click();

        WebElement radiobuttonJava = driver.findElement(By.id("javaID"));
        System.out.println(radiobuttonJava.isSelected());
        radiobuttonJava.click();
        System.out.println(radiobuttonJava.isSelected());

        Select milakaKrasaDropdown = new Select(driver.findElement(By.id("colorsID")));
        milakaKrasaDropdown.selectByIndex(0);
        milakaKrasaDropdown.selectByIndex(1);

        List<WebElement> saraksts = milakaKrasaDropdown.getOptions();

        for (int i = 0; i < saraksts.size(); i++) {
            System.out.println(saraksts.get(i).getText());
        }

        Thread.sleep(5000);
    }


    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        //aizveram browseri
        driver.quit();
        System.out.println("Aizveram browseri");
    }

}
