package com.project.step_definitions;

import com.project.pages.BasePage;
import com.project.pages.DashBoardPage;
import com.project.pages.LoginPage;
import com.project.utils.BrowserUtils;
import com.project.utils.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US02_BorrowedBooksNumber extends BasePage{


    LoginPage loginPage = new LoginPage();
    DashBoardPage dashboardPage = new DashBoardPage();


    String actualBorrowedBooks;
    @Given("user login as a librarian {string} and {string}")
    public void userLoginAsALibrarianAnd(String email, String password) {

        loginPage.login(email, password);
        BrowserUtils.waitFor(2);

    }
    @When("user take borrowed books number")
    public void user_take_borrowed_books_number() {
        actualBorrowedBooks=dashboardPage.borrowedBooksNumber.getText();
        BrowserUtils.waitFor(2);
    }
    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {
        DB_Util.runQuery("select count(*) as borrowedBooks from users u inner join book_borrow b on u.id = b.user_id where is_returned = 0;");

        String expectedBorrowedBooks = DB_Util.getFirstRowFirstColumn();

        Assert.assertEquals(expectedBorrowedBooks, actualBorrowedBooks);
        System.out.println("Actual borrowed books= " + actualBorrowedBooks + "\nExpected borrowed books= " + expectedBorrowedBooks);

        logOut();

    }



}
