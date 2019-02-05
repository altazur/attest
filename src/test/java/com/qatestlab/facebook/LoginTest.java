package com.qatestlab.facebook;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    private LoginPage loginPage;
    private MainPage mainPage;
    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);

    }

    @Test
    public void mLoginTest(){
        loginPage.Navigate("https://facebook.com");
        Assert.assertTrue(loginPage.ValidateTitle("Facebook"));
        mainPage = loginPage.Login();
        Assert.assertTrue(mainPage.validateUserName("Nyornuwofia Agorsor"));
    }

    @Test
    public void mSendMessageTest(){
        loginPage.Navigate("https://facebook.com");
        mainPage = loginPage.Login();
        mainPage.WriteMessage("Test message");
        Assert.assertTrue(mainPage.lastMessage(), true);
    }

    @After
    public void Clean(){
        driver.quit();
    }

}
