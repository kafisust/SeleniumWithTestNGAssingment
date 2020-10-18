package com.automationpractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProgressiveHomePage extends PageBase{

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    private WebElement noResultFound;
    @FindBy(xpath = "//a[@data-qs-product='AU']")
    private WebElement autoInsurance;
    @FindBy(id = "zipCode_overlay")
    private WebElement zipInputBox;
    @FindBy(id = "qsButton_overlay")
    private WebElement getQuoteButton;
    //@FindBy(xpath = "//a[@data-qs-product='AU+H']")
    //private WebElement autoHomeInsurance;
    @FindBy(xpath = "//a[contains(text(),'Auto + Home')]")
    private WebElement autoHomeInsurance;
    @FindBy(xpath = "//a[@data-qs-product='BU-SP']")
    private WebElement bundleInsurance;
    @FindBy(xpath = "//img[@src='https://www.progressive.com/Content/images/DomainProgressive/wh3/base/icons/more-choices.svg']")
    private WebElement seeAll;

    public ProgressiveHomePage(){
        super();
        PageFactory.initElements(driver, this);
    }

    public void navigateToAutoInsurance(){
        scrollToElement(autoInsurance);
        click(autoInsurance);
    }

    public void navigateToAutoAndHomeInsurance(){
        scrollToElement(seeAll);
        click(seeAll);
        delayFor(300);
        click(autoHomeInsurance);
    }

    public void navigateBundleInsurance(){
        scrollToElement(bundleInsurance);
        click(bundleInsurance);
    }

    public void navigateToNameAndAddressPage(){
        typeText(zipInputBox, "75063");
        click(getQuoteButton);
    }
}
