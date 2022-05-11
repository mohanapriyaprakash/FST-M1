package activities;


import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Unit test for simple App.
 */
public class Activity1
{
    WebDriverWait wait;
    AndroidDriver<MobileElement> driver = null;

    @BeforeClass
public void setup() throws MalformedURLException {
    // Set the Desired Capabilities
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("deviceName", "<Your device name>");
    caps.setCapability("platformName", "Android");
    caps.setCapability("automationName", "UiAutomator2");
    caps.setCapability("appPackage", "com.google.android.apps.tasks");
    caps.setCapability("appActivity", ".ui.TaskListsActivity");
    caps.setCapability("noReset", true);

    // Instantiate Appium Driver
    driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
    wait = new WebDriverWait(driver, 10);
}

    @Test
    public void createTaskInGoogleTask() {

        /*wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("\t\n" +
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout")));
        driver.findElement(MobileBy.AndroidUIAutomator("//*[@id=\"screenshotContainer\"]/div/div/div/div/div/div[40]");
        */

        //Add task name and click save
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")));
        driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Task1");

        driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/add_task_done")).click();


    }
}
