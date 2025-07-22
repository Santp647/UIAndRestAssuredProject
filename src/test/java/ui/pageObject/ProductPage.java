package ui.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    @FindBy(xpath = "//span[contains(text(),\"Products\")]")
    WebElement products;
    @FindBy(xpath = "//span[contains(text(),\"1\")]")
    WebElement addedToCart;

    @FindBy(xpath = "//button[@id=\"add-to-cart\"]")
    WebElement addToCartBtn;
    @FindBy(xpath = "//a[@class=\"shopping_cart_link\"]")
    WebElement cartLinkBtn;


    // Get product item based on product name
    public WebElement getProductItem(String productName) {
        String xpath = "//div[contains(text(),'" + productName + "')]";
        return driver.findElement(By.xpath(xpath));
    }

    // Get 'Add to cart' button based on product Name and click
    public void addToCartByItemName(String productName) {
        String xpath = "//button[@id='add-to-cart-" + productName + "']";
         driver.findElement(By.xpath(xpath)).click();
    }
    public String getDashboardHeaderOnPage() {
        WebElement dashboardHeader = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),\"Products\")]")));
        String actualText = dashboardHeader.getText();
        return actualText;

    }

    public String productAddedToCarValidation() {

        WebElement cartItem = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),\"1\")]")));
        String actualText = cartItem.getText();
        return actualText;

    }

}

