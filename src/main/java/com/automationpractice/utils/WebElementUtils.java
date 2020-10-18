package com.automationpractice.utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class WebElementUtils extends SeleniumUtils {

    public WebElementUtils() {
        super();
    }

    public void typeText(WebElement element, String text){
        highlight(element);
        element.clear();
        element.sendKeys(text);
    }

    public void click(WebElement element){
        highlight(element);
        element.click();
    }
    public void verifyText(WebElement element, String textToVerify){
        String actualText = element.getText();
        assertThat(actualText,equalTo(textToVerify));
    }

   protected boolean isElementDisplayed(WebElement element, Integer timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

}
