package activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_4 {
    public static void main(String[] args)
    {
        WebDriver driver= new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/tab-opener");
        System.out.println("Page Title:"+driver.getTitle());

        String handle=driver.getWindowHandle();
        System.out.println("Window Handle:"+handle);


    }
}
