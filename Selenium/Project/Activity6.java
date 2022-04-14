package activities;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity6 {
    WebDriver driver;
    @BeforeTest
    public void beforeTest() {
        driver=new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm/");
    }
    @Test
    public void verifyActivityMenu()
    {
        WebElement userName=driver.findElement(By.id("user_name"));
        WebElement password= driver.findElement(By.id("username_password"));

        userName.sendKeys("admin");
        password.sendKeys("pa$$w0rd");

        driver.findElement(By.id("bigbutton")).click();

        WebElement activityMenu= driver.findElement(By.id("grouptab_3"));
        Boolean isPresent= activityMenu.isEnabled();
        Boolean flag=true;
        System.out.println("element exist:"+isPresent);
        Assert.assertEquals(isPresent,flag);

        WebDriverWait wt = new WebDriverWait(driver,10);
        wt.until(ExpectedConditions.elementToBeClickable (By.id("grouptab_3")));


    }

    @AfterTest
    public void afterTest()
    {
        driver.close();
    }
}
