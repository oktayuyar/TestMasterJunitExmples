package com.sahabt.automation;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SahibindenLoginTest {

    WebDriver driver;
    BaseTest baseTest=new BaseTest();

    @Test
    public void true_Email_True_Password_Test(){

        baseTest.setup();
        baseTest.login("oktyuyar@gmail.com","o.123");

        baseTest.click(By.cssSelector(".user-info-campaign-dialog [ng-hide]"));

        String title = baseTest.getTitle();
        Assert.assertTrue("Login failed!", title.contains("Bana Özel Özet"));
        System.out.println("Login successful");

    }

    @Test
    public void true_Email_False_Password_Test(){

        baseTest.setup();
        baseTest.login("oktyuyar@gmail.com","123");

        String error=baseTest.find(By.className("error")).getText();
        System.out.println(error);
        Assert.assertTrue(error, error.equals("E-Posta adresiniz, kullanıcı adınız veya şifreniz hatalı."));

    }

}
