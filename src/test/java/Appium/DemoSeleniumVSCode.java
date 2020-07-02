package Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DemoSeleniumVSCode {

    static AppiumDriver<MobileElement> driver;

    public static void main(String[] args) throws MalformedURLException {
        // WebDriverManager.chromedriver().setup();
        // driver = new ChromeDriver();
        // driver.get("https://mvnrepository.com");
        // driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // driver.findElementById("query").sendKeys("Esaimani");

        // driver.close();

    }

}