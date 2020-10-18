package com.automationpractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PolicyHolderDetailsPage extends PageBase {

    @FindBy(xpath = "//input[@id='DriversAddPniDetails_embedded_questions_list_Gender_M']")
    private WebElement genderMale;
    @FindBy(id = "DriversAddPniDetails_embedded_questions_list_MaritalStatus")
    private WebElement maritalStatus;
    @FindBy(id = "DriversAddPniDetails_embedded_questions_list_HighestLevelOfEducation")
    private WebElement highestLevelOFEducation;
    @FindBy(id = "DriversAddPniDetails_embedded_questions_list_EmploymentStatus")
    private WebElement employmentStatus;
    @FindBy(xpath = "//input[@id='DriversAddPniDetails_embedded_questions_list_Occupation']")
    private WebElement occupation;
    @FindBy(id = "DriversAddPniDetails_embedded_questions_list_PrimaryResidence")
    private WebElement primaryResidence;
    @FindBy(id = "DriversAddPniDetails_embedded_questions_list_HasPriorAddress")
    private WebElement last2Months;
    @FindBy(id = "DriversAddPniDetails_embedded_questions_list_DriverYearsLicensed")
    private WebElement yearsLicensed;
    @FindBy(id = "DriversAddPniDetails_embedded_questions_list_HasAccidentsOrClaims_N")
    private WebElement selectAccidentAsNo;
    @FindBy(id = "DriversAddPniDetails_embedded_questions_list_HasTicketsOrViolations_N")
    private WebElement selectViolationsAsNo;
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    private WebElement continueButton;

    public PolicyHolderDetailsPage(){
        super();
        PageFactory.initElements(driver, this);
    }

    public void selectMaleGender(){
        delayFor(3000);
        jsClick(genderMale);
    }

    public void provideCustomerInformation(){
        selectMaleGender();
        selectByValue(maritalStatus, "S");
        selectByValue(highestLevelOFEducation, "6");
        selectByValue(employmentStatus, "EM");
        delayFor(2000);
        typeText(occupation, "Economist");
        selectByValue(primaryResidence, "H");
        selectByValue(last2Months, "N");
        delayFor(2000);
        selectByValue(yearsLicensed, "3");
        click(selectAccidentAsNo);
        jsClick(selectViolationsAsNo);
        click(continueButton);
        isElementDisplayed(continueButton, 10);
        click(continueButton);
        isElementDisplayed(continueButton, 10);
        click(continueButton);
    }
}
