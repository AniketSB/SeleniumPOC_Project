Feature: : UFT to Selenium migration

Scenario:LOGIN
Given User clicks on GUEST Button
When User visit  LOG IN REGISTER
Then User Select LOG IN
And User reads excel sheet 'Login-teste'
Then User enter USERNAME and PASSWORD
And Click on SIGN IN button
Then User validates LOGOUT button after successful login
And User clicks on GUEST button
And User SELECTS LOG IN from LOG IN REGISTER Menu
