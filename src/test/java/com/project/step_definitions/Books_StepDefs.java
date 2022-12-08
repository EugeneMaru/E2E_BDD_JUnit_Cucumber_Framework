package com.project.step_definitions;

import com.project.pages.BasePage;
import com.project.pages.BookPage;
import com.project.pages.LoginPage;
import com.project.utils.BrowserUtils;
import com.project.utils.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class Books_StepDefs extends BasePage {

    LoginPage loginPage = new LoginPage();
    BookPage bookPage = new BookPage();



    @Given("user login as a librarian")
    public void user_login_as_a_librarian() {
        loginPage.login("librarian");
    }
    @Given("I navigate to {string} page")
    public void i_navigate_to_page(String string) {
        navigateModule(string);
    }
    @When("I open book {string}")
    public void i_open_book(String bookName) {
        BrowserUtils.waitForClickability(bookPage.search, 5).sendKeys(bookName);
        BrowserUtils.waitForClickability(bookPage.editBook(bookName), 5).click();

    }
    @Then("book information must match the Database")
    public void book_information_must_match_the_database() {
        String actualBookName = bookPage.bookName.getAttribute("value");
        String actualAuthorName = bookPage.author.getAttribute("value");
        String actualISBN=bookPage.isbn.getAttribute("value");
        String actualYear = bookPage.year.getAttribute("value");
        String actualDesc = bookPage.description.getAttribute("value");

        String query="select name,isbn,author,description,year from books where name='Chordeiles minor'";

        Map<String, String> bookInfo = DB_Util.getRowMap(1);

        String expectedBookName = bookInfo.get("name");
        String expectedAuthorName = bookInfo.get("author");
        String expectedISBN = bookInfo.get("isbn");
        String expectedYear = bookInfo.get("year");
        String expectedDesc = bookInfo.get("description");

        Assert.assertEquals(expectedBookName,actualBookName);
        Assert.assertEquals(expectedAuthorName,actualAuthorName);
        Assert.assertEquals(expectedISBN,actualISBN);
        Assert.assertEquals(expectedYear,actualYear);
        Assert.assertEquals(expectedDesc,actualDesc);
    }
}
