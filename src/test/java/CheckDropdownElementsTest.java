import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.List;

public class CheckDropdownElementsTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void CheckDropdownElements() {
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        List<WebElement> dropdownValues = select.getOptions();
        String dropdownDefaultState = dropdownValues.get(0).getText();
        Assert.assertEquals(dropdownDefaultState, "Please select an option");
        Assert.assertEquals(dropdownValues.get(1).getText(), "Option 1");
        Assert.assertEquals(dropdownValues.get(2).getText(), "Option 2");
        select.selectByIndex(1);
        softAssert.assertTrue(dropdownValues.get(1).isSelected());
        select.selectByIndex(2);
        softAssert.assertTrue(dropdownValues.get(2).isSelected());
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
