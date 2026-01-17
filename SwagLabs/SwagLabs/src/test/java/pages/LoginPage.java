package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Waiter;

public class LoginPage {

    private WebDriver driver;
    private Waiter waiter;

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginBtn = By.id("login-button");
    private By errorMsg = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new Waiter(driver);
    }

    public void openLoginPage(String url) {
        driver.get(url);
    }

    public void enterUsername(String username) {
        waiter.waitForVisibility(usernameField).clear();
        waiter.waitForVisibility(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        waiter.waitForVisibility(passwordField).clear();
        waiter.waitForVisibility(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        waiter.waitForClickability(loginBtn).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public String getErrorMessage() {
        return waiter.waitForVisibility(errorMsg).getText();
    }
}