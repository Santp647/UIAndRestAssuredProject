package ui.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourCartPage extends BasePage {

    public YourCartPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//button[@id=\"checkout\"]")
    WebElement checkOutBtn;
}
