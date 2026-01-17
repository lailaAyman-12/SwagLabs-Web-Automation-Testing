package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;
import utils.DriverFactory;
import org.testng.Assert;

public class LoginSteps {

    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    ProductsPage productsPage = new ProductsPage(driver);

    @Given("I am on the Swag Labs login page")
    public void i_am_on_the_swag_labs_login_page() {
        loginPage.openLoginPage("https://www.saucedemo.com/");
    }

    @When("I login with valid credentials")
    public void i_login_with_valid_credentials() {
        loginPage.login("standard_user", "secret_sauce");
    }

    @Then("I should be redirected to the Products page")
    public void i_should_be_redirected_to_the_products_page() {
        String title = productsPage.getPageTitle();
        Assert.assertEquals(title, "Products",
                "User is not on Products page");
    }
}