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

public class LongPressDemo {
    static AppiumDriver<MobileElement> driver;

    public static void main(String[] args) throws MalformedURLException {

        File appDir = new File("/Users/enavamani/Downloads/apks");
        File app = new File(appDir, "ApiDemos-debug.apk");
        System.out.println(app.getAbsolutePath());

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        dc.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        AndroidDriver(driver).findElementByAndroidUIAutomator("text(\"Views\")").click();

        driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']").click();

        driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();

        TouchAction action = new TouchAction(driver);

        WebElement touchelement = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
        action.longPress(longPressOptions().withElement(element(touchelement)).withDuration(ofSeconds(2))).release()
                .perform();

        String txt = AndroidDriver(driver).findElementByAndroidUIAutomator("text(\"Sample menu\")").getText();

        Assert.assertEquals(txt, "Sample menu", "Assert Failed");
    }

    public static AndroidDriver AndroidDriver(AppiumDriver driver) {

        return ((AndroidDriver) driver);
    }

}