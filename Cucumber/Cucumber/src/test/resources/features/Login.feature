Feature: Login

  Background: The browser is open
    Given Launch the browser
    Given Maximize the browser window
    Given Open automation practice
    Given Navigate to Sign in page

  Scenario: Validate user can login with valid credentials
    When User enters "gregg.kassulke@yahoo.co" in email field
    And User enters "m23nm3c0z30whf" in password field
    And User clicks on Sign in button
    Then User is logged in