package Apple;

import java.net.MalformedURLException;
import java.net.UnknownHostException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;

public class AppleiOSDemo extends BaseTest {

    @Test
    public void demoApple() throws MalformedURLException {

        driver.findElementByAccessibilityId("AAPLAlertViewController").click();

        driver.findElementByXPath("//*[@name='Text Entry']").click();

        String titleText = driver.findElementByXPath("//XCUIElementTypeStaticText[@name='A Short Title Is Best']")
                .getText();

        System.out.println("Title Text : " + titleText);

        Assert.assertEquals(titleText, "A Short Title Is Best");

        driver.findElementByName("OK").click();

    }

}