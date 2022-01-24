package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DeleteCreatedItem {

    public DeleteCreatedItem (WebDriver driver){this.driver=driver;}
    WebDriver driver;
    By deleteElement = By.xpath("//p[text()='Solar flare explosion capture in photo']//parent::div//parent::div//div[1]//button[2]");
    By deleteButton = By.xpath("//button[contains(text(),'Yes, delete it!')]");

    public void DeleteItem()
    {
        driver.findElement(deleteElement).click();
        String verifyDeleteButtonPopUp = driver.findElement(deleteButton).getText();
        Assert.assertTrue(verifyDeleteButtonPopUp.contains("Yes, delete it!"));
        driver.findElement(deleteButton).click();
    }

}
