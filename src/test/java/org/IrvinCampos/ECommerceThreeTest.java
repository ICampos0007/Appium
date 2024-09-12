package org.IrvinCampos;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ECommerceThreeTest extends BaseTest{
    @Test
    public void FillFormTest() throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Miya");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Colombia\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Colombia']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));

       List<WebElement> productPrices =  driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
       int productCount = productPrices.size();
       double totalSum =0;
       for (int i=0; i<productCount; i++) {
           String amountString = productPrices.get(i).getText();
           Double price = formattedAmount(amountString);
           totalSum = totalSum + price;

       }

       String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
       Double displayFormattedSum = formattedAmount(displaySum);

       Assert.assertEquals(totalSum,displayFormattedSum);

//      com.androidsample.generalstore:id/termsButton
        WebElement termButton = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
       LongPressAction(termButton);
       String terms = driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText();
       Assert.assertEquals(terms, "Terms Of Conditions");
        driver.findElement(By.id("android:id/button1")).click();
       driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
       driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
       Thread.sleep(2000);


    }
}
