package activities;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        WebDriver driver=new FirefoxDriver();
       driver.get(" https://www.training-support.net");
       driver.close();
    }
}
