package com.smt.demo;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataPickerTest {
    @Test
    public void CheckDate() throws InterruptedException
    {
        //https://www.vinsguru.com/selenium-webdriver-automating-custom-controls-datepicker/
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/datepicker/");

        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/iframe")));
        Thread.sleep(5000);

        WebElement datepicker = driver.findElement(By.id("datepicker"));
        datepicker.click();

        WebElement month = driver.findElement(By.cssSelector(".ui-datepicker-month"));
        WebElement year = driver.findElement(By.cssSelector(".ui-datepicker-year"));
        WebElement next = driver.findElement(By.cssSelector(".ui-datepicker-next.ui-corner-all"));
        WebElement prev = driver.findElement(By.cssSelector(".ui-datepicker-prev.ui-corner-all"));

        System.out.println(month.getText() + ":" +year.getText());
        next.click();
        List<WebElement> calendarDays = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td/a"));
        for (WebElement cDay : calendarDays) {
            String day =cDay.getText();
            System.out.println("Calendar Days > "+day);
            if( day.equals("25"))
            {
                cDay.click();
                System.out.println(datepicker.getText()+"is clicked");
                break;
            }
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //execute js for alert
        String selecteddate= js.executeScript("return document.getElementById('datepicker').value").toString();
        System.out.println("Selected date > "+selecteddate);
        Thread.sleep(3000);
        driver.quit();
    }
}
