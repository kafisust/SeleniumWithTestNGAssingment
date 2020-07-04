package com.automationpractice.utils;

import com.automationpractice.Pages.PageBase;
import org.openqa.selenium.JavascriptExecutor;

public class ScreenSize extends PageBase {

    public enum ScreenType{
        LAPTOP,
        SMARTPHONE,
        TABLETPORTRAIT,
        TABLETLANDSCAPE,
        BIGSCREEN
    }

    public void OpenScreen(ScreenType screenType)
    {
     switch (screenType)
     {
         //case ScreenType.LAPTOP
             //driver.manage().window().getSize();
         //break;
         //case ScreenType.SMARTPHONE
             //driver.manage().window().getSize();
            // break;
     }
    }

    public long ScrollUp(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scroll(0, -window.pageYOffset)");
        double offset = (double) js.executeScript("return window.pageYOffset;");
        return (long)Math.round(offset);
    }

    public long ScrollDown(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scroll(0, window.pageYOffset)");
        double offset = (double) js.executeScript("return window.pageYOffset;");
        return (long)Math.round(offset);
    }

    public long ScrollToTheBottom(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scroll(0, document.body.scrollHeight)");
        double offset = (double) js.executeScript("return window.pageYOffset;");
        return (long)Math.round(offset);
    }

    public long ScrollToTheTop(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scroll(0,0)");
        double offset = (double) js.executeScript("return window.pageYOffset;");
        return (long)Math.round(offset);
    }
}
