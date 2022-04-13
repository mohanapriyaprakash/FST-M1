package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6_2 {
    public static void main(String[] args)
    {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://training-support.net/selenium/ajax");

        System.out.println("Title"+driver.getTitle());

        driver.findElement(By.xpath("//button[@class='violet']")).click();

        //Wait for text to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "HELLO!"));

    }
}
