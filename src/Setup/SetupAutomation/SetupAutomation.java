package SetupAutomation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class SetupAutomation {

    private String driverPath = "driver/chromedriver.exe";
    private WebDriver driver;
    private CreateItem objCreateItem;
    private EditExistingItem objEditExistingItem;
    private DeleteCreatedItem objDeleteCreatedItem;
    private MaxLongDescription objMaxLongDescription;
    private VerifyItemExists objVerifyItemExists;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://immense-hollows-74271.herokuapp.com/");
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Stranger List";
        Assert.assertEquals(ExpectedTitle , ActualTitle );
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