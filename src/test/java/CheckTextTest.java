import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class CheckTextTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void CheckText() {
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://the-internet.herokuapp.com/typos");
        String getText = driver.findElements(By.tagName("p")).get(1).getText();
        while (!getText.equals("Sometimes you'll see a typo, other times you won't.")) {
            driver.navigate().refresh();
            getText = driver.findElements(By.tagName("p")).get(1).getText();
        }
        softAssert.assertEquals(getText, "Sometimes you'll see a typo, other times you won't.");
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}


