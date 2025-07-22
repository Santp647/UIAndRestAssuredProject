package ui.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.pageObject.*;

import java.time.Duration;

public class E2ETestCases{


    WebDriver driver = new ChromeDriver();
    LoginPage lp = new LoginPage(driver);
    ProductPage pp = new ProductPage(driver);
    YourCartPage ycp = new YourCartPage(driver);
    CheckoutPage cp = new CheckoutPage(driver);
    CheckoutOverviewPage cop = new CheckoutOverviewPage(driver);



    @BeforeTest
    public void setUp() {
      //  driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");

    }

    @Test(priority = 1)
    public void verifylogin() {

        lp.setUserName("standard_user");
        lp.setPassword("secret_sauce");
        lp.clickOnLoginBtn();
        String actualText = pp.getDashboardHeaderOnPage();
        String ExpectedText = "Products";
        Assert.assertEquals(actualText, ExpectedText);

    }

    @Test(priority = 2, dependsOnMethods = {"verifylogin"})
    public void verifyAddToCartByItemName() {
        pp.addToCartByItemName("sauce-labs-backpack");
        String actualText = pp.productAddedToCarValidation();
        String ExpectedText = "1";
        Assert.assertEquals(actualText, ExpectedText);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


}
