package com.automationpractice.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BoltProgressivePage extends PageBase {

    @FindBy(id = "PolicyData_FirstName")
    private WebElement firstName;
    @FindBy(id = "PolicyData_EffectiveDate1")
    private WebElement policyDate;
    @FindBy(xpath = "//span[contains(text(),'Next')]")
    private WebElement nextBtn;
    @FindBy(xpath = "//*[contains(text(),'Home Basics')]")
    private WebElement homeBasicText;
    @FindBy(id = "PolicyData_YearsAtAddress")
    private WebElement policyDateYear;
    @FindBy(id = "PolicyData_PLTypeOfDwelling")
    private WebElement homeStyle;
    @FindBy(xpath = "//span[contains(text(),'Single Family House')]")
    private WebElement singleFamily;
    @FindBy(id = "PolicyData_PreviousAddress_AddressLine1")
    private WebElement priorAddress;
    @FindBy(id = "PolicyData_PreviousAddress_ZipCode")
    private WebElement zipCode;
    @FindBy(id = "PolicyData_PreviousAddress_City")
    private WebElement city;
    @FindBy(id = "PolicyData_PreviousAddress_State")
    private WebElement state;
    @FindBy(xpath = "//*[@class='custom-input']")
    private List<WebElement> answers;
    @FindBy(xpath = "//*[@class='undefined col-undefined ng-star-inserted']")
    private List<WebElement> structureAnswers;
    @FindBy(xpath = "//*[@class='image']")
    private List<WebElement> selectImage;
    @FindBy(id = "PolicyData_PrimaryPhoneNumber")
    private WebElement primaryPhoneNumber;
    @FindBy(id = "PolicyData_PurchaseDate")
    private WebElement purchaseDate;
    @FindBy(id = "PolicyData_DateOccupied")
    private WebElement homeOccupied;
    @FindBy(xpath = "//span[@aria-label='Number of home insurance claims in the last 5 years']")
    private List<WebElement> numberOfClaims;
    @FindBy(xpath = "//span[@aria-label='Would you rather talk to an expert or buy online?']")
    private List<WebElement> talkToExpert;
    @FindBy(xpath = "//span[@aria-label='Would you prefer a lower price or more coverage?']")
    private List<WebElement> preferPrice;
    @FindBy(id = "PolicyData_PLPersonalProperty")
    private WebElement propertyCoverage;
    @FindBy(xpath = "//button[@gtm='Ok_Show_Rates']/span")
    private WebElement showRatesButton;


    public BoltProgressivePage(){
        super();
        PageFactory.initElements(driver, this);
    }

    public void provideQuickQuestionAnswer(){
        isElementDisplayed(firstName, 20);
        typeText(firstName, "Automation123");
        typeText(policyDate, "11/20/2020");
        jsClick(nextBtn);
    }

    public void provideHomeBasicInfo(){
        isElementDisplayed(homeBasicText, 30);
        verifyText(homeBasicText, "Home Basics");
        typeText(policyDateYear, "1");
        typeText(priorAddress, "100 fuller wiser road");
        typeText(zipCode, "76039");
        delayFor(300);
        click(homeStyle);
        click(singleFamily);
    }

    public void provideAnswers(){
        driver.findElement(By.xpath("//input[@id='PolicyData_RoofResponsible_true']//following::span[1]")).click();
        click(answers.get(2));
        click(answers.get(5));
        click(answers.get(7));
        delayFor(300);
        click(nextBtn);
        delayFor(2000);
    }

    public void provideStructureAnswer(){
        delayFor(1000);
        driver.findElement(By.id("PolicyData_PLYearBuilt")).sendKeys("2018");
        driver.findElement(By.id("PolicyData_PLSquareFootage")).sendKeys("2018");
        click(nextBtn);
        delayFor(3000);
        click(nextBtn);
        delayFor(2000);
        click(nextBtn);
    }

    public void providerUtilities(){
        delayFor(3000);
        click(answers.get(1));
        click(answers.get(2));
        click(selectImage.get(0));
        click(selectImage.get(6));
        delayFor(1000);
        click(nextBtn);
        delayFor(3000);
    }

    public void provideOwnerInfo(){
        delayFor(1000);
        click(answers.get(1));
        typeText(primaryPhoneNumber, "5555555555");
        click(answers.get(5));
        typeText(purchaseDate, "10/12/2020");
        typeText(homeOccupied, "10/30/2020");
        click(numberOfClaims.get(0));
        click(talkToExpert.get(0));
        click(preferPrice.get(0));
        typeText(propertyCoverage, "50000");
        click(showRatesButton);
        delayFor(3000);
    }
}
