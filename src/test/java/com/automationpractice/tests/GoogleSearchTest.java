package com.automationpractice.tests;

import com.automationpractice.ScriptBase.ScriptBaseTestNG;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleSearchTest extends ScriptBaseTestNG {

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        driver.get("https://www.google.com/");
    }

    @Test
    public void verifyGoogleSearch(){
        googleSearchPage.searchItem("TestNg");
        googleSearchPage.verifyPageTitle("TestNg - Google Search");
    }
}
