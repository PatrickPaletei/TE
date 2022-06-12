Feature: feature to test login functionality
  Scenario Outline: Check login with valid credentials
    Given browser opened
    And user in register page
    And user in login page
    When user insert <uname> and <password>
    And login button clicked
    Then user redirect to main screen
    Examples:
    |uname|password|
    |123@gmail.com|123|