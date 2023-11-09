@login-portal @regression
Feature: WebDriver University - "Login Portal" Page

  Background:
    Given I access the WebDriver University Login Portal page

  @smoke
  Scenario: Validate login with valid credentials
    When I enter "webdriver" in the username input field
    And I enter "webdriver123" in the password input field
    And I click the Login button
    Then I should be presented with an alert with the text "validation succeeded"

  Scenario: Inability to log in with invalid credentials
    And I enter "webdriver1234" in the password input field
    And I click the Login button
    Then I should be presented with an alert with the text "validation failed"

  Scenario Outline: Validate messages for valid and invalid login attempt
    When I enter an username <username>
    And I enter a password <password>
    And I click the Login button
    Then I should be presented with an alert with the message <message>

    Examples:
    | username  | password      | message              |
    | webdriver | webdriver123  | validation succeeded |
    | webdriver | webdriver1234 | validation failed    |
    | webdriver |               | validation failed    |