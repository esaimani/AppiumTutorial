package Apple;

import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleiOSDemo extends BaseTest {

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