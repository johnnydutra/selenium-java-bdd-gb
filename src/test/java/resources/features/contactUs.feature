Feature: WebDriver University - "Contact Us" Page

  Scenario: Validate successful form submission - unique data
    Given I access the WebDriver University Contact Us page
    When I enter an unique first name
    And I enter an unique last name
    And I enter an unique e-mail address
    And I enter an unique comment
    And I click the Submit button
    Then I should be presented with a successful Contact Us form submission message