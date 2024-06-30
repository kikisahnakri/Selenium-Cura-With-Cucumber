@Login @SmokeTest
Feature:Login
  As a user
  I want to login
  So that I can access the all of features

  Background:
    Given I am on the login page


  @TC_1.1
  Scenario Outline: TC 1.1 User login with invalid data
    When I input invalid username "<username>" and invalid password "<password>"
    And I click the login button
    Then I should see an error message "<message>"
    Examples:
      | username        | password          | message                                                               |
      | invalidUsername | invalidPass123$   | Login failed! Please ensure the username and password are valid.      |

  @TC_1.2
  Scenario Outline: TC 1.2 User login with valid data
    When I input valid username "<username>" and valid password "<password>"
    And I click the login button
    Then I should be redirected to the home page (Make Appointment)
    Examples:
      | username  | password          |
      | John Doe  | ThisIsNotAPassword|