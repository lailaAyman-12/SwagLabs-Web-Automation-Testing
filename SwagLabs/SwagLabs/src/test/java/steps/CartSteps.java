package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import pages.ProductsPage;
import utils.DriverFactory;
import utils.TestContext;

public class CartSteps {

    WebDriver driver = DriverFactory.getDriver();
    ProductsPage productsPage = new ProductsPage(driver);
    CartPage cartPage = new CartPage(driver);

    @And("I add the backpack to the cart")
    public void i_add_the_backpack_to_the_cart() {
        productsPage.waitForProductsPage();
        productsPage.addBackpack();
    }

    @And("I open the cart")
    public void i_open_the_cart() {
        productsPage.openCart();
        cartPage.waitForCartPage();
    }

    @Then("the backpack should be displayed in the cart")
    public void the_backpack_should_be_displayed_in_the_cart() {
        Assert.assertTrue(cartPage.isBackpackDisplayed(),
                "Backpack is not displayed in cart");
    }

    @When("I click continue shopping")
    public void i_click_continue_shopping() {
        cartPage.clickContinueShopping();
        productsPage.waitForProductsPage();
    }

    @And("I add the bolt t-shirt to the cart")
    public void i_add_the_bolt_t_shirt_to_the_cart() {
        productsPage.addBoltShirt();
    }

    @Then("both products should be displayed in the cart")
    public void both_products_should_be_displayed_in_the_cart() {
        Assert.assertTrue(cartPage.isBackpackDisplayed(),
                "Backpack is not displayed in cart");
        Assert.assertTrue(cartPage.isBoltDisplayed(),
                "Bolt T-Shirt is not displayed in cart");
    }

    @And("I record the prices of the products in the cart")
    public void i_record_the_prices_of_the_products_in_the_cart() {
        double[] prices = cartPage.getProductPrices();
        Assert.assertTrue(prices.length >= 2,
                "Less than two products in cart");
        TestContext.setCartProductPrices(prices);
    }

    @When("I remove the backpack from the cart")
    public void i_remove_the_backpack_from_the_cart() {
        cartPage.removeBackpack();
    }

    @Then("the backpack should not be displayed in the cart")
    public void the_backpack_should_not_be_displayed_in_the_cart() {
        Assert.assertFalse(cartPage.isBackpackDisplayed(),
                "Backpack is still displayed in cart");
    }
}