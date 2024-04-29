Scenario Outline: UFT to Selenium migration

Scenario:LOGIN
Given User clicks on GUEST Button
  # click
When User visit  LOG IN REGISTER
Then User Select LOG IN
And User reads excel sheet 'Login-teste'
Then User enter USERNAME and PASSWORD
And Click on SIGN IN button
Then User validates LOGOUT button after successful login
And User clicks on GUEST button
And User SELECTS LOG IN from LOG IN REGISTER Menu


#  Scenario: Login with correct credentials
#    Given user is on login page
#    When user enters username "demoPoc@gmail.com"
#    And user enters password "12345"
#    And user clicks on Login button
#    Then user gets the title of the page
#    And user verify logout button
#    And page title should be "Automation Exercise"

#  Scenario: Login page title
#    Given user is on login page
#    When user gets the title of the page
#    Then page title should be "Login - My Store"

#  Scenario: Forgot Password link
#    Given user is on login page
#    Then forgot your password link should be displayed

#
#  Scenario Outline: Login with correct credentials
#    Given user is on login page
##    When user enters username "<Testcase>"
##    And user enters password "<Testcase>"
#    When user enters credentials for "<Testcase>" and sheetname "<SheetName>"
#    And user clicks on Login button
#    Then user gets the title of the page
#    And user verify logout button
#    And page title should be "Automation Exercise"
#
#    Examples:
#      | Testcase | SheetName |
#      | TC1      | Login     |
#      | TC2      | Login         |

