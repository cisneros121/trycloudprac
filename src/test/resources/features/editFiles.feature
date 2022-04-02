@smoke
Feature: As a user, I should be able to access to Files module - Favorites button

  Scenario: com.google.common.base.Verify users to add files to Favorites
    Given user on the dashboard page
    When the user clicks the "Files" module
    When the user clicks action-icon  from any file on the page
    And user choose the "Add to favorites" option
    And user click the "Favorites" sub-module on the left side
    Then Verify the chosen file is listed on the table

  Scenario: verify users to remove files to Favorites
    Given user on the dashboard page
    When the user clicks the "Files" module
    When the users click action-icon from any file on the page to remove
    And  user choose the "Remove from favorites" option
    And user click the "Favorites" sub-module on the left side
    Then Verify that the file is removed from the Favorites sub-module’s table



  Scenario: verify users to upload a file from Files
    Given user on the dashboard page
    When the user clicks the "Files" module
    When the user clicks the add icon on the top
    And users uploads file with the “upload file” option
    Then verify the file is displayed on the page
