package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EditExistingItem {

    public EditExistingItem (WebDriver driver){this.driver=driver;}
    WebDriver driver;
    By editButton = By.xpath("//p[contains(text() , 'Mike plays')]//parent::div//parent::div//div[1]//button[1]");
    By textArea = By.tagName("textarea");
    By updateItem = By.xpath("//button[contains(text(),'Update Item')]");
    By editTitleItem = By.xpath("//*[contains(text() , 'Mike plays')]");

    public void EditItem ()
    {
        driver.findElement(editButton).click();
        driver.findElement(textArea).clear();
        driver.findElement(textArea).sendKeys("Mike plays the guitar awesomely!!!");
        driver.findElement(updateItem).click();
        String getEditTitleItem =driver.findElement(editTitleItem).getText();
        assertTrue(getEditTitleItem.contains("Mike plays the guitar awesomely!!!"));

    }


}
