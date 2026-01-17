package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By productsTitle = By.xpath("//span[text()='Products']");
    private By addBackpackBtn = By.id("add-to-cart-sauce-labs-backpack");
    private By addBoltShirtBtn = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By cartIcon = By.id("shopping_cart_container");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForProductsPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsTitle));
    }

    public void addBackpack() {
        wait.until(ExpectedConditions.elementToBeClickable(addBackpackBtn)).click();
    }

    public void addBoltShirt() {
        wait.until(ExpectedConditions.elementToBeClickable(addBoltShirtBtn)).click();
    }

    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }

    public String getPageTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productsTitle)).getText();
    }
}