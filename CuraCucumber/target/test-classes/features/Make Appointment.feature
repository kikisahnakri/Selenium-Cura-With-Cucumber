@MakeAppointment @SmokeTest
Feature:Make Appointment
  As a user
  I want to make an appointment
  So that I can receive confirmation medical services/booking confirmation

  Background:
    Given I am on the login page

  @TC_2.1
  Scenario Outline: TC 2.1 User Makes Appointment - without inputting mandatory field
    When I input valid username "<username>" and valid password "<password>"
    And I click the login button
    Then I should be redirected to the home page (Make Appointment)
    And I click the button Make Appointment
    Then I should see form Make Appointment
    And I clik Hongkong CURA Healthcare Center on facility
    And I click the checkbox on Apply for hospital readmission
    And I click the radio button Medicaid on Healthcare Program
    And I leave the date field empty
    And I input comment "<comment>"
    When I click the make appointment button
    Then I should see an error "<message>" indicating the date field is required
    Examples:
      | username  | password           | comment              |message                    |
      | John Doe  | ThisIsNotAPassword | ini comment Hongkong |Please fill out this field.|


  @TC_2.2
  Scenario Outline: TC 2.2 User Make Appointment - Success
    When I input valid username "<username>" and valid password "<password>"
    And I click the login button
    Then I should be redirected to the home page (Make Appointment)
    And I click the button Make Appointment
    Then I should see form Make Appointment
    And I clik Hongkong CURA Healthcare Center on facility
    And I click the checkbox on Apply for hospital readmission
    And I click the radio button Medicaid on Healthcare Program
    And I input the date "<date>"
    And I input comment "<comment>"
    When I click the make appointment button
    Then I should be redirected to the Appointment Confirmation page
    Examples:
      | username  | password           |date       | comment                 |
      | John Doe  | ThisIsNotAPassword |18/06/2024 |ini comment untuk testing|