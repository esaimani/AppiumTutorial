package Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.google.inject.spi.Element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class DragDropDemo {
    static AppiumDriver<MobileElement> driver;

    public static void main(final String[] args) throws MalformedURLException {
        final File appDir = new File("/Users/enavamani/Downloads/apks");
        final File app = new File(appDir, "ApiDemos-debug.apk");

        final DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability("deviceName", "emulator-5554");
        dc.setCapability("platformName", "Android");
        dc.setCapability("appPackage", "io.appium.android.apis");
        dc.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

        // dc.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        LongPressDemo.AndroidDriver(driver).findElementByAndroidUIAutomator("text(\"Views\")").click();

        LongPressDemo.AndroidDriver(driver).findElementByAndroidUIAutomator("text(\"Drag and Drop\")").click();

        final TouchAction action = new TouchAction(LongPressDemo.AndroidDriver(driver));

        final WebElement sourceElement = driver.findElementById("io.appium.android.apis:id/drag_dot_1");
        final WebElement destinationElement = driver.findElementById("io.appium.android.apis:id/drag_dot_2");

        action.longPress(longPressOptions().withElement(element(sourceElement)).withDuration(ofSeconds(1)))
                .moveTo(element(destinationElement)).release().perform();

        action.longPress(element(sourceElement)).moveTo(element(destinationElement)).release().perform();
    }

}