package com.ww.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BasePage {

    public static WebDriver driver;

    public static void initialization(String browser, String url){

        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        driver.get(url);
    }
}
