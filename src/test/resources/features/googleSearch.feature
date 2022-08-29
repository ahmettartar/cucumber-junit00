@google
Feature: Google Search Functionality
  User Story: Use wants to verify google title verification

  @test1
  Scenario: Google Title Verification
    Given User is on the google page
    When User enter apple into search box
    Then user should see the title of search item

  @test2
  Scenario: Google Title Verification2
    Given User is on the google page
    When User enter turkey into search box
    Then user should see the  turkey title of search item