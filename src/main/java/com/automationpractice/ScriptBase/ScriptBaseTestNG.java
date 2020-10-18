package com.automationpractice.ScriptBase;

import com.automationpractice.Pages.*;
import com.automationpractice.utils.DriverFactory;
import com.automationpractice.utils.WebElementUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ScriptBaseTestNG {

    protected WebDriver driver;
    protected WebElementUtils webElementUtils;
    protected PageBase pageBase;
    protected Properties prop;
    protected ProgressiveHomePage progressiveHomePage;
    protected NameAndAddressPage nameAndAddressPage;
    protected AddVehiclePage addVehiclePage;
    protected PolicyHolderDetailsPage policyHolderDetailsPage;
    protected AdditionalDetailsPage additionalDetailsPage;
    protected SnapshotEnrollmentPage snapshotEnrollmentPage;
    protected GoogleSearchPage googleSearchPage;
    protected BoltProgressivePage boltProgressiveHomePage;

    @BeforeTest
    public void beforeTest() {

    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browserName", "env"})
    public void beforeMethod(@Optional(value = ("chrome")) String browserName, @Optional(value = ("qa")) String env) throws InterruptedException, IOException {

        driver = DriverFactory.getInstance(browserName).getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();

        pageBase = new PageBase();
        webElementUtils = new WebElementUtils();
        progressiveHomePage = new ProgressiveHomePage();
        nameAndAddressPage = new NameAndAddressPage();
        addVehiclePage = new AddVehiclePage();
        policyHolderDetailsPage = new PolicyHolderDetailsPage();
        additionalDetailsPage = new AdditionalDetailsPage();
        snapshotEnrollmentPage = new SnapshotEnrollmentPage();
        googleSearchPage = new GoogleSearchPage();
        boltProgressiveHomePage = new BoltProgressivePage();
        prop = pageBase.init_prop(env);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void endReport() {
        //extent.flush();
    }

    @AfterMethod
    public void afterClass() {
        webElementUtils = null;
        progressiveHomePage = null;
        nameAndAddressPage = null;
        addVehiclePage = null;
        policyHolderDetailsPage = null;
        additionalDetailsPage = null;
        snapshotEnrollmentPage = null;
        boltProgressiveHomePage = null;
        driver  =null;
        //DriverFactory.getInstance().removeDriver();
    }
}
