package com.qatestlab.facebook;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    private LoginPage loginPage;
    private MainPage mainPage;
    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver");
        // Setting new profile from folder (actual profile)
        //.ini for whatever reason here
        ProfilesIni profile = new ProfilesIni();
        //make profile with ini builder
        FirefoxProfile ffProfile = profile.getProfile("default");
        FirefoxOptions opt = new FirefoxOptions();
        //setting our created profile to FireFoxOptions object
        opt.setCapability("firefox_profile", ffProfile);
        opt.setProfile(ffProfile);
        //create Firefox gecko driver with profile
        driver = new FirefoxDriver(opt);
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
