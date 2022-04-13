package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args)
    {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://training-support.net/selenium/simple-form");

        String pageTitle=driver.getTitle();
        System.out.println("Title:"+pageTitle);

        WebElement firstName=driver.findElement(By.id("firstName"));
        WebElement lastName=driver.findElement(By.id("lastName"));

        firstName.sendKeys("mohana");
        lastName.sendKeys("priya");

        WebElement email=driver.findElement(By.id("email"));
        WebElement contact=driver.findElement(By.id("number"));

        email.sendKeys("test@example.com");
        contact.sendKeys("1234567890");

        //Click Submit
        driver.findElement(By.cssSelector(".ui.green.button")).click();

        //Close the browser
        driver.close();

    }
}
