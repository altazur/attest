package com.qatestlab.facebook;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    private LoginPage loginPage;
    private MainPage mainPage;
    private WebDriver driver;

    @Before
    public void setup(){
        ChromeOptions opt = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        opt.setExperimentalOption("prefs", prefs);
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver(opt);
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
        String text = "Hello world";
        loginPage.Navigate("https://facebook.com");
        mainPage = loginPage.Login();
        mainPage.WriteMessage(text);
        System.out.println("Asserting last message");
        System.out.println(mainPage.lastMessage());
        Assert.assertTrue(mainPage.lastMessage().contains(text));
    }

    @After
    public void Clean(){
        driver.quit();
    }

}
