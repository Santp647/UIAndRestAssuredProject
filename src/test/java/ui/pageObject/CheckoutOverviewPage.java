package ui.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage{
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//button[@id=\"finish\"]")
    WebElement finish;
    @FindBy(xpath = "//button[@id=\"cancel\"]")
    WebElement cancel;

    public void clickFinishBtn(){
        finish.click();
    }
    public void clickCancelBtn(){
        cancel.click();
    }
}

