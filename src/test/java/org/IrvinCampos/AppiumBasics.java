package org.IrvinCampos;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBasics {
    @Test
    public void AppiumBasicTest() throws MalformedURLException, InterruptedException {
        AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Irvin//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("IrvinEmulator");
        options.setFullReset(true);
//        options.setApp("C://Users//Irvin//Desktop//Appium//src//test//java//org//IrvinCampos//resources//test.apk");
        options.setApp("C://Users//Irvin//Desktop//Appium//src//test//java//org//IrvinCampos//resources//ApiDemos-debug.apk");

//        AndroidDriver, IOSDriver
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        Thread.sleep(3000);
//        xpath, id, accessibilitId, classname, androidUIAutomator
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();

        driver.quit();
        service.stop();
    }
}
