Feature: test user should able to see in interviewdashboard

  @tag1
  Scenario Outline: test successful user should able to see in interviewdashboard
    Given user on home page
    When click login button and enter the valid details "<email>" and "<password>"
    And click on upcoming slot button
    And click on cancelled button
    And click on past slot button
    Then successfully user should able to see the slots

    Examples: 
      | email                | password |
      | pradhap234@gmail.com | 1234.ak  |
