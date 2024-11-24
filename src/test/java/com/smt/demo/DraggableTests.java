package com.smt.demo;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DraggableTests{
    
    @Test()
    public void DragAndDrop() throws InterruptedException
    {
        ////https://www.youtube.com/watch?v=DxBWuX4qR_E
        System.out.println("Test run sucessfully -------------------------------------");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");

        Thread.sleep(3000);

        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/iframe")));
 
        WebElement draggable = driver.findElement(By.xpath("//*[@id=\"draggable\"]/p"));
        WebElement droppable = driver.findElement(By.xpath("//*[@id=\"droppable\"]/p"));
        new Actions(driver)
                .dragAndDrop(draggable, droppable)
                .perform(); 
        System.out.println("Performing Drag and Drop");
        Thread.sleep(3000);
        Assertions.assertEquals("Dropped!", driver.findElement(By.id("droppable")).getText());
        driver.quit();
    }

    @Test()
    public void DragAndDropImage() throws InterruptedException
    {
        ////https://www.youtube.com/watch?v=DxBWuX4qR_E
        System.out.println("Test run sucessfully -------------------------------------");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/ul/li[5]/a")).click();

        Thread.sleep(3000);

        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/iframe")));
        List<WebElement> draggables =  driver.findElements(By.xpath("//*[@id=\"gallery\"]/li"));
        WebElement droppable = driver.findElement(By.id("trash"));
        for(WebElement draggable : draggables)
        {
           
            new Actions(driver)
                    .dragAndDrop(draggable, droppable)
                    .perform(); 
            System.out.println("Performing Drag and Drop");
            Thread.sleep(3000);
        }
        driver.quit();
    }
}
