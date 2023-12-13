#Author: asish.patra@mphasis.com

Feature: Test the Wishlist functionality

  Scenario: Wishlist Test on page
    Given User navigate to the URL
    When User click on digital downloads tab
    Then User click on the first product
    And User should able to first product see Add to Wishlist button
    And User click on first product Add to wishlist button
    And User should see the success message for first product
    And User click on digital download tab for second time
    When User click on the second available product
    Then User should able to see second products Add to Wishlist button
    And User click on second products Add to wishlist button
    And User click on digital download tab for third time
    When User click on the third available product
    Then User should able to see third products Add to Wishlist button
    And User click on third products Add to wishlist button
    And User click on Wishlist link
    And User click on first products remove check box
    And User click on second products remove check box
    And User click on third products remove check box
    When User click on Upadate wishlist button
    Then User should able to see empty message
