package com.project.step_definitions;

import com.project.pages.*;
import com.project.utils.BrowserUtils;
import com.project.utils.DB_Util;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;


public class TS7_171_TotalNumberOfBookEntries extends BasePage {

    LoginPage loginPage = new LoginPage();
    UsersPage usersPage = new UsersPage();
    DashBoardPage dashBoardPage = new DashBoardPage();


    @Given("I login as a librarian {string} and {string}")
    public void i_login_as_a_librarian_and(String email, String password) {
        BrowserUtils.waitFor(2);
        loginPage.login(email, password);
        loginPage.loginButton.click();


    }

    @When("I navigate to the {string} page")
    public void i_navigate_to_the_page(String menuOption) {

        iterItemList(menuOption);


    }

    @And("I select {string} category from dropdown")
    public void iSelectCategoryFromDropdown(String userCategory) {

        Select select = new Select(usersPage.userCategory);

        select.selectByVisibleText("Librarian");


    }

    @And("I scroll down and verify total number of active Librarian")
    public void iScrollDownAndVerifyTotalNumberOfActiveLibrarian() {

        String verifyBookInfo = usersPage.userInfoCount.getText();
        System.out.println(verifyBookInfo);
        BrowserUtils.sleep(2);


    }

    @Then("verify that total active Librarian in the database")
    public void verifyThatTotalActiveLibrarianInTheDatabase() {
        DB_Util.runQuery("select count(*) from users where user_group_id = 2 and status = 'Active'");
        String expectedTotalLibrarian = DB_Util.getFirstRowFirstColumn();
        boolean actualTotalLibrarian = usersPage.userInfoCount.getText().contains(expectedTotalLibrarian);
        Assert.assertTrue(expectedTotalLibrarian, actualTotalLibrarian);
        System.out.println("Expected total active Librarian from Database= " + expectedTotalLibrarian + "\nActual total active Librarian from UI= " + actualTotalLibrarian);

        logOut();

    }


}
