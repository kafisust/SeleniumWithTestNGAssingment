package com.automationpractice.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.util.Date;


public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports createInstance() {

        String fineName = getReportName();
        String directory = System.getProperty("user.dir") + "/reports/";
        new File(directory).mkdir();
        String path = directory + fineName;

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);
        //htmlReporter = new ExtentHtmlReporter("./reports/extent.html");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Automation Reports");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Automation Test Results");

        extent = new ExtentReports();
        extent.setSystemInfo("Automation Tester", "Mohammad Majid");
        extent.setSystemInfo("Organization", "MMAJID");
        extent.attachReporter(htmlReporter);
        return extent;
    }

    public static String getReportName(){
        Date d = new Date();
        String fileName = "AutomationReport_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
        return fileName;
    }

}

