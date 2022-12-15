package com.project.pages;

import com.project.utils.BrowserUtils;
import com.project.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashBoardPage extends BasePage
{


    @FindBy(id = "borrowed_books")
    public WebElement borrowedBooksNumber;

    @FindBy(id = "user_count")
    public WebElement usersNumber;

    @FindBy(id = "book_count")
    public WebElement booksNumber;

    @FindAll(@FindBy(css = "#navbarCollapse li .title"))
    public List<WebElement> allModuleNames;

    @FindBy(css = "#navbarCollapse li[class='nav-item'] a")
    public List<WebElement> allModules;



    public String getModuleCount(String module){
        //h6[normalize-space(.)='Users']//..//h2

        String locator="//h6[normalize-space(.)='"+module+"']//..//h2";

        WebElement elementOfModule = Driver.getDriver().findElement(By.xpath(locator));

        return elementOfModule.getText();
    }

    public void moduleSelector(String moduleName) {
        for (int i = 0; i < allModuleNames.size(); i++) {
            if (allModuleNames.get(i).getText().equals(moduleName)) {
                allModules.get(i).click();
                BrowserUtils.sleep(2);
            }
        }
    }

}
