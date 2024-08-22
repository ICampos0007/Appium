package org.IrvinCampos;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBasics {
    @Test
    public void AppiumBasicTest() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("IrvinEmulator");
        options.setFullReset(true);
        options.setApp("C://Users//Irvin//Desktop//Appium//src//test//java//org//IrvinCampos//resources//test.apk");

//        AndroidDriver, IOSDriver
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        Thread.sleep(3000);

        driver.quit();
    }
}
