package Apple;

import java.net.MalformedURLException;

import org.openqa.selenium.Dimension;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class ScrollDown {

    public static void main(String[] args) throws MalformedURLException {
        IOSDriver<IOSElement> driver = BaseTest.capabilities(null, 0);

        Dimension size = driver.manage().window().getSize();
        int x = size.getWidth() / 2;
        int starty = (int) (size.getHeight() * 0.60);
        int endy = (int) (size.getHeight() * 0.10);

    }

}