package Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class ChromeDemo {

    static AppiumDriver<MobileElement> driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "emulator-5554");
        dc.setCapability("platformName", "Android");
        dc.setCapability("appPackage", "com.android.chrome");
        dc.setCapability("appActivity", "com.google.android.apps.chrome.Main");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement termsAcceptBtn = driver.findElementById("com.android.chrome:id/terms_accept");

        if (termsAcceptBtn.isEnabled()) {
            termsAcceptBtn.click();
        }
        WebElement noThanksBtn = driver.findElementById("com.android.chrome:id/negative_button");

        if (noThanksBtn.isEnabled()) {
            noThanksBtn.click();

        }

        driver.findElementById("com.android.chrome:id/search_box_text").sendKeys("Google Chrome");

        Thread.sleep(5000);
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(996, 1720)).perform();

    }

}