package com.sahabt.automation;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BaseTest {

    WebDriver driver;

    public String driverName = "webdriver.chrome.driver";
    public String driverPath = "/home/oktay/ChromeDriver/chromedriver";
    public String url = "http://sahibinden.com";


    @Before
    public void setup() {
        System.setProperty(driverName, driverPath);
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }

    public  void login(String username,String password){

        click(By.cssSelector(".login-text [rel]"));

        click(By.cssSelector(".qr-login-promotion .close"));

        sendKey(By.id("username"),username);

        sendKey(By.id("password"),password);


        click(By.id("userLoginSubmitButton"));
    }

    public void moveToElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();

    }
    public String getTitle() {
        return driver.getTitle();
    }

    public void click(By by) {
        find(by).click();
    }

    public void submit(By by) {
        driver.findElement(by).submit();
    }

    public void sendKey(By by,String value){
        driver.findElement(by).sendKeys(value);
    }

    public WebElement find(By by){
        WebElement x=driver.findElement(by);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", x);
        return x;
    }

    public void thread(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
