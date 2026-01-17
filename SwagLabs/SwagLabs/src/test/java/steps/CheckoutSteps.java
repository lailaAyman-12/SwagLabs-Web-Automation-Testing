package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import pages.CheckoutCompletePage;
import pages.CheckoutOverviewPage;
import utils.DriverFactory;
import utils.TestContext;

public class CheckoutSteps {

    WebDriver driver = DriverFactory.getDriver();
    CartPage cartPage = new CartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(driver);
    CheckoutCompletePage completePage = new CheckoutCompletePage(driver);

    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {
        cartPage.clickCheckout();
    }

    @And("I fill in the checkout information")
    public void i_fill_in_the_checkout_information() {
        checkoutPage.enterInformation("Laila", "Tester", "12345");
        checkoutPage.clickContinue();
    }

    @Then("the item total should equal the sum of product prices")
    public void the_item_total_should_equal_the_sum_of_product_prices() {
        double expectedSum = TestContext.getCartProductsSum();
        double itemTotal = overviewPage.getItemTotal();
        Assert.assertEquals(itemTotal, expectedSum,
                "Item total does not match sum of products");
    }

    @And("I click finish to complete the purchase")
    public void i_click_finish_to_complete_the_purchase() {
        overviewPage.clickFinish();
    }

    @Then("a thank you message should be displayed")
    public void a_thank_you_message_should_be_displayed() {
        Assert.assertTrue(overviewPage.isThankYouDisplayed(),
                "Thank you message not displayed");
        Assert.assertTrue(completePage.isOrderComplete(),
                "Order complete message not displayed");
    }
}