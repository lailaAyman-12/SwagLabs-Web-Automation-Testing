Feature: Swag Labs main flow
  This feature validates the main functionalities of Swag Labs including login,
  product selection, cart operations, checkout, logout, and negative scenarios.

  @smoke
  Scenario: Verify that user can log in successfully
    Given I am on the Swag Labs login page
    When I login with valid credentials
    Then I should be redirected to the Products page

  @smoke
  Scenario: Add first product to cart
    Given I am on the Swag Labs login page
    When I login with valid credentials
    And I add the backpack to the cart
    And I open the cart
    Then the backpack should be displayed in the cart

  @regression
  Scenario: Add second product to cart
    Given I am on the Swag Labs login page
    When I login with valid credentials
    And I add the backpack to the cart
    And I open the cart
    When I click continue shopping
    And I add the bolt t-shirt to the cart
    And I open the cart
    Then both products should be displayed in the cart

  @regression
  Scenario: Verify total price calculation and complete checkout
    Given I am on the Swag Labs login page
    When I login with valid credentials
    And I add the backpack to the cart
    And I add the bolt t-shirt to the cart
    And I open the cart
    And I record the prices of the products in the cart
    When I proceed to checkout
    And I fill in the checkout information
    Then the item total should equal the sum of product prices
    And I click finish to complete the purchase
    Then a thank you message should be displayed

  @smoke
  Scenario: Verify logout functionality
    Given I am on the Swag Labs login page
    When I login with valid credentials
    And I logout from the application
    Then I should be redirected back to the login page

  @regression
  Scenario: Invalid login credentials
    Given I am on the Swag Labs login page
    When I login with invalid credentials
    Then an invalid login error message should be displayed

  @regression
  Scenario: Locked out user
    Given I am on the Swag Labs login page
    When I login with a locked out user
    Then a locked out error message should be displayed

  @regression
  Scenario: Checkout with missing information
    Given I am on the Swag Labs login page
    When I login with valid credentials
    And I add the backpack to the cart
    And I open the cart
    When I proceed to checkout
    And I try to continue checkout with missing first name
    Then a first name required error should be displayed

  @regression
  Scenario: Remove item from cart
    Given I am on the Swag Labs login page
    When I login with valid credentials
    And I add the backpack to the cart
    And I open the cart
    When I remove the backpack from the cart
    Then the backpack should not be displayed in the cart