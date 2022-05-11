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

public class Activity3 {
    WebDriverWait wait;
    AndroidDriver<MobileElement> driver = null;

    @BeforeClass
    public void setup() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "<Your device name>");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void createNoteAndRemainder() {

        //Click add Note button
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/notes")));
        driver.findElement(MobileBy.id("com.google.android.keep:id/notes")).click();

        //send keys to title
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.keep:id/editable_title")));
        driver.findElement(MobileBy.id("com.google.android.keep:id/editable_title")).sendKeys("title1");

        driver.findElement(MobileBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("Note1");

        //click add remainder
        driver.findElement(MobileBy.xpath("//android.widget.TextView[@content-desc=\"Single-column view\"]")).click();

        //click remainder as tomorrow morning
        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.view.ViewGroup[1]")).click();
    }
}

