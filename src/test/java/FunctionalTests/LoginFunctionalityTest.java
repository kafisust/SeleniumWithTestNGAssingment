package FunctionalTests;

import ScriptBase.AutomationPracticeScriptBaseTestNG;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginFunctionalityTest extends AutomationPracticeScriptBaseTestNG {

    @Test(groups = {"smoke-test"}, priority=1)
    public void signInWithInvalidCredentials() {
        homePage.navigateToLoginPage();
        loginPage.signInWithCredentials("majid.us", "majid.us");
        assertTrue(loginPage.isAlertBarDangerDisplayed(), "Error message was not displayed");
        homePage.verifyPageTitle("Login - My Store");
    }

    @Test(groups = {"smoke-test"}, priority=2)
    public void forgotPasswordWithInvalidCredentials() {
        homePage.navigateToLoginPage();
        homePage.verifyPageTitle("Login - My Store");
        loginPage.forgotPasswordWithEmail("majid.us");
        assertTrue(loginPage.isAlertBarDangerDisplayed(), "Error message was not displayed");
    }

    @Test(groups = {"smoke-test"}, priority=3)
    public void signOut() {
        homePage.navigateToLoginPage();
        homePage.verifyPageTitle("Login - My Store");
        loginPage.signInWithCredentials("d1@grr.la","d1@grr.la");
        loginPage.signOut();
        assertTrue(loginPage.isSignInLinkDisplayed(), "SignIn link was not displayed after sign out action");
    }
}
