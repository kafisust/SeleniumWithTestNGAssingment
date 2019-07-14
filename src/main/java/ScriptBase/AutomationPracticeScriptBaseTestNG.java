package ScriptBase;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.DriverFactory;
import utils.WebElementUtils;

import java.util.concurrent.TimeUnit;

public class AutomationPracticeScriptBaseTestNG {

    protected WebDriver driver;
    protected WebElementUtils webElementUtils;
    protected HomePage homePage;
    //protected LoginPage loginPage;


    @BeforeMethod
    @Parameters({"browserName"})
    public void beforeMethod(@Optional(value = "firefox") String browserName) throws Exception {
        driver = DriverFactory.getInstance(browserName).getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);

        webElementUtils = new WebElementUtils();
        homePage = new HomePage();
        //loginPage = new LoginPage();
        driver.navigate().to("http://automationpractice.com/index.php?id_category=8&controller=category");
    }

    @AfterMethod
    public void afterMethod(){
        webElementUtils = null;
        homePage = null;
        //loginPage = null;
        //DriverFactory.getInstance().removeDriver();
    }
}
