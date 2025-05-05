import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class CheckGridValuesTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void CheckGridValues() {
        driver.get("https://the-internet.herokuapp.com/tables");
        SoftAssert softAssert = new SoftAssert();
        String lastName = driver.findElement(By.xpath("//table[1]//tr[2]//td[1]")).getText();
        softAssert.assertEquals(lastName, "Bach");
        String firstName = driver.findElement(By.xpath("//table[2]//tr[3]//td[2]")).getText();
        softAssert.assertEquals(firstName, "Jason");
        String email = driver.findElement(By.xpath("//table[1]//tr[4]//td[3]")).getText();
        softAssert.assertEquals(email, "tconway@earthlink.net");
        String due = driver.findElement(By.xpath("//table[2]//tr[1]//td[4]")).getText();
        softAssert.assertEquals(due, "$50.00");
        String webSite = driver.findElement(By.xpath("//table[1]//tr[2]//td[5]")).getText();
        softAssert.assertEquals(webSite, "http://www.frank.com");
        String editButton = driver.findElement(By.xpath("//table[2]//tr[3]//td[6]//a[1]")).getText();
        softAssert.assertEquals(editButton, "edit");
        String deleteButton = driver.findElement(By.xpath("//table[1]//tr[2]//td[6]//a[2]")).getText();
        softAssert.assertEquals(deleteButton, "delete");
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}

