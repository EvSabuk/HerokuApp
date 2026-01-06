import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class ForYou {

public void getMethod () {
    ChromeDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    driver.manage().window().maximize();
}
}
