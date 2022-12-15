package com.project.step_definitions;

import com.project.pages.BookPage;
import com.project.pages.LoginPage;
import com.project.utils.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.lang.module.Configuration;

public class US07_StepDefs {

    LoginPage loginPage = new LoginPage();
    BookPage bookPage = new BookPage();

    @Given("I login as a student")
    public void i_login_as_a_student() {
        loginPage.login(ConfigurationReader.getProperty("student_username"), ConfigurationReader.getProperty("passwordStudent"));

    }
    @Given("I search book name called {string}")
    public void i_search_book_name_called(String bookName) {
       bookPage.search.sendKeys(bookName);
    }
    @When("I click Borrow Book")
    public void i_click_borrow_book() {

    }
    @Then("verify that book is shown in {string} page")
    public void verify_that_book_is_shown_in_page(String string) {

    }
    @Then("verify logged student has same book in database")
    public void verify_logged_student_has_same_book_in_database() {

    }
}
