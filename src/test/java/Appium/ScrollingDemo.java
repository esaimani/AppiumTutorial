package Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ScrollingDemo {

    static AppiumDriver<MobileElement> driver;

    public static void main(String[] args) throws MalformedURLException {
        File appDir = new File("/Users/enavamani/eBay Projects/LearnAppium/LearnAppium/src/resources");
        File app = new File(appDir, "ApiDemos-debug.apk");
        System.out.println(app.getAbsolutePath());

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        dc.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        LongPressDemo.AndroidDriver(driver).findElementByAndroidUIAutomator("text(\"Views\")").click();

        TouchAction action = new TouchAction(LongPressDemo.AndroidDriver(driver));

        LongPressDemo.AndroidDriver(driver).findElementsByAndroidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Webview\"));");

    }

}