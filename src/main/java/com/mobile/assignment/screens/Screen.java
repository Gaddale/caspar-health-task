package com.mobile.assignment.screens;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Screen {

    protected WebDriver appiumDriver;

    public Screen(WebDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public WebDriver getWebDriver() {
        return appiumDriver;
    }

    public void isElementPresent(String css_text, int timeout) {
//        try{
//        wait = new WebDriverWait(appiumDriver, timeout);
//        wait.until(ExpectedConditions.visibilityOf(elementName));
//            return true;
//        }catch(Exception e){
//            return false;
//        }
    }
}
