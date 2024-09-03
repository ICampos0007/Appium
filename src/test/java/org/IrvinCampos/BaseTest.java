package org.IrvinCampos;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    @BeforeClass
    public void configureAppium() throws MalformedURLException {
         service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Irvin//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("IrvinEmulator");
//        use this line of code if you want to fully reset the phones downloaded apk files
//        options.setFullReset(true);
//        options.setApp("C://Users//Irvin//Desktop//Appium//src//test//java//org//IrvinCampos//resources//test.apk");
        options.setApp("C://Users//Irvin//Desktop//Appium//src//test//java//org//IrvinCampos//resources//ApiDemos-debug.apk");

//        AndroidDriver, IOSDriver
         driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void LongPressAction(WebElement ele) {
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement) ele).getId(),
                        "duration",2000));
    }

    public void SCrolltoEndAction() {
        // No prior knowledge of where to scroll
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 1.0
            ));
        }while (canScrollMore);
    }

    public void SwipeAction(WebElement element, String direction, double percent) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", percent
        ));
    }

    public void DragAndDropAction(WebElement element, int x, int y) {
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", x,
                "endY", y
        ));
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();

    }
}
