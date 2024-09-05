package org.IrvinCampos;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ECommerceTest extends BaseTest {
    @Test
    public void FillFormTest() throws InterruptedException {
//        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Miya");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Colombia\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Colombia']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(3000);
        String toastMessage = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
        Assert.assertEquals(toastMessage, "Please enter your name");
    }
}
