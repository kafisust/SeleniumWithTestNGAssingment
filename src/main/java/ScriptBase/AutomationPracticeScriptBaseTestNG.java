package ScriptBase;

import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.DriverFactory;
import utils.WebElementUtils;

import java.util.concurrent.TimeUnit;

public class AutomationPracticeScriptBaseTestNG {

    protected WebDriver driver;
    protected WebElementUtils webElementUtils;
    protected HomePage homePage;
    protected LoginPage loginPage;


    @BeforeClass
    @Parameters({"browserName"})
    public void beforeMethod(@Optional(value = "chrome") String browserName) throws Exception {
        driver = DriverFactory.getInstance(browserName).getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);

        webElementUtils = new WebElementUtils();
        homePage = new HomePage();
        loginPage = new LoginPage();
        driver.navigate().to("http://automationpractice.com/index.php?id_category=8&controller=category");
    }

    @AfterClass
    public void afterMethod(){
        webElementUtils = null;
        homePage = null;
        loginPage = null;
        DriverFactory.getInstance().removeDriver();
    }
}
