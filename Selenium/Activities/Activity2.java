package activities;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
public static void main(String[] args)
{
    WebDriver driver=new FirefoxDriver();
    driver.get("https://www.training-support.net");

    String pageTitle=driver.getTitle();
    System.out.println("pageTitle:"+pageTitle);

    WebElement idLocator=driver.findElement(By.id("about-link"));
    System.out.println("gettext using idLocator:"+idLocator.getText());

    WebElement classLocator=driver.findElement(By.className("green"));
    System.out.println("gettext using classLocator:"+classLocator.getText());

    WebElement linLocator=driver.findElement(By.linkText("About Us"));
    System.out.println("gettext using linLocator:"+linLocator.getText());

    WebElement cssLocator=driver.findElement(By.cssSelector(".green"));
    System.out.println("gettext using cssLocator:"+cssLocator.getText());

    driver.close();



}

}
