package ui.testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class E2ETestCases extends BaseClass {

    @Test(priority = 0, dataProvider = "loginData")
    public void testLoginWithMultipleDataSet(Object UserName, Object PassWord) {
        lp.setUserName("standard_user");
        lp.setPassword("secret_sauce");
        lp.clickOnLoginBtn();
        boolean actualText = pp.getDashboardHeaderOnPage();
        boolean ExpectedText = true;
        Assert.assertEquals(actualText, ExpectedText);
    }

    @Test(priority = 1)
    public void verifylogin() {

        lp.setUserName((String) getLoginData()[0][0]);
        lp.setPassword((String)getLoginData()[0][1]);
        lp.clickOnLoginBtn();
        boolean actualText = pp.getDashboardHeaderOnPage();
        boolean ExpectedText = true;
        Assert.assertEquals(actualText, ExpectedText);
    }

    @Test(priority = 2, dependsOnMethods = {"verifylogin"})
    public void verifyAddToCartByItemName() {
        pp.addToCartByItemName("sauce-labs-backpack");
        String actualText = pp.productAddedToCarValidation();
        String ExpectedText = "1";
        Assert.assertEquals(actualText, ExpectedText);

    }

    @Test(priority = 3, dependsOnMethods = {"verifylogin", "verifyAddToCartByItemName"})
    public void verifyOrderPlacedOrNot() {
        pp.clickCartLink();
        ycp.clickOnCheckOutBtn();
        cp.setFirstName();
        cp.setLastName();
        cp.setZipCode();
        cp.clickContinue();
        cop.clickFinishBtn();
        String ActualValue = ocp.getOrderPLacedMsg();
        String ExpectedValue = "Thank you for your order!";
        Assert.assertEquals(ActualValue, ExpectedValue);


    }


}



