package com.automationpractice.tests;

import com.automationpractice.ScriptBase.ScriptBaseTestNG;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import java.io.IOException;

public class VerifyQuoteTest extends ScriptBaseTestNG {

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        driver.get("https://www.progressive.com/");
    }

    @Test(groups = {"smoke"})
    public void getAutoQuote(){
        progressiveHomePage.navigateToAutoInsurance();
        progressiveHomePage.navigateToNameAndAddressPage();
        nameAndAddressPage.enterUserInfo();
        nameAndAddressPage.navigateToAddVehiclePage();
        addVehiclePage.provideVehicleInfo();
        addVehiclePage.navigateToPolicyHolderPage();
        policyHolderDetailsPage.provideCustomerInformation();
        additionalDetailsPage.provideAutoInsuranceHistory();
        additionalDetailsPage.provideProgressiveInsuranceInfo();
        additionalDetailsPage.provideAdditionalInfo();
        snapshotEnrollmentPage.enrollToSnapshot();
        snapshotEnrollmentPage.verifyHeaderMessage();
    }

    @Test(groups = {"smoke"})
    public void getAutoAndHomeQuote(){
        progressiveHomePage.navigateToAutoAndHomeInsurance();
        progressiveHomePage.navigateToNameAndAddressPage();
        nameAndAddressPage.enterUserInfo();
        nameAndAddressPage.navigateToAddVehiclePage();
        addVehiclePage.provideVehicleInfo();
        addVehiclePage.navigateToPolicyHolderPage();
        policyHolderDetailsPage.provideCustomerInformation();
        additionalDetailsPage.provideAutoInsuranceHistory();
        additionalDetailsPage.provideProgressiveInsuranceInfo();
        additionalDetailsPage.provideAdditionalInfo();
        snapshotEnrollmentPage.enrollToSnapshotForHome();
        boltProgressiveHomePage.provideQuickQuestionAnswer();
        boltProgressiveHomePage.provideHomeBasicInfo();
        boltProgressiveHomePage.provideAnswers();
        boltProgressiveHomePage.provideStructureAnswer();
        boltProgressiveHomePage.providerUtilities();
        boltProgressiveHomePage.provideOwnerInfo();
    }
}
