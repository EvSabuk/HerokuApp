import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class CheckUncheckCheckboxTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void CheckUncheckCheckbox() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        SoftAssert softAssert = new SoftAssert();
        WebElement checkboxFirst = driver.findElements(By.cssSelector("[type=checkbox]")).get(0);
        softAssert.assertFalse(checkboxFirst.isSelected());
        checkboxFirst.click();
        softAssert.assertTrue(checkboxFirst.isSelected());
        WebElement checkboxSecond = driver.findElements(By.cssSelector("[type=checkbox]")).get(1);
        softAssert.assertTrue(checkboxSecond.isSelected());
        checkboxSecond.click();
        softAssert.assertFalse(checkboxSecond.isSelected());
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}


