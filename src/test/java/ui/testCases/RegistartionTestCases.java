package ui.testCases;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.pageObject.AccountRegistrationPage;
import ui.pageObject.HomePage;
import java.util.concurrent.TimeUnit;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RegistartionTestCases {
    WebDriver driver = new ChromeDriver();
    HomePage hp = new HomePage(driver);
    AccountRegistrationPage arp=new AccountRegistrationPage(driver);

    @BeforeTest
    public void setUp() {

        driver.manage().deleteAllCookies();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http//localhost/opencart/upload/index.php");

    }

    @Test
    public void verifyAccountRegistration() {
hp.clickMyAccount();
hp.clickRegister();
arp.setFirstname("Sant");
arp.setLastName("Prasad");
arp.setEmail("sasas@gmail.com");
arp.setTelephone("6786867");
arp.setPassword("dasdsad");
arp.setconfirmPassword("dasdsad");
arp.setPrivacyPolicy();
arp.clickBtnContinue();

String cnfMsg= arp.getConfirmationMsg();
        Assert.assertEquals(cnfMsg,"Your Acount Has Been Created!");

    }

    @AfterTest
    public void tearDown() {
driver.quit();
    }


}
