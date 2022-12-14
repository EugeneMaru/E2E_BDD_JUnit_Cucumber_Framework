package com.project.pages;

import com.project.utils.BrowserUtils;
import com.project.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * parent class for concrete Page object classes
 * provides constructor with initElements method for re-usability
 * abstract - to prevent instantiation.
 */
public abstract  class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//span[@class='title'][.='Users']")
    public WebElement users;

    @FindBy(xpath = "//span[@class='title'][.='Dashboard']")
    public WebElement dashboard;

    @FindBy(xpath = "//span[@class='title'][.='Books']")
    public WebElement books;

    @FindBy(tagName = "h3")
    public WebElement pageHeader;

    @FindBy(css = "#navbarDropdown>span")
    public WebElement accountHolderName;

    @FindBy(linkText = "Log Out")
    public WebElement logOutLink;

    @FindBy(xpath = "//ul[@id='menu_item']//li")
    public List<WebElement> buttonBar;

    @FindBy(xpath = "//i[@class='fa fa-book']")
    public WebElement staleElement;
    public void logOut(){
        accountHolderName.click();
        logOutLink.click();
    }

    public void navigateModule(String moduleName){
        Driver.getDriver().findElement(By.xpath("//span[@class='title'][.='"+moduleName+"']")).click();
    }
    public void iterItemList(String menuOption) {

        for (int i = 1; i < buttonBar.size(); i++) {
            BrowserUtils.hover(buttonBar.get(i));

            if (buttonBar.get(i).getText().contains(menuOption)) {
                BrowserUtils.clickElement(buttonBar.get(i));
                BrowserUtils.waitFor(3);
                break;
            }

        }

    }



}
