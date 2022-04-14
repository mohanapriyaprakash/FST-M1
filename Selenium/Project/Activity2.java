package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;
    @BeforeTest
    public void beforeTest() {
        driver=new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm/");
    }
    @Test
    public void getHeaderUrl()
    {
        WebElement header=driver.findElement(By.xpath("//a[@title='SuiteCRM']"));
        String url=header.getAttribute("href");
        System.out.println("Header URL:"+url);
    }

    @AfterTest
    public void afterTest()
    {
        driver.close();
    }
}
