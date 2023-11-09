@contact-us @regression
Feature: WebDriver University - "Contact Us" Page

  Background:
    Given I access the WebDriver University Contact Us page

  Scenario: Validate successful form submission with unique data
    When I enter an unique first name
    And I enter an unique last name
    And I enter an unique e-mail address
    And I enter an unique comment
    And I click the Submit button
    Then I should be presented with a successful Contact Us form submission message

  Scenario: Validate successful form submission with specific data
    When I enter a specific first name "Joe"
    When I enter a specific last name "Blogs"
    When I enter a specific e-mail address "joe.blogs123@mail.com"
    When I enter a specific comment "How are you?"
    And I click the Submit button
    Then I should be presented with a successful Contact Us form submission message