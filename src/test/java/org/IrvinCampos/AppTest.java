package org.IrvinCampos;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AppTest extends BaseTest{
    @Test
    public void EndToEndTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
//        press the 3rd button
        driver.findElement(By.xpath("//android.widget.Button[3]")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("android:id/button3")).click();

//        click on the text entry dialog button
        driver.findElement(AppiumBy.accessibilityId("Text Entry dialog")).click();
//        enter a name and password
        driver.findElement(By.id("io.appium.android.apis:id/username_edit")).sendKeys("Miya");
        driver.findElement(By.id("io.appium.android.apis:id/password_edit")).sendKeys("Laadi");
//        then click ok
        driver.findElement(By.id("android:id/button1")).click();
        Thread.sleep(3000);

//        click on repeat alarm button
        driver.findElement(AppiumBy.accessibilityId("Repeat alarm")).click();
//        get the list of days
       List<WebElement> days =  driver.findElements(By.xpath("//android.widget.CheckedTextView"));

       days.get(0).click();
       days.get(1).click();
       days.get(2).click();
       days.get(3).click();
       Assert.assertEquals(days.get(0).getAttribute("checked"), "true");

        Thread.sleep(3000);
//       then click ok
        driver.findElement(By.id("android:id/button1")).click();


    }
}
