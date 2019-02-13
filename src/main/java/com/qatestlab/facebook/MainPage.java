package com.qatestlab.facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MainPage {

    private WebDriver driver;
    private MainPageMap Map;

    public MainPage (WebDriver driver){
        this.driver = driver;
        Map = new MainPageMap(this.driver);
    }

    public boolean validateUserName(String contains){
        return Map.UserName().contains(contains);
    }

    public void WriteMessage(String text){
        System.out.println("Clicking Message button");
        Map.MsgBtn().click();
        System.out.println("Clicking First Dialogue box");
        Map.FirstDialogue().click();
        System.out.println("NEW: Clicking the message field");
        Map.MsgField().click();
        System.out.println("Entering message to the input field");
        // driver.sendKeys doesn't work with this field so using Actions
        new Actions(driver).moveToElement(Map.MsgField()).sendKeys(text).perform();
        System.out.println("Clicking send message button");
        Map.SendMessageButton().click();
        System.out.println("Clicked");
    }

    public String lastMessage(){
        return Map.LastMessage();
    }
}
