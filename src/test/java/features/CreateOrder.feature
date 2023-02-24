@UItest
Feature: Create Order

  Scenario: Create successful Order
    Given user   logged  in  successfuly
    When user select   books  category
    And user add to cart
    And user click on shopping cart
    And user agree the terms and click on checkout
    And user  enter required data
    Then Message of Your order has been successfully processed! appear




