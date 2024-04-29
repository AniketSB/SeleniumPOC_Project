Feature:User Sign Up

  Scenario Outline: User Register to avail benefits
    Given User visits a page
    When User enters username as "<username>" and password as "<password>"

    Examples:
      | username                     | password       |
      | automationExercise@gmail.com | Automation@123 |