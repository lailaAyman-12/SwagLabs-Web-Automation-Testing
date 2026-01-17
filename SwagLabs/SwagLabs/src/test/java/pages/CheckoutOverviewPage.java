package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {

    private WebDriver driver;

    private By itemTotal = By.className("summary_subtotal_label");
    private By tax = By.className("summary_tax_label");
    private By total = By.className("summary_total_label");
    private By finishBtn = By.id("finish");
    private By thankYouMsg = By.className("complete-header");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public double getItemTotal() {
        String text = driver.findElement(itemTotal).getText();
        return Double.parseDouble(text.replace("Item total: $", "").trim());
    }

    public double getTax() {
        String text = driver.findElement(tax).getText();
        return Double.parseDouble(text.replace("Tax: $", "").trim());
    }

    public double getTotal() {
        String text = driver.findElement(total).getText();
        return Double.parseDouble(text.replace("Total: $", "").trim());
    }

    public void clickFinish() {
        driver.findElement(finishBtn).click();
    }

    public boolean isThankYouDisplayed() {
        return driver.findElement(thankYouMsg).isDisplayed();
    }
}