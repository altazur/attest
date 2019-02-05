package com.qatestlab.facebook;

import org.openqa.selenium.WebDriver;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MainPage {

    private WebDriver driver;
    private MainPageMap Map;
    private Robot keyPresser;

    public MainPage (WebDriver driver){
        this.driver = driver;
        Map = new MainPageMap(this.driver);
        try {
            keyPresser = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public boolean validateUserName(String contains){
        return Map.UserName().contains(contains);
    }

    public void WriteMessage(String text){
        this.keyPresser.keyPress(KeyEvent.VK_ESCAPE);
        Map.MsgBtn().click();
        Map.FirstDialogue().click();
        Map.MsgField().sendKeys(text);
        Map.SendMessageButton().click();
    }

    public String lastMessage(){
        return Map.LastMessage();
    }
}
