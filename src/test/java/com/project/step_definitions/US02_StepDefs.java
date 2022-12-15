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

public class US02_StepDefs {

    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();

    String expectedBookBorrowed;

    @Given("user login as a {string}")
    public void user_login_as_a(String userName) {
        loginPage.login(userName);
        BrowserUtils.sleep(3);

    }
    @When("user take borrowed books number")
    public void user_take_borrowed_books_number() {
        expectedBookBorrowed = dashBoardPage.borrowedBooksNumber.getText();

    }
    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {
            String query = "select count(*) from book_borrow\n" +
                    "where is_returned=0";
        DB_Util.runQuery(query);

        String actualBookBorrowed= DB_Util.getFirstRowFirstColumn();

        Assert.assertEquals(expectedBookBorrowed, actualBookBorrowed);

    }
}
