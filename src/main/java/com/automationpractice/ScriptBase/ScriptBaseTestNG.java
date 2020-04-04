package com.automationpractice.ScriptBase;

import com.automationpractice.Pages.HomePage;
import com.automationpractice.Pages.LoginPage;
import com.automationpractice.utils.DriverFactory;
import com.automationpractice.utils.GetPageScreenShot;
import com.automationpractice.utils.RandomTestData;
import com.automationpractice.utils.WebElementUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ScriptBaseTestNG {

    protected WebDriver driver;
    protected WebElementUtils webElementUtils;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected RandomTestData randomTestData;
    //builds a new report using the html template
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite
    public void beforeTest() throws IOException, InterruptedException {
        Runtime.getRuntime().exec(System.getProperty("user.dir") + "/start_dockergrid.bat");
        Thread.sleep(15000);
        // initialize the HtmlReporter
        htmlReporter = new ExtentHtmlReporter("cmd /c start" + System.getProperty("user.dir") +"/src/test/resources/test-output/testReport.html");

        //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        //add content, manage tests etc
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Extent Report");
        htmlReporter.config().setReportName("Automation Practice Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.loadConfig(System.getProperty("user.dir") +"/src/test/resources/extent-config.xml");
    }

    @BeforeMethod
    @Parameters({"browserName"})
    public void beforeMethod() {
        driver = DriverFactory.getInstance(DriverFactory.BrowserType.CHROME.toString()).getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();

        webElementUtils = new WebElementUtils();
        homePage = new HomePage();
        loginPage = new LoginPage();
        randomTestData = new RandomTestData();
        driver.get(loadDataFromPropertiesFile("url", "page.properties"));
    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws Exception {
        if(result.getStatus() == ITestResult.FAILURE) {
            String screenShotPath = GetPageScreenShot.capture(driver, result.getTestName());
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"Test case FAILED due to below issues ", ExtentColor.RED));
            //test.fail(result.getThrowable());
            //test.log(Status.FAIL, MediaEntityBuilder.addScreenCaptureFromPath(screenShotPath));
            //test.fail("Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
            test.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            String screenShotPath = GetPageScreenShot.capture(driver, result.getName());
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
            test.pass("Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
        }
        else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
        extent.flush();
        DriverFactory.getInstance().removeDriver();

    }

    @AfterClass
    public void afterClass() {
        webElementUtils = null;
        homePage = null;
        loginPage = null;
    }

    @AfterSuite
    public void afterSuite() throws IOException, InterruptedException {
        //Runtime.getRuntime().exec("cmd /c start stop_dockergrid.bat");
        //Thread.sleep(5000);

        //Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
    }

    protected String loadDataFromPropertiesFile(String string,String fileName) {
        final String file = System.getProperty("user.dir") + "/src/main/resources/" + fileName;
        Properties prop = new Properties();
        InputStream input;
        try {
            input = new FileInputStream(file);
            // load a properties file
            prop.load(input);
            return prop.getProperty(string);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }
}
