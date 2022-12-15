package com.project.step_definitions;

import com.project.pages.DashBoardPage;
import com.project.pages.LoginPage;
import com.project.utils.BrowserUtils;
import com.project.utils.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US02StepDefs  {


    String actualBorrowedBookNumbers;
    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();

    @Given("user login as a {string}")
    public void user_login_as_a(String userType) {
        loginPage.login(userType);
        BrowserUtils.waitFor(3);

    }
    @When("user take borrowed books number")
    public void user_take_borrowed_books_number() {
        actualBorrowedBookNumbers =dashBoardPage.borrowedBooksNumber.getText();
        System.out.println("actualBorrowedBookNumbers = " + actualBorrowedBookNumbers);


    }
    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {

        DB_Util.runQuery("select count(*) as borrowedBooks from users u\n" +
                "inner join book_borrow b on u.id = b.user_id where is_returned = 0");


        String expectedBorrowedBooks = DB_Util.getFirstRowFirstColumn();

        Assert.assertEquals(expectedBorrowedBooks,actualBorrowedBookNumbers);



    }

}