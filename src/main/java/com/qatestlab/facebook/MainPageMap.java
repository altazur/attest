package com.qatestlab.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainPageMap {

    private WebDriver driver;
    private File file;
    //Magic Number


    public MainPageMap(WebDriver driver){
        this.driver = driver;
    }

    public String UserName(){
        return this.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/div[1]" +
                "/div/div/div/div/div[1]/ul/li/a/div")).getText();
    }

    public WebElement MsgBtn(){
        return new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(By.name("mercurymessages")));
    }

    public WebElement FirstDialogue(){
        return new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(By.className("messagesContent")));
    }

    public WebElement MsgField(){
        return this.driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/" +
                "div[4]/div/div[1]/div/div/div/div/div/div/div/div[2]/div[4]/div/div/div/" +
                "span/div/div/div[2]/div/div/div"));
    }

    public String LastMessage() throws IOException {
        file = new File("src/main/resources/last_message_number");//text file for storing last message div number to increment it after
        Scanner reader = new Scanner(file);//for reading the number
        //reading number from file
        int MessageNumber = reader.nextInt();
        reader.close();//clean the reader
        WebElement lastMessage = this.driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/div[4]/div/div[1]/div/div/div/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div/div["+MessageNumber+++"]/div/div/div/div[1]/div/div/div/div[2]/div/div/span/span"));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));//creating object for write the new MessageNumber
        writer.write(MessageNumber);//write
        writer.close();//closing the file
        return lastMessage.getText();//return the Last message text
    }

    public WebElement SendMessageButton(){
        return new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/div[4]/div/div[1]/div/div/div/div/div/div[1]/div/div[2]/div[4]/div/ul/li[8]")));
        //return this.driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/div[4]/div/div[1]/div/div/div/div/div/div[1]/div/div[2]/div[4]/div/ul/li[8]"));
    }

}
