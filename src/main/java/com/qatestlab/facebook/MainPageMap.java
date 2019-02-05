package com.qatestlab.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageMap {

    private WebDriver driver;

    public MainPageMap(WebDriver driver){
        this.driver = driver;
    }

    public String UserName(){
        return this.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/div[1]" +
                "/div/div/div/div/div[1]/ul/li/a/div")).getText();
    }

    public WebElement MsgBtn(){
        return this.driver.findElement(By.name("mercurymessages"));
    }

    public WebElement FirstDialogue(){
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        return wait.until(ExpectedConditions.elementToBeClickable(By.className("jewelItemNew")));
    }

    public WebElement MsgField(){
        return this.driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/" +
                "div[4]/div/div[1]/div/div/div/div/div/div/div/div[2]/div[4]/div/div/div/" +
                "span/div/div/div[2]/div/div/div"));
    }

    public String LastMessage(){
        return this.driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/div" +
                "[4]/div/div[1]/div/div/div/div/div/div[1]/div/div[2]" +
                "/div[1]/div/div/div[2]/div/div[1]/div/div[2]/div/div/" +
                "div/div[1]/div/div/div/div[2]/div/div/span/span")).getText();
    }

    public WebElement SendMessageButton(){
        return this.driver.findElement(By.id("js_6d"));
    }

}
