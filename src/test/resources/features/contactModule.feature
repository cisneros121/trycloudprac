
Feature: As a user, I should be able to access to Contacts module.
  Scenario:  verify user access to Talks module
    Given user on the dashboard page
    When the user clicks the "Talk" module
    Then verify the page title is "Contacts - Trycloud QA"

  Scenario:  verify users can see all the contact names on the contact list
    Given user on the dashboard page
    When the user clicks the "Contacts" module
    Then verify the contact names are in the list