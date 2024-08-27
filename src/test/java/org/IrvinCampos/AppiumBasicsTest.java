package org.IrvinCampos;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AppiumBasicsTest extends BaseTest {

    @Test
    public void WifiSettingsTest() throws MalformedURLException{
//        xpath, id, accessibilitId, classname, androidUIAutomator
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();


    }

}
