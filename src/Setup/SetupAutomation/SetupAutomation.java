package SetupAutomation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class SetupAutomation {

    String driverPath = "driver/chromedriver.exe";
    WebDriver driver;
    CreateItem objCreateItem;
    EditExistingItem objEditExistingItem;
    DeleteCreatedItem objDeleteCreatedItem;
    MaxLongDescription objMaxLongDescription;
    VerifyItemExists objVerifyItemExists;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://immense-hollows-74271.herokuapp.com/");
    }

    @Test (priority = 1)
    public void add_item_to_page() throws InterruptedException {

        objCreateItem = new CreateItem(driver);
        objCreateItem.TitleVerify();
        objCreateItem.AddNewItem();

    }

    @Test (priority = 2)
    public void edit_item_on_page() {

        objEditExistingItem = new EditExistingItem(driver);
        objEditExistingItem.EditItem();

    }

    @Test (priority = 3)
    public void delete_created_item() {

        objDeleteCreatedItem = new DeleteCreatedItem(driver);
        objDeleteCreatedItem.DeleteItem();

    }

    @Test (priority = 4)
    public void verify_max_long_description_item() throws InterruptedException {

        objMaxLongDescription = new MaxLongDescription(driver);
        objMaxLongDescription.VerifyMaxLongInDescription();

    }

    @Test (priority = 5)
    public void verify_item_exists() {

        objVerifyItemExists = new VerifyItemExists(driver);
        objVerifyItemExists.ElementExist();

    }

    @AfterTest(alwaysRun = true)
    public void flush()
    {

        driver.quit();

    }
}