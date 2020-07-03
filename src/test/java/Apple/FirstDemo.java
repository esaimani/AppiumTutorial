package Apple;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class FirstDemo {

    @Test
    public void demoApple() throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.5");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        dc.setCapability(MobileCapabilityType.APP,
                "/Users/enavamani/Library/Developer/Xcode/DerivedData/UICatalog-gindjevwrfnmrndukjmnfxtdbskl/Build/Products/Debug-iphonesimulator/UICatalog.app");
        dc.setCapability("useNewWDA", true);
        IOSDriver<IOSElement> driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        driver.findElementByAccessibilityId("AAPLButtonViewController").click();

        driver.navigate().back();

        driver.quit();
    }

}