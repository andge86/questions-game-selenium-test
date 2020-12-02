import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.*;
import org.testng.annotations.Test;

public class BaseTest {

   private final String GOOGLE_CHROME_PATH = "/app/.apt/usr/bin/google_chrome";
    private final String CHROMEDRIVER_PATH = "/app/.chromedriver/bin/chromedriver";

@Test
    public void testTheFlow(){

      //  System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
      //  options.setBinary(GOOGLE_CHROME_PATH);
        options.addArguments("--disable-gpu", "--no-sandbox", "--headless");
        ChromeDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev");
        Assert.assertEquals(driver.findElementByXPath("/html/body/section[2]/h2").getText(), "Getting Started");

    }
}
