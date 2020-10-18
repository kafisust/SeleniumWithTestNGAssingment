package com.automationpractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdditionalDetailsPage extends PageBase{

    @FindBy(id = "FinalDetailsEdit_embedded_questions_list_InsuranceToday_Y")
    private WebElement selectAutoInsuranceAsYes;
    @FindBy(id = "FinalDetailsEdit_embedded_questions_list_RecentAutoInsuranceCompanyPeriod")
    private WebElement currentCompanyDuration;
    @FindBy(id = "FinalDetailsEdit_embedded_questions_list_BodilyInjuryLimits")
    private WebElement bodyInjuryLimits;
    @FindBy(id = "FinalDetailsEdit_embedded_questions_list_OtherPolicies_N")
    private WebElement nonAutoPolicy;
    @FindBy(id = "FinalDetailsEdit_embedded_questions_list_PriorProgressive_N")
    private WebElement priorProgressiveAsNo;
    @FindBy(id = "FinalDetailsEdit_embedded_questions_list_AdvancedShopperPolicyEffectiveDate")
    private WebElement policyStartDate;
    @FindBy(id = "FinalDetailsEdit_embedded_questions_list_PrimaryEmailAddress")
    private WebElement primaryEmailAddress;
    @FindBy(id = "FinalDetailsEdit_embedded_questions_list_TotalResidents")
    private WebElement numberOfResidents;
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    private WebElement continueButton;

    public AdditionalDetailsPage(){
        super();
        PageFactory.initElements(driver, this);
    }

    public void provideAutoInsuranceHistory(){
        delayFor(2000);
        click(selectAutoInsuranceAsYes);
        delayFor(500);
        selectByValue(currentCompanyDuration, "D");
        delayFor(300);
        selectByValue(bodyInjuryLimits, "4");
    }

    public void provideProgressiveInsuranceInfo(){
        click(nonAutoPolicy);
        click(priorProgressiveAsNo);
    }

    public void provideAdditionalInfo(){
        typeText(policyStartDate, "10/30/2020");
        typeText(primaryEmailAddress, "testkafil@gmail.com");
        delayFor(300);
        selectByValue(numberOfResidents, "4");
        click(continueButton);
    }
}
