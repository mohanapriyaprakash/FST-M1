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

public class Activity8 {
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

        WebElement account=driver.findElement(By.xpath("//li[3]//span[2]//ul[1]//li[3]//a[1]"));
        account.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement accountTable=driver.findElement(By.xpath("//tbody/tr[1]/td[3]/b[1]/a[1]"));

        builder = new Actions(driver);
        builder.moveToElement(accountTable).click().perform();

        System.out.println("1st row:"+accountTable.getText());

        int i=3;
        while(i<=9)
        {
            WebElement accountTable2=driver.findElement(By.xpath("//tbody/tr["+i+"]/td[3]/b[1]/a[1]"));
            i=i+2;
            System.out.println(i+"th row value:"+accountTable2.getText());
        }


    }

    @AfterTest
    public void afterTest()
    {
        driver.close();
    }
}
