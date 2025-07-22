package ui.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        //System.out.println("Driver is null? " + (driver == null));
        super(driver);

    }

    @FindBy(id = "user-name")
    WebElement userName;
    @FindBy(id = "password")
    WebElement passWord;
    @FindBy(xpath = "//input[@id=\"login-button\"]")
    WebElement loginBtn;

    public void setUserName(String username) {
        userName.sendKeys(username);
    }

    public void setPassword(String password) {
        passWord.sendKeys(password);
    }

    public void clickOnLoginBtn() {
        loginBtn.click();
    }
}
