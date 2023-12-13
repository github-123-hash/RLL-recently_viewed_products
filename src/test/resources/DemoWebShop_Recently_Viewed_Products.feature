Feature: Test the Recently viewed product functionality

  Scenario: Recently viewed product Test on page
    Given User navigate to URL
    Then User click on Books link
    When User click on a Book
    Then User go to home page
   	When User click on a featured product
   	And User come to home page
    Then User should able to see that product in Recently viewed product
