package com.qatestlab.facebook;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageMap {

    private WebDriver driver;

    public LoginPageMap(WebDriver driver){
        this.driver = driver;
    }

    public WebElement LoginField(){
        return this.driver.findElement(By.id("email"));
    }

    public WebElement LoginPassField(){
        return this.driver.findElement(By.id("pass"));
    }

    public WebElement LoginButton(){
        return this.driver.findElement(By.id("loginbutton"));
    }

    public String PageTitle(){
        return this.driver.getTitle();
    }






}
