package ui.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OderCompletePage extends BasePage {
    public OderCompletePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath="//h2[contains(text(),'Thank you for your order!')]")
    WebElement txtThankYou;

    public String getOrderPLacedMsg(){
        String getText=txtThankYou.getText();
        return getText;
    }





}
