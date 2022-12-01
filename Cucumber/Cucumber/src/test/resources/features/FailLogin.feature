Feature: Fail login

  Background: The browser is open
    Given Launch the browser
    Given Maximize the browser window
    Given Open automation practice
    Given Navigate to Sign in page

  Scenario: Validate user can't login with invalid credentials
    When User enters "<email>" in email field
    And User enters "<password>" in password field
    And User clicks on Sign in button
    Then Error message is displayed "<nekaPoruka>"

  Examples:
    | email | password | nekaPoruka |
    | nekiemail@mejl.com | nekipassword123 | There is 1 error\nAuthentication failed. |
