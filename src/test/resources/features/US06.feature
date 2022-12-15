@db @ui
@us06
Feature: Books module
  As a librarian, I should be able to add new books to the library
  Scenario Outline: Verify added book is matching with DB
    Given I login as a librarian
    And   I navigate to "Books" page
    When  the librarian click to add book
    And   the librarian enter book name "<Book Name>"
    When  the librarian enter ISBN "<ISBN>"
    And   the librarian enter year "<Year>"
    When  the librarian enter author "<Author>"
    And   the librarian choose the book category "<Book Category>"
    And   the librarian click to save changes
    Then  the librarian verify new book by "<Book Name>"
    Then  the librarian verify new book from database by "<Book Name>"
    Examples:
      | Book Name             | ISBN     | Year | Author          | Book Category        |
      | Clean Code            | 09112021 | 2021 | Robert C.Martin | Drama                |
      | Head First Java       | 10112021 | 2021 | Kathy Sierra    | Action and Adventure |
      | The Scrum Field Guide | 11112021 | 2006 | Mitch Lacey     | Short Story          |