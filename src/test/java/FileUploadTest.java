import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.time.Duration;

import static org.testng.Assert.*;

public class FileUploadTest {

    WebDriver driver;
    SoftAssert softAssert;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        softAssert = new SoftAssert();
    }

    @Test
    public void checkFileUpload() {
        driver.get("https://the-internet.herokuapp.com/upload");
        File file = new File("src\\test\\java\\FileForTest");
        driver.findElement(By.xpath("//input[@type = 'file']")).sendKeys(file.getAbsolutePath());
        String uploadedFile = driver.findElement(By.id("file-upload")).getDomProperty("value");
        softAssert.assertEquals(uploadedFile, "C:\\fakepath\\FileForTest");
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}