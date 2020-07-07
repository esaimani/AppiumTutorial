package Apple;

import java.io.File;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {

    protected static AppiumDriverLocalService service;
    protected static IOSDriver<IOSElement> driver;
    protected static int port = 4723;

    @BeforeClass
    public void startAppium() throws MalformedURLException, UnknownHostException {
        String ip = startAppiumServer();

        if (service == null || !service.isRunning()) {
            throw new AppiumServerHasNotBeenStartedLocallyException("An appium server node is not started!");
        }
        driver = BaseTest.capabilities(ip, port);
    }

    public static IOSDriver<IOSElement> capabilities(String ip, int port) throws MalformedURLException {
        IOSDriver<IOSElement> driver;

        File src = new File("/Users/enavamani/eBay Projects/LearnAppium/LearnAppium/src/resources/");
        File appPath = new File(src, "UICatalog.app");

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.5");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        dc.setCapability(MobileCapabilityType.APP, appPath.getAbsolutePath());
        dc.setCapability("useNewWDA", true);
        dc.setCapability("noReset", true);
        driver = new IOSDriver<>(new URL("http://" + ip + ":" + port + "/wd/hub"), dc);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        return driver;

    }

    /**
     * Starts a local server.
     *
     * @return ip of a local host
     * @throws UnknownHostException when it is impossible to get ip address of a
     *                              local host
     */
    public static String startAppiumServer() throws UnknownHostException {
        service = new AppiumServiceBuilder().usingPort(port).build();
        service.start();
        InetAddress inetAddress = InetAddress.getLocalHost();
        return inetAddress.getHostAddress();
    }

    @AfterClass
    public static void afterClass() {
        if (driver != null) {
            driver.quit();
        }
        if (service != null) {
            service.stop();
        }
    }

}