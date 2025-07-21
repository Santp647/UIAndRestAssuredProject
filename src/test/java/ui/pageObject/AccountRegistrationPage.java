package ui.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "")
    WebElement txtFirstName;
    @FindBy(xpath = "")
    WebElement txtLastName;
    @FindBy(xpath = "")
    WebElement txtEmail;
    @FindBy(xpath = "")
    WebElement txtTelephone;
    @FindBy(xpath = "")
    WebElement txtPassword;
    @FindBy(xpath = "")
    WebElement txtConfirmPassword;
    @FindBy(xpath = "")
    WebElement chkdPolicy;
    @FindBy(xpath = "")
    WebElement btnContinue;
    @FindBy(xpath = "")
    WebElement msgConfirmation;

    public void setFirstname(String fname) {
        txtFirstName.sendKeys(fname);
    }

    public void setLastName(String lname){
        txtLastName.sendKeys(lname);
    }
    public void setEmail(String email){
        txtEmail.sendKeys(email);
    }
    public void setTelephone(String telephone){
        txtTelephone.sendKeys(telephone);
    }
    public void setPassword(String password){
        txtPassword.sendKeys(password);
    }
    public void setconfirmPassword(String cnfrmpassword){
        txtConfirmPassword.sendKeys(cnfrmpassword);
    }
    public void setPrivacyPolicy(){
        chkdPolicy.click();
    }
    public void clickBtnContinue(){
        btnContinue.click();

       // btnContinue.submit();

    }
    public String getConfirmationMsg(){
        try{
            return(msgConfirmation.getText());
        }
        catch (Exception e){
            return (e.getMessage());
        }
    }



}
