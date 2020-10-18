package com.automationpractice.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NameAndAddressPage extends PageBase {

    @FindBy(id = "NameAndAddressEdit_embedded_questions_list_FirstName")
    private WebElement firstName;
    @FindBy(id = "NameAndAddressEdit_embedded_questions_list_LastName")
    private WebElement lastName;
    @FindBy(id = "NameAndAddressEdit_embedded_questions_list_DateOfBirth")
    private WebElement dateOfBirth;
    @FindBy(xpath = "//input[@id='NameAndAddressEdit_embedded_questions_list_MailingAddress']")
    private WebElement streetName;
    @FindBy(xpath = "//body/app-root[1]/form[1]/main[1]/name-and-address-edit[1]/div[1]/div[1]/div[1]/question[6]/label[1]/text-input[1]")
    private WebElement streetName1;
    @FindBy(xpath = "//button[contains(text(),'Okay, start my quote.')]")
    private WebElement startMyQuoteButton;

    public NameAndAddressPage(){
        super();
        PageFactory.initElements(driver, this);
    }

    public void enterUserInfo(){
        isElementDisplayed(firstName, 10);
        verifyPageTitle("Name And Address");
        typeText(firstName, "test1223");
        typeText(lastName, "test3001");
        typeText(dateOfBirth, "12/31/2000");
        js.executeScript("arguments[0].value='10717 N Macarthur Blvd';", streetName);
        streetName.sendKeys(Keys.SPACE);
        streetName.click();
        streetName.sendKeys(Keys.SPACE);
        js.executeScript("arguments[0].value='1800 Full Wiser Rd APT#31112';", streetName);
    }

    public void navigateToAddVehiclePage(){
        click(startMyQuoteButton);
    }
}
