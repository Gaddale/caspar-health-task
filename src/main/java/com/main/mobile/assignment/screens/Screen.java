package com.main.mobile.assignment.screens;

import com.main.mobile.assignment.commons.Hooks;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Screen {

    protected AppiumDriver driver;

    public Screen() {
        this.driver = new Hooks().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void waitForScreenLoad(String locator) {
        WebDriverWait webDriverWait = new WebDriverWait(this.driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
    }

}
