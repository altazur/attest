package com.qatestlab.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPageMap {

    private WebDriver driver;

    public MainPageMap(WebDriver driver){
        this.driver = driver;
    }

    public String UserName(){
        return this.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/div[1]/div/div/div/div/div[1]/ul/li/a/div")).getText();
    }

    public WebElement MsgBtn(){
        return this.driver.findElement(By.id("js_bn"));
    }

    public WebElement FirstMessage(){
        return this.driver.findElement(By.className("clearfix"));
    }

    public WebElement MsgField(){
        return this.driver.findElement(By.className("_1mf _1mj"));
    }

    public String LastMessage(){
        return this.driver.findElement(By.className("_1aa6")).getText();
    }



}
