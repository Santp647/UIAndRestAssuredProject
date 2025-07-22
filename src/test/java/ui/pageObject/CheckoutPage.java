package ui.pageObject;

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


}
