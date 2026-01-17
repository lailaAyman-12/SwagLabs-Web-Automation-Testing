package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Waiter;

public class MenuPage {

    private WebDriver driver;
    private Waiter waiter;

    private By menuBtn = By.id("react-burger-menu-btn");
    private By logoutLink = By.id("logout_sidebar_link");

    public MenuPage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new Waiter(driver);
    }

    public void openMenu() {
        waiter.waitForClickability(menuBtn).click();
    }

    public void clickLogout() {
        waiter.waitForVisibility(logoutLink);
        waiter.waitForClickability(logoutLink).click();
    }
}