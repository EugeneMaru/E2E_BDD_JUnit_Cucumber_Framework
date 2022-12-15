package com.project.pages;

import com.project.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookPage extends BasePage {

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> allRows;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement search;

    @FindBy(id = "book_categories")
    public WebElement mainCategoryElement;

    @FindBy(name = "name")
    public WebElement bookName;


    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement author;


    @FindBy(name = "year")
    public WebElement year;

    @FindBy(name = "isbn")
    public WebElement isbn;

    @FindBy(id = "description")
    public WebElement description;

    @FindBy(xpath = "//select[@name='tbl_books_length']")
    public WebElement showRecordsDropdown;

    @FindBy(css = "tbody tr td a")
    public List<WebElement> borrowBookBtnList;

    @FindBy(xpath = "//div[@class='toast toast-success']")
    public WebElement bookBorrowedMessage;

    @FindAll(@FindBy(xpath = "//tbody//tr//td[6]"))
    public List<WebElement> borrowedBooksReturnStatus;

    @FindAll(@FindBy(xpath = "//tbody//tr//td[2]"))
    public List<WebElement> borrowedBookNames;


    public void clickOnBorrowBookBtn() {
        for (WebElement each : borrowBookBtnList) {
            if (!each.getAttribute("class").endsWith("disabled")) {
                each.click();
                break;
            }
        }
    }

    public void verifyBookBorrow() throws SQLException {
        List<String> listOfBorrowedBooksNotReturnedUI = new ArrayList<>();
        for (int i = 0; i < borrowedBooksReturnStatus.size(); i++) {
            if (borrowedBooksReturnStatus.get(i).getText().contains("NOT RETURNED")) {
                listOfBorrowedBooksNotReturnedUI.add(borrowedBookNames.get(i).getText());
            }
        }
    }



    public WebElement editBook(String book) {
        String xpath = "//td[3][.='" + book + "']/../td/a";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }




}
