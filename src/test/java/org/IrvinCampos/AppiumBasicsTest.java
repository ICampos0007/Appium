package org.IrvinCampos;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AppiumBasicsTest extends BaseTest {

    @Test
    public void WifiSettingsTest() throws MalformedURLException{
//        xpath, id, accessibilitId, classname, androidUIAutomator
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        driver.findElement(By.id("android:id/edit")).sendKeys("Irvin wifi");
        String actualText = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(actualText,"WiFi settings");

        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();



    }

}
