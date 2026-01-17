package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CheckoutPage;
import pages.LoginPage;
import utils.DriverFactory;

public class NegativeSteps {

    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @When("I login with invalid credentials")
    public void i_login_with_invalid_credentials() {
        loginPage.enterUsername("wrong_user");
        loginPage.enterPassword("wrong_pass");
        loginPage.clickLogin();
    }

    @Then("an invalid login error message should be displayed")
    public void an_invalid_login_error_message_should_be_displayed() {
        String msg = loginPage.getErrorMessage();
        Assert.assertTrue(msg.contains("Username and password do not match any user"),
                "Unexpected error message: " + msg);
    }

    @When("I login with a locked out user")
    public void i_login_with_a_locked_out_user() {
        loginPage.enterUsername("locked_out_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }

    @Then("a locked out error message should be displayed")
    public void a_locked_out_error_message_should_be_displayed() {
        String msg = loginPage.getErrorMessage();
        Assert.assertTrue(msg.contains("Sorry, this user has been locked out"),
                "Unexpected locked out message: " + msg);
    }

    @When("I try to continue checkout with missing first name")
    public void i_try_to_continue_checkout_with_missing_first_name() {
        checkoutPage.enterLastName("Tester");
        checkoutPage.enterPostalCode("12345");
        checkoutPage.clickContinue();
    }

    @Then("a first name required error should be displayed")
    public void a_first_name_required_error_should_be_displayed() {
        String msg = checkoutPage.getErrorMessage();
        Assert.assertTrue(msg.contains("First Name is required"),
                "Unexpected error message: " + msg);
    }
}