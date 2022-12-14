
@smoke @regression
  @TS7-171
Feature: As a librarian, I want to see total number of active Librarian and number is matching with DB
  @db @ui

  Scenario Outline: Verify total number of active Librarian and number is matching with DB
    Given I login as a librarian "<email>" and "<password>"
    When I navigate to the "Users" page
    And I select "Librarian" category from dropdown
    And I scroll down and verify total number of active Librarian
    Then verify that total active Librarian in the database

    Examples:
      | email               | password |
      | librarian50@library | LXHU2DkJ |
      | librarian51@library | vGTWHXgx |
      | librarian52@library | p3c33VSf |
      | librarian53@library | whtQ6kpH |
      | librarian54@library | a6aZeunQ |
      | librarian55@library | 67UQi3Ol |
      | librarian56@library | pBQnq0NN |
      | librarian57@library | SHzFWv8X |
      | librarian58@library | gxiYGKjy |
      | librarian59@library | DmSqxDEJ |
      | librarian60@library | Lj5VU4Tq |


