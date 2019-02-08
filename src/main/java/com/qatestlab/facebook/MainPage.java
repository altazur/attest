package com.qatestlab.facebook;

import org.openqa.selenium.WebDriver;

import java.awt.*;

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
        System.out.println("Hitting ESCAPE button");
        //Next line solving the browser notification pop-up problem, but causes the Message button isn't clicked properly
        //Which makes test failed
        //keyPresser.keyPress(KeyEvent.VK_ESCAPE);
        System.out.println("Clicking Message button");
        Map.MsgBtn().click();
        System.out.println("Clicking First Dialogue box");
        Map.FirstDialogue().click();
        System.out.println("Entering message to the input field");
        Map.MsgField().sendKeys(text);
        System.out.println("Clicking send message button");
        Map.SendMessageButton().click();
    }

    public String lastMessage(){
        return Map.LastMessage();
    }
}
