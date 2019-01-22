package com.qatestlab.facebook;

import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;
    private MainPageMap Map;

    public MainPage(WebDriver driver){
        this.driver = driver;
        Map = new MainPageMap(this.driver);
    }

    public boolean validateUserName(String contains){
        return Map.UserName().contains(contains);
    }
}
