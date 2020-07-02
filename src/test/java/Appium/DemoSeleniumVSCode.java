package Appium;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoSeleniumVSCode {

    static RemoteWebDriver driver;

    public static void main(String[] args) throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://mvnrepository.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElementById("query").sendKeys("Esaimani");

        driver.close();

    }

}