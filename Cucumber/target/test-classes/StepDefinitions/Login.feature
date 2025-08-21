Feature: Login into the NanoHealth
@login
  Scenario: Logging with the valid credentials
    Given User navigates to the NanoHealth web application
    When User enters the email address "Sunilcm@gmail.com"
    And User enters the password "Demo@1234"
    And User clicks on the sign in button
    Then user select the role
    And user successfully loggined with the role
