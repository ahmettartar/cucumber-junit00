@bear2
Feature:  Order process with scenario outline
  User Story: As a user, I should be able to place order

    # SCENARIO OUTLiNE
#  TC#5: SmartBear order process (Same runner file, same page file, same steps-definitions file.
#  Changes just in feature file in order to run a loop for 8 people)

  @bear2 @OrderOutline
  Scenario Outline: As a user I should see myself on the list after placing an order
    #public void userIsLoggedIntoSmartBearTesterAccountAndOnOrderPage(Map<String, String> credentials)
    Given user is logged into SmartBear Tester account and on Order page
      | Username | Tester |
      | Password | test   |
    When user fills out the form as followed:
    And user selects "<product>" from product dropdown
    Then user enters <quantity> to quantity
    And user enters "<customer name>" to costumer name
    Then user enters "<street>" to street
    And user enters "<city>" to city
    Then user enters "<state>" to state
    And user enters <zip>
    Then user selects "<cardType>" as card type
    And user enters "<card number>" to card number
    Then user enters "<expiration date>" to expiration date
    When user clicks process button
    Then user verifies "<expected name>" is in the list
    Examples:
      | product     | quantity | customer name   | street      | city        | state | zip   | cardType | card number   | expiration date | expected name   |
      | MyMoney     | 1        | Ken Adams       | Kinzie st   | Chicago     | IL    | 60004 | Visa     | 313313133315  | 12/22           | Ken Adams       |
      | FamilyAlbum | 4        | Joey Tribbiani  | State st    | Chicago     | IL    | 60656 | Visa     | 123433533336  | 11/22           | Joey Tribbiani  |
      | ScreenSaver | 5        | Rachel Green    | Michigan st | Chicago     | IL    | 60056 | Visa     | 335333333337  | 10/22           | Rachel Green    |
      | MyMoney     | 5        | Chandler Bing   | Erie st     | Chicago     | IL    | 60666 | Visa     | 4333353333338 | 10/22           | Chandler Bing   |
      | FamilyAlbum | 9        | Dr DrakeRamoray | Dale st     | Arl Hgths   | IL    | 60452 | Visa     | 5323333353334 | 10/22           | Dr DrakeRamoray |
      | ScreenSaver | 10       | Monica Geller   | Euclid ave  | Arl Hgths   | IL    | 60312 | Visa     | 733533333333  | 10/22           | Monica Geller   |
      | MyMoney     | 3        | Ross Geller     | River rd    | Des Plaines | IL    | 60666 | Visa     | 833435363732  | 10/22           | Ross Geller     |
      | MyMoney     | 1        | Ken Adams       | Kinzie st   | Chicago     | IL    | 60312 | Visa     | 933533333531  | 12/22           | Ken Adams       |