@WIP
Feature: Login page feature

  Background:
    Given User launch a browser

  Scenario Outline: Login with correct credentials
    Given user is on login page
    When user enters credentials for <TestCaseNumber> and sheetname "<SheetName>"
    And user clicks on Login button
    Then user gets the title of the page
    And page title should be "Automation Exercise"
    And user verify logout button
    And User close a browser

    Examples:
      | TestCaseNumber | SheetName |
      | 1              | Login     |
#      | 2              | Login     |
#      | 3              | Login         |
#
#  Scenario: API calls
#    And user sends and receive api requests