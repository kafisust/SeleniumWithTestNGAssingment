package Pages;

import org.testng.Assert;
import utils.WebElementUtils;

public class PageBase extends WebElementUtils {

    public PageBase(){
        super();
    }

    public void verifyPageTitle(String expectedTitle){
        String title = driver.getTitle();
        Assert.assertEquals(expectedTitle,title);
    }
}
