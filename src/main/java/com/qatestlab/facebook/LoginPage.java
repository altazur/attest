package com.qatestlab.facebook;

import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    LoginPageMap Map;
    private final String LoginEmail = "mail4test@list.ru";
    private final String LoginPass = "10stepsinua";

    public LoginPage(WebDriver driver){
        this.driver = driver;
        Map = new LoginPageMap(this.driver);
    }

    public MainPage Login(){
        Map.LoginField().sendKeys(LoginEmail);
        Map.LoginPassField().sendKeys(LoginPass);
        Map.LoginButton().click();
        return new MainPage(this.driver);
    }

    public void Navigate(String URL){
        this.driver.get(URL);
    }

    public boolean ValidateTitle(String contains){
        return Map.PageTitle().contains(contains);
    }

}
