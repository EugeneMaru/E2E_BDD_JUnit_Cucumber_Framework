@us02
Feature: As a librarian, I want to know borrowed books number

  Scenario: verify the total amount of borrowed books
    Given user login as a "librarian"
    When  user take borrowed books number
    Then  borrowed books number information must match with DB