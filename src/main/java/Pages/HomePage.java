package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends PageBase {

    @FindBy(how= How.XPATH, using= "//a[@class='login']" )
    private WebElement loginLink;
    @FindBy(how= How.XPATH, using= "//img[@class='logo img-responsive']" )
    private WebElement pic;
    @FindBy(xpath = "//*[@id='contact-link']//a[contains(text(),'Contact us')]")
    private WebElement contactUs;
    @FindBy(xpath = "//button[@name='submit_search']")
    private WebElement searchButton;
    @FindBy(xpath = "//input[@id='search_query_top']")
    private WebElement searchBox;
    @FindBy(xpath = "//p[@class='alert alert-warning']")
    private WebElement NoResultFound;

    public HomePage(){
        super();
        PageFactory.initElements(driver,this);
    }

    public void navigateToLoginPage(){
        highlight(loginLink);
        loginLink.click();
    }

    public void navigateToContactPage(){
        highlight(contactUs);
        contactUs.click();
    }

    public void searchFunctionality(String element){
        highlight(searchBox);
        searchBox.sendKeys(element);
        searchButton.click();
    }

    public void verifyNoResultFound(String expectedMsg){
        String msg = NoResultFound.getText();
        Assert.assertEquals(msg,expectedMsg);
    }
    public void verifyPageLogo(){
        highlight(pic);
        boolean logo = pic.isDisplayed();
        Assert.assertEquals(true,logo);
    }
}
