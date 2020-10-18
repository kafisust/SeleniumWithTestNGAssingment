package com.automationpractice.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddVehiclePage extends PageBase{

    @FindBy(xpath = "//li[contains(text(),'2021')]")
    private WebElement selectYear2021;
    @FindBy(xpath = "//li[contains(text(),'Acura')]")
    private WebElement selectMakeAcura;
    @FindBy(xpath = "//li[contains(text(),'RDX')]")
    private WebElement selectModelAcura;
    @FindBy(id = "VehiclesNew_embedded_questions_list_BodyStyle")
    private WebElement bodyType;
    @FindBy(id = "VehiclesNew_embedded_questions_list_VehicleUse")
    private WebElement primaryUse;
    @FindBy(id = "VehiclesNew_embedded_questions_list_OwnOrLease")
    private WebElement ownOrLease;
    @FindBy(id = "VehiclesNew_embedded_questions_list_LengthOfOwnership")
    private WebElement lengthOfOwnership;
    @FindBy(id = "VehiclesNew_embedded_questions_list_AutomaticEmergencyBraking_N")
    private WebElement factoryInstalled;
    @FindBy(xpath = "//input[@id='VehiclesNew_embedded_questions_list_BlindSpotWarning_N']")
    private WebElement blindSpot;
    @FindBy(xpath = "//button[contains(text(),'Done')]")
    private WebElement done;
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    private WebElement continueButton;
    @FindBy(xpath = "//*[@class='hvd-loading-button blue ng-tns-c169-3']//button")
    private WebElement addMyOwnBtn;

    public AddVehiclePage(){
        super();
        PageFactory.initElements(driver, this);
    }

    public void provideVehicleInfo(){
        if(!driver.findElements(By.xpath("//li[contains(text(),'2021')]")).isEmpty()) {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(text(),'2021')]")));
            delayFor(1000);
            driver.findElement(By.xpath("//li[contains(text(),'2021')]")).click();
        }
        else if (driver.findElement(By.xpath("//*[@class='hvd-loading-button blue ng-tns-c169-3']//button")).isEnabled()){
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='hvd-loading-button blue ng-tns-c169-3']//button")));
            driver.findElement(By.xpath("//*[@class='hvd-loading-button blue ng-tns-c169-3']//button")).click();
            delayFor(200);
            click(selectYear2021);
        }
        else {
            System.out.println("No vehicle found at the provided address");
        }
        isElementDisplayed(selectMakeAcura, 20);
        //verifyPageTitle("Add Vehicle");
        //click(selectYear2021);
        click(selectMakeAcura);
        click(selectModelAcura);
        selectByValue(bodyType, "SUV (4CYL 4X2)");
        delayFor(2000);
        selectByVisibleText(primaryUse, "Farming (agriculture, ranching)");
        delayFor(2000);
        selectByValue(ownOrLease, "2");
        delayFor(2000);
        selectByValue(lengthOfOwnership, "E");
        delayFor(1000);
        click(factoryInstalled);
        click(blindSpot);
        click(done);
    }

    public void navigateToPolicyHolderPage(){
        jsClick(continueButton);
    }
}
