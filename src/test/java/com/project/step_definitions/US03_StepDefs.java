package com.project.step_definitions;

import com.project.pages.BookPage;
import com.project.utils.BrowserUtils;
import com.project.utils.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class US03_StepDefs {

    BookPage bookPage = new BookPage();
    List<String> actualCateList;
    List<String>  expectedCateList;

    @When("I take all book categories in UI")
    public void i_take_all_book_categories_in_ui() {
        WebElement categoryElement = bookPage.mainCategoryElement;
        actualCateList = BrowserUtils.dropdownOptionsAsString(categoryElement);
        actualCateList.remove(0);
        System.out.println("UI list ===>" + actualCateList);

    }

    @When("I execute query to get book categories")
    public void i_execute_query_to_get_book_categories() {
        String queary1= "select name from book_categories";
        DB_Util.runQuery(queary1);
        expectedCateList = DB_Util.getColumnDataAsList(1);
        System.out.printf("DB list ===>" + expectedCateList);
    }

    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {
        Assert.assertEquals(expectedCateList,actualCateList);
    }
}
