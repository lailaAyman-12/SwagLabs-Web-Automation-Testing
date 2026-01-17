package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By cartTitle = By.xpath("//span[text()='Your Cart']");
    private By backpackItemName = By.xpath("//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']");
    private By boltItemName = By.xpath("//div[@class='inventory_item_name' and text()='Sauce Labs Bolt T-Shirt']");
    private By itemPrices = By.className("inventory_item_price");
    private By checkoutBtn = By.id("checkout");
    private By continueShoppingBtn = By.id("continue-shopping");
    private By removeBackpackBtn = By.id("remove-sauce-labs-backpack");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Wait until the cart page is fully visible
    public void waitForCartPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartTitle));
    }

    // Check if the backpack item is displayed in the cart
    public boolean isBackpackDisplayed() {
        return !driver.findElements(backpackItemName).isEmpty();
    }

    // Check if the bolt t-shirt item is displayed in the cart
    public boolean isBoltDisplayed() {
        return !driver.findElements(boltItemName).isEmpty();
    }

    // Get all product prices from the cart as a double array
    public double[] getProductPrices() {
        List<WebElement> prices = driver.findElements(itemPrices);
        double[] priceValues = new double[prices.size()];

        for (int i = 0; i < prices.size(); i++) {
            String text = prices.get(i).getText().replace("$", "").trim();
            priceValues[i] = Double.parseDouble(text);
        }
        return priceValues;
    }

    // Click on the checkout button
    public void clickCheckout() {
        waitForCartPage();
        WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
        scrollIntoView(checkout);
        checkout.click();
    }

    // Click on the continue shopping button
    public void clickContinueShopping() {
        waitForCartPage();
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueShoppingBtn));
        scrollIntoView(continueBtn);
        continueBtn.click();
    }

    // Remove the backpack item from the cart
    public void removeBackpack() {
        WebElement removeBtn = wait.until(ExpectedConditions.elementToBeClickable(removeBackpackBtn));
        scrollIntoView(removeBtn);
        removeBtn.click();
    }

    // Helper method to scroll an element into view before interacting
    private void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}