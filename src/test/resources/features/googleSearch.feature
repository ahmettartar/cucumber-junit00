@smoke
Feature: Google Search Functionality
  User Story: Use wants to verify google title verification

  Background:
    Given User is on the google page

  @test1
  Scenario: Google Title Verification
    When User enter apple into search box
    Then user should see the title of search item

  @test1 @test2
  Scenario: Google Title Verification2
    When User enter turkey into search box
    Then user should see the  turkey title of search item