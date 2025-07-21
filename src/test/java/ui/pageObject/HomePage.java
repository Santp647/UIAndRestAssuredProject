package ui.pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="")
    WebElement linkMyAccount;

    @FindBy(xpath="")
    WebElement linkRegister;

    public void clickMyAccount(){
        linkMyAccount.click();
    }
    public void clickRegister(){
        linkRegister.click();
    }
}
