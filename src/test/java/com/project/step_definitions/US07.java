package com.project.step_definitions;

import com.project.pages.BookPage;
import com.project.pages.DashBoardPage;
import com.project.pages.LoginPage;
import com.project.utils.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.sql.SQLException;

public class US07 {

    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    BookPage bookPage = new BookPage();

    @Given("user login as a student")
    public void user_login_as_a_student() {

        loginPage.login("student");
    }

    @When("user click Borrow Book")
    public void user_click_borrow_book() {

        Select select = new Select(bookPage.showRecordsDropdown);
        select.selectByIndex(6);
        BrowserUtils.sleep(2);
        bookPage.clickOnBorrowBookBtn();
        Assert.assertTrue(bookPage.bookBorrowedMessage.isDisplayed());
    }


    @Then("verify that book is shown in {string} page")
    public void verifyThatBookIsShownInPage(String moduleName) {

        dashBoardPage.moduleSelector(moduleName);
    }

    @And("verify logged student has same book in database")
    public void verifyLoggedStudentHasSameBookInDatabase() throws SQLException {
        bookPage.verifyBookBorrow();
    }
}
