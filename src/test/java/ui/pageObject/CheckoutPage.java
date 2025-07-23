package ui.pageObject;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id=\"first-name\"]")
    WebElement firstName;
    @FindBy(xpath = "//input[@id=\"last-name\"]")
    WebElement lastName;
    @FindBy(xpath = "//input[@id=\"postal-code\"]")
    WebElement zipCode;
    @FindBy(xpath = "//input[@id=\"continue\"]")
    WebElement continue1;
    @FindBy(xpath = "//button[@id=\"cancel\"]")
    WebElement cancel;

    public void setFirstName(){
        firstName.sendKeys(generateRandomString());
    }
    public void setLastName(){
        lastName.sendKeys(generateRandomString());
    }
    public void setZipCode(){
        zipCode.sendKeys(generateRandomString());
    }
    public void clickContinue(){
        continue1.click();
    }
    public String generateRandomString(){
        String randomString= RandomStringUtils.randomAlphabetic(5);
        return randomString;
    }


}
