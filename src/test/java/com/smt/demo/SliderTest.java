package com.smt.demo;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderTest {
    
    @Test
    public void RangeSliderTest() throws InterruptedException
    {
         System.out.println("Test run sucessfully -------------------------------------");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/slider/#range");

        Thread.sleep(3000);

        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/iframe")));
 
        WebElement leftSlider = driver.findElement(By.xpath("//*[@id=\"slider-range\"]/span[1]"));
        WebElement rightSlider = driver.findElement(By.xpath("//*[@id=\"slider-range\"]/span[2]"));

         Actions actions = new Actions(driver);

        // Move the slider by offset
        actions.clickAndHold(leftSlider)
                .moveByOffset(100, 0) // Move the slider 50 pixels to the right
                .release()
                .perform();
        Thread.sleep(2000);
        actions.clickAndHold(rightSlider)
                .moveByOffset(-100, 0) // Move the slider 50 pixels to the right
                .release()
                .perform();
        Thread.sleep(2000);
        driver.quit();
    }
    //https://jqueryui.com/slider/#range
}
