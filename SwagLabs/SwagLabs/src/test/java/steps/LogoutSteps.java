package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import pages.MenuPage;
import utils.DriverFactory;

public class LogoutSteps {

    WebDriver driver = DriverFactory.getDriver();
    MenuPage menuPage = new MenuPage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @When("I logout from the application")
    public void i_logout_from_the_application() {
        menuPage.openMenu();
        menuPage.clickLogout();
    }

    @Then("I should be redirected back to the login page")
    public void i_should_be_redirected_back_to_the_login_page() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("saucedemo.com"),
                "Not on Swag Labs login page");
    }
}