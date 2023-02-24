@UItest
Feature: ShoppingCart

  Scenario: Logged user could add different products to Shopping cart
    Given user  logged in  successfuly
    When user select cell phones sub category
    And user add phone to cart
    And user select  books category
    And user add books to cart
    And user select  Jewelry category
    And user add Jewelry to cart
    Then list  of products added to shopping cart




