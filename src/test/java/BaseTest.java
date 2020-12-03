import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.*;
import org.testng.annotations.Test;

public class BaseTest {

    private final String GOOGLE_CHROME_BIN = "/app/.apt/usr/bin/google_chrome";
    private final String CHROMEDRIVER_PATH = "/app/.chromedriver/bin/chromedriver";

    @Test
    public void testTheFlow(){

        //     System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
        System.setProperty("GOOGLE_CHROME_BIN", "/app/.apt/usr/bin/google-chrome");
        System.setProperty("CHROMEDRIVER_PATH", "/app/.chromedriver/bin/chromedriver");
        System.setProperty("webdriver.chrome.driver", "/app/.chromedriver/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary(GOOGLE_CHROME_BIN);
        options.addArguments("--disable-gpu", "--no-sandbox", "--headless", "--disable-dev-sh-usage");
        ChromeDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev");
        Assert.assertEquals(driver.findElementByXPath("/html/body/section[2]/h2").getText(), "Getting Started123");

    }
}

