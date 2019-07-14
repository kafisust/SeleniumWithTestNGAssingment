package FunctionalTests;

import ScriptBase.AutomationPracticeScriptBaseTestNG;
import org.testng.annotations.Test;

public class HomePageTest extends AutomationPracticeScriptBaseTestNG {

    @Test
    public void navigateToLoginPage(){
        homePage.verifyPageLogo();
        homePage.navigateToLoginPage();
        homePage.verifyPageTitle("Login - My Store");
    }
}
