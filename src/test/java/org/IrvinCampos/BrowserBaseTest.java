package org.IrvinCampos;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserBaseTest {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    @BeforeClass
    public void configureAppium() throws MalformedURLException {
        service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Irvin//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("IrvinEmulator");
        options.setChromedriverExecutable("C://Users//Irvin//Desktop//Selenium-Server//ChromeDriver.exe");
        options.setCapability("browserName", "chrome");

//        use this line of code if you want to fully reset the phones downloaded apk files
//        options.setFullReset(true);
//        options.setApp("C://Users//Irvin//Desktop//Appium//src//test//java//org//IrvinCampos//resources//test.apk");
//        options.setApp("C://Users//Irvin//Desktop//Appium//src//test//java//org//IrvinCampos//resources//ApiDemos-debug.apk");
//        options.setApp("C://Users//Irvin//Desktop//Appium//src//test//java//org//IrvinCampos//resources//General-Store.apk");

//        AndroidDriver, IOSDriver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public Double formattedAmount(String amount) {
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();

    }

}
