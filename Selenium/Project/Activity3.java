package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity3 {
    WebDriver driver;
    @BeforeTest
    public void beforeTest() {
        driver=new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm/");
    }
    @Test
    public void getFooterText()
    {
        WebElement footer=driver.findElement(By.id("admin_options"));
        String url=footer.getText();
        System.out.println("Copy right text:"+url);
    }

    @AfterTest
    public void afterTest()
    {
        driver.close();
    }
}
