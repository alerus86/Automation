package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerifyItemExists {

    public VerifyItemExists (WebDriver driver){this.driver=driver;}
    WebDriver driver;
    By verifyElementExist = By.xpath("//*[text() = 'Creators: Matt Duffer, Ross Duffer']");

    public void ElementExist ()
    {
        driver.findElement(verifyElementExist).isDisplayed();
    }



}
