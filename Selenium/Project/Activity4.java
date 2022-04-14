package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity4 {
    WebDriver driver;
    @BeforeTest
    public void beforeTest() {
        driver=new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm/");
    }
    @Test
    public void login()
    {
        WebElement userName=driver.findElement(By.id("user_name"));
        WebElement password= driver.findElement(By.id("username_password"));

        userName.sendKeys("admin");
        password.sendKeys("pa$$w0rd");

        driver.findElement(By.id("bigbutton")).click();
        String homepage=driver.findElement(By.xpath("//*[@id='tab0']")).getText();
        Assert.assertEquals(homepage,"SUITECRM DASHBOARD");

    }

    @AfterTest
    public void afterTest()
    {
        driver.close();
    }
}
