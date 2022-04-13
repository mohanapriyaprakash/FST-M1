package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity8_1 {
    public static void main(String[] args)
    {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://training-support.net/selenium/tables");

        List<WebElement> rows=driver.findElements(By.xpath("//table[@id='sortableTable']/thead/tr/th"));
        List<WebElement> cols=driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));

        System.out.println("Numbers of columns:"+cols.size());
        System.out.println("No of rows:"+ rows.size());

        //Cell value of second row, second column
        WebElement cellValueBefore = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second column value(Before sorting): " + cellValueBefore.getText());

        //Sort the table
        driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th[2]")).click();

        //Print the value again
        WebElement cellValueAfter = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second column value(After sorting): " + cellValueAfter.getText());

        //Print footer cell value
        WebElement footer = driver.findElement(By.xpath("//table[@id='sortableTable']/tfoot/tr"));
        System.out.println("Table footer values: " + footer.getText());

        //Close browser
        driver.close();
    }
}
