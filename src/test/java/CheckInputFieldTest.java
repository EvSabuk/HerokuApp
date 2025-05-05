import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class CheckInputFieldTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void CheckInputField() {
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://the-internet.herokuapp.com/inputs");
        driver.findElement(By.tagName("input")).sendKeys("Monday");
        String specifiedValue = driver.findElement(By.tagName("input")).getDomProperty("value");
        softAssert.assertEquals(specifiedValue, "");
        driver.findElement(By.tagName("input")).sendKeys("123");
        specifiedValue = driver.findElement(By.tagName("input")).getDomProperty("value");
        softAssert.assertEquals(specifiedValue, "123");
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP, Keys.ARROW_UP, Keys.ARROW_UP,
                Keys.ARROW_DOWN);
        specifiedValue = driver.findElement(By.tagName("input")).getDomProperty("value");
        softAssert.assertEquals(specifiedValue, "125");
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}

