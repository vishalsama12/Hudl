@Hudl_Tests
Feature: Hudl Login functionality

  Background:
    Given I launch the chrome browser and navigate to homepage

  Scenario Outline: Login into Hudl <scenario>
    When I enter Username as "<username>" and Password as "<password>"
    Then I should be logged in successfully

    Examples:
      | scenario   | username              | password      |
      | happy flow | vishalsama9@gmail.com | Mounisha12890 |

  Scenario Outline: Login into Hudl <scenario>
    When I enter Username as "<username>" and Password as "<password>"
    Then an error message should be displayed

    Examples:
      | scenario                               | username              | password    |
      | right username and wrong password      | vishalsama9@gmail.com | Mounisha128 |
      | wrong username and wrong password      | vishalsam9@gmail.com  | Mounisha128 |
      | without entering username and password |                       |             |
