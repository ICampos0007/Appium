package org.IrvinCampos;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class MobileScrollTest extends BaseTest{

    @Test
    public void ScrollTest() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
//        where to scroll is known prior
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

        // No prior knowledge of where to scroll
//        SCrolltoEndAction();
    }
}
