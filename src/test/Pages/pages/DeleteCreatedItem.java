package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteCreatedItem {

    public DeleteCreatedItem (WebDriver driver){this.driver=driver;}
    WebDriver driver;
    By deleteElement = By.xpath("//p[text()='Solar flare explosion capture in photo']//parent::div//parent::div//div[1]//button[2]");
    By deleteButton = By.xpath("//button[contains(text(),'Yes, delete it!')]");

    public void DeleteItem()
    {
        driver.findElement(deleteElement).click();
        driver.findElement(deleteButton).click();
    }

}
