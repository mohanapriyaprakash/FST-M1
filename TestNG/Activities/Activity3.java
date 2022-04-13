package activities;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity3 {
    WebDriver driver;
    @BeforeClass
    public void beforeClass()
    {
        driver=new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
    }
    @Test
    public void login()
    {
        WebElement userName=driver.findElement(By.id("username"));
        WebElement password= driver.findElement(By.id("password"));

        userName.sendKeys("admin");
        password.sendKeys("password");

        WebElement login=driver.findElement(By.xpath("\"//button[text()='Log in']\""));
        login.click();

        String msg=driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals("Welcome Back, admin", msg);

    }
    @AfterClass
    public void afterClass()
    {
        driver.close();
    }
}
