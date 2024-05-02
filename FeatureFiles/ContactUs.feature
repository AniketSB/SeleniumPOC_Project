@WIP
Feature: Contact Us feature

  Background:
    Given User launch a browser

  Scenario Outline: Contact Us scenario with different set of data
    Given user navigates to contact us page
    When user fills the form from given sheetname "<Name>" and rownumber "<Email>" and "<Subject>" and "<Message>"
    And user clicks on submit button
    Then it shows a successful message "Success! Your details have been submitted successfully."
    And User close a browser

    Examples:
      | Name   | Email            | Subject   | Message               |
      | Peter  | peter@gmail.com  | Feedback  | Product is good       |
      | Mark   | mark@gmail.com   | Feedback2 | Product is defective  |
#      | Joseph | joseph@gmail.com | Feedback3 | Product is old        |
#      | Tina   | tina@gmail.com   | Feedback4 | Product is not worthy |
#      | Rahul  | rahul@gmail.com  | Feedback5 | Product is expensive  |