package com.automationpractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage extends PageBase{

    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    private WebElement searchBar;
    @FindBy(xpath = "//div[@jsname='VlcLAe']//input[@class='gNO89b']")
    private WebElement searchButton;

    public GoogleSearchPage(){
        super();
        PageFactory.initElements(driver, this);
    }

    public void searchItem(String text){
        isElementDisplayed(searchBar, 10);
        typeText(searchBar, text);
        jsClick(searchButton);
    }


}
