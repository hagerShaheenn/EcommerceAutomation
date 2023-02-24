@UItest
Feature: wishList

  Scenario: Logged user could add different products to compare list
    Given user  logged  in  successfuly
    When user select cell phones sub  category
    And user add phone to wishlist
    And user select  books  category
    And user add books to wishlist
    And user  select  Jewelry category
    And user  add Jewelry to wishlist
    Then list  of products added to wishlist




