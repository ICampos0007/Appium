package org.IrvinCampos;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropTest extends BaseTest{
    @Test
    public void DroppingTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement dropItem = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        DragAndDropAction(dropItem,619,560);
        Thread.sleep(2000);
        String actual = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(actual, "Dropped!");
    }
}
