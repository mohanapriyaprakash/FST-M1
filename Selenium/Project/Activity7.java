package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Activity7 {
    WebDriver driver;
    Actions builder;

    @BeforeTest
    public void beforeTest() {
        driver=new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm/");
    }
    @Test
    public void readPopup()
    {
        WebElement userName=driver.findElement(By.id("user_name"));
        WebElement password= driver.findElement(By.id("username_password"));

        userName.sendKeys("admin");
        password.sendKeys("pa$$w0rd");

        driver.findElement(By.id("bigbutton")).click();

        // After login move to sales
        driver.findElement(By.xpath("//a[text()='Sales' and @id='grouptab_0']")).click();

       WebElement leads=driver.findElement(By.xpath("//li[2]//span[2]//ul[1]//li[5]//a[1]"));
       leads.click();

       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       WebElement additionalDetails=driver.findElement(By.xpath("//*[@id=\"adspan_683f9f93-9423-1a6e-4a4d-5fd8a89ceaab\"]/span"));

        builder = new Actions(driver);
        builder.moveToElement(additionalDetails).click().perform();

       WebElement mobile=driver.findElement(By.xpath("//div[@id='ui-id-5']"));

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        builder = new Actions(driver);
        builder.moveToElement(mobile).click().perform();
        String msg=mobile.getText();
        String numberOnly= msg.replaceAll("[^0-9]", "");
       System.out.println("mobile number:"+numberOnly);

    }

    @AfterTest
    public void afterTest()
    {
        driver.close();
    }
}
