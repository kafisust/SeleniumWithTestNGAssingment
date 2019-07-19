package FunctionalTests;

import ScriptBase.AutomationPracticeScriptBaseTestNG;
import org.testng.annotations.Test;

public class HomePageTest extends AutomationPracticeScriptBaseTestNG {

    @Test(groups = {"smoke-test"}, priority=1)
    public void navigateToLoginPage(){
        homePage.verifyPageLogo();
        homePage.navigateToLoginPage();
        homePage.verifyPageTitle("Login - My Store");
        homePage.isPageReady();
    }

    @Test(groups = {"smoke-test"}, priority=2)
    public void Search(){
        homePage.verifyPageLogo();
        homePage.searchFunctionality("Majid");
        homePage.verifyNoResultFound("No results were found for your search \"Majid\"");
        homePage.isPageReady();
    }
}
