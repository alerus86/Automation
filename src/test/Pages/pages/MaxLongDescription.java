package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MaxLongDescription {

    public MaxLongDescription (WebDriver driver){this.driver=driver;}
    WebDriver driver;
    By textArea = By.tagName("textarea");
    By createItemButton = By.xpath("//button[contains(text(),'Create Item')]");

    public void VerifyMaxLongInDescription() throws InterruptedException {
        driver.findElement(textArea).sendKeys("dsfsdfdsfsdfsdfsdfsddsfsdfdsfsdfsdfsdfsddsfsdfdsfsdfsdfsdfsddsfsdfdsfsdfsdfsdfsddsfsdfdsfsdfsdfsdfsddsfsdfdsfsdfsdfsdfsddsfsdfdsfsdfsdfsdfsddsfsdfdsfsdfsdfsdfsddsfsdfdsfsdfsdfsdfsddsfsdfdsfsdfsdfsdfsddsfsdfdsfsdfsdfsdfsddsfsdfdsfsdfsdfsdfsddsfsdfdsfsdfsdfsdfsddsfsdfdsfsdfsdfsdfsddsfsdfdsfsdfsdfsd1234");
        Thread.sleep(3000);
        boolean disable = driver.findElement(createItemButton).isEnabled();
        Assert.assertEquals(false , disable);

    }

}
