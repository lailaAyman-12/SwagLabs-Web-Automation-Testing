package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueBtn = By.id("continue");
    private By errorMsg = By.cssSelector("h3[data-test='error']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String fName) {
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(fName);
    }

    public void enterLastName(String lName) {
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(lName);
    }

    public void enterPostalCode(String zip) {
        driver.findElement(postalCode).clear();
        driver.findElement(postalCode).sendKeys(zip);
    }

    public void enterInformation(String fName, String lName, String zip) {
        enterFirstName(fName);
        enterLastName(lName);
        enterPostalCode(zip);
    }

    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }
}