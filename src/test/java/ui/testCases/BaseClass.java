package ui.testCases;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import ui.pageObject.*;

import java.time.Duration;

public class BaseClass {

    WebDriver driver = new ChromeDriver();
    LoginPage lp = new LoginPage(driver);
    ProductPage pp = new ProductPage(driver);
    YourCartPage ycp = new YourCartPage(driver);
    CheckoutPage cp = new CheckoutPage(driver);
    CheckoutOverviewPage cop = new CheckoutOverviewPage(driver);
    OderCompletePage ocp = new OderCompletePage(driver);


    @BeforeTest
    public void setUp() {
        //  driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

    }

    public void handleAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        Object[][] data = {
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"}

        };

        return data;
    }

    public String[][] getLoginData() {

        Dotenv dotenv = Dotenv.load();

        String[][] data = {
                {dotenv.get("USERNAME"), dotenv.get("PASSWORD")}
        };
        return data;
    }
}


