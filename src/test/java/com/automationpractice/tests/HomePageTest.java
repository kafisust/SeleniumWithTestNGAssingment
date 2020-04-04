package com.automationpractice.tests;

import com.automationpractice.ScriptBase.ScriptBaseTestNG;
import org.testng.annotations.Test;

public class HomePageTest extends ScriptBaseTestNG {

    @Test(groups = {"smoke-test"}, priority=1)
    public void navigateToLoginPage(){
        test = extent.createTest("navigateToLoginPage", "PASSED test case");
        homePage.verifyPageLogo();
        homePage.navigateToLoginPage();
        homePage.verifyPageTitle(loadDataFromPropertiesFile("loginTitle","page.properties"));
        homePage.isPageReady();
    }

    @Test(groups = {"smoke-test"}, priority=2)
    public void Search(){
        test = extent.createTest("Search", "PASSED test case");
        homePage.verifyPageLogo();
        homePage.searchFunctionality(randomTestData.randomEmail());
        homePage.verifyNoResultFound();
        homePage.isPageReady();

    }
}
