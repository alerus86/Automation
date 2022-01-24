package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.File;

public class CreateItem {

    public CreateItem (WebDriver driver){this.driver=driver;}
    WebDriver driver;
    By itemDetail = By.xpath("//h3[contains(text(),'Item Details')]");
    By chooseFile = By.xpath("//input[@id='inputImage']");
    By textArea = By.tagName("textarea");
    By createItemButton = By.xpath("//button[contains(text(),'Create Item')]");
    By verifyCreatedItem = By.xpath("//*[contains(text() , 'Solar flare explosion capture in photo')]");

    public void TitleVerify()
    {
        boolean verifyPage =driver.findElement(itemDetail).isDisplayed();
    }

    public void AddNewItem() throws InterruptedException {

        File file = new File("image/solar.jpg");
        driver.findElement(chooseFile).sendKeys(file.getAbsolutePath());
        driver.findElement(textArea).sendKeys("Solar flare explosion capture in photo");
        driver.findElement(createItemButton).isEnabled();
        Thread.sleep(1000);
        driver.findElement(createItemButton).click();
        String createdItem =driver.findElement(verifyCreatedItem).getText();
        Assert.assertTrue(createdItem.contains("Solar flare explosion capture in photo"));

    }

}
