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

public class Activity9 {

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

        //Click on the leads
        driver.findElement(By.xpath("(//a[@id='moduleTab_9_Leads'])[1]")).click();

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

     for (int i=1;i<=10;i++)
     {
         WebElement name=driver.findElement(By.xpath("//*[@id='MassUpdate']/div[3]/table/tbody/tr["+i+"]/td[3]"));
         WebElement user=driver.findElement(By.xpath("//*[@id='MassUpdate']/div[3]/table/tbody/tr["+i+"]/td[8]"));

         System.out.println("i="+i+", name="+name+", user="+user);
         System.out.println("name:"+name.getText());
         System.out.println("user:"+user.getText());
     }
    }

   @AfterTest
    public void afterTest()
    {
        driver.close();
    }
}
