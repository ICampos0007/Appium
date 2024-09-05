package org.IrvinCampos;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MiscellaneousAppiumActionsTest extends BaseTest{
    @Test
    public void MiscellaneousTest() {
//        adb shell dumpsys window | find "mCurrentFocus"
//        Activity activity = new Activity("12ac23c u0 io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
                "appPackage", "197cbdc u0 io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"
//                "appActivity", "io.appium.android.apis.preference.PreferenceDependencies"
        ));





        DeviceRotation defaultRotation = new DeviceRotation(0,0,0);
        driver.rotate(defaultRotation);
        driver.findElement(By.id("android:id/checkbox")).click();
        DeviceRotation landscape = new DeviceRotation(0,0,90);
        driver.rotate(landscape);
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
//        copy,paste
//        copy to clipboard paste it clipboard
        driver.setClipboardText("Irvin Wifi");
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        String actualText = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(actualText,"WiFi settings");

        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
        driver.rotate(defaultRotation);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));

    }

}
