package com.sahabt.automation;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SahibindenSearchTest {

    WebDriver driver;
    BaseTest baseTest=new BaseTest();

    @Test
    public void search_With_Car_Price_Test(){

        baseTest.setup();
        baseTest.find(By.id("searchText")).sendKeys("Ford");
        baseTest.submit(By.id("searchText"));

        baseTest.click(By.cssSelector("[class=\"category-level-3517\"] li:nth-of-type(1) [data-category] > span:nth-of-type(1)"));


        baseTest.click(By.cssSelector("#searchResultLeft-price div [type=\"text\"]:nth-of-type(1)"));

        baseTest.sendKey(By.cssSelector(("#searchResultLeft-price div [type=\"text\"]:nth-of-type(1)")),
                "20000");
        baseTest.sendKey(By.cssSelector(("#searchResultLeft-price div [type=\"text\"]:nth-child(3)")),
                "50000");
        baseTest.click(By.cssSelector("#searchResultLeft-price .js-manual-search-button"));

    }

    @Test
    public void search_With_Fuel_Type_Test(){

        baseTest.setup();
        baseTest.find(By.id("searchText")).sendKeys("Ford");
        baseTest.submit(By.id("searchText"));

        baseTest.click(By.cssSelector("[class=\"category-level-3517\"] li:nth-of-type(1) [data-category] > span:nth-of-type(1)"));

        baseTest.click(By.linkText("Benzin"));
        baseTest.click(By.cssSelector("#closeCookiePolicy"));
        baseTest.click(By.cssSelector(".search-submit"));

    }
}
