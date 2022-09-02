
Feature: Google Search Functionality Title Verification
  User story: As a user, when I am on the Google search page
  I should be able to search whatever I want and see relevant information

  Background:
    Given User is on Google search page

  @test365
  Scenario: Search functionality result title verification
    When User types "amazon" in the google search box and clicks enter
    Then User sees "amazon - Google Search" is in the google title

    # "apple" seklinde eklenen {string} olarak step-defintionda gorunmektedir.
  # @When("User types {string} in the google search box and clicks enter")
  # Boylece bunu parametre olorak metod icinde gireriz.


  @dataTable
  Scenario: User searches for multiple items
    Then User should be able to search for following:
      | java         |
      | selenium     |
      | cucumber bdd |
      | data driven  |
      | wooden spoon |

# option + Command + L
# CTRL+ALT+L

  @google_scenario_outline
  Scenario Outline: Google capital cities search
    When User searches for "<country>" capital
    Then User should see "<capital>" in the result
    Examples:
      | country     | capital          |
      | AZERBAIJAN  | Baku             |
      | Tajikistan  | Dushanbe         |
      | Bulgaria    | Sofia            |
      | Ukraine     | Kyiv             |
      | Afghanistan | Kabul            |
      | USA         | Washington, D.C. |
      | TURKEY      | Ankara           |
      | Germany     | Berlin           |