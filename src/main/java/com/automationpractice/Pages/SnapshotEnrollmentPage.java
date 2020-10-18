package com.automationpractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SnapshotEnrollmentPage extends PageBase{

    @FindBy(id = "SnapshotEnrollment40Edit_embedded_questions_list_SnapshotPolicyEnrollment_N")
    private WebElement selectSnapShotAsNo;
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    private WebElement continueButton;
    @FindBy(xpath = "//button[contains(text(),'No thanks, just auto')]")
    private WebElement selectJustAuto;
    @FindBy(xpath = "//h1[@class='text']")
    private WebElement quoteSummary;
    @FindBy(xpath = "//*[contains(text(),'Name Your Price')]")
    private WebElement nameOfPriceTool;

    public SnapshotEnrollmentPage(){
        super();
        PageFactory.initElements(driver, this);
    }

    public void enrollToSnapshot(){
        delayFor(2000);
        click(selectSnapShotAsNo);
        click(continueButton);
        delayFor(2000);
        click(selectJustAuto);
    }

    public void enrollToSnapshotForHome(){
        delayFor(2000);
        click(selectSnapShotAsNo);
        click(continueButton);
    }

    public void verifyHeaderMessage(){
        isElementDisplayed(nameOfPriceTool, 30);
        verifyPageTitle("Quote");
    }
}
