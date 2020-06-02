package com.mobile.assignment.screens;

import com.mobile.assignment.Configuration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginScreen extends Screen {

    @AndroidFindBy(id = "com.casparhealth.android.patient:id/login_button")
    public WebElement signIn;

    @AndroidFindBy(id = "com.casparhealth.android.patient:id/email_text")
    public WebElement casparId;

    @AndroidFindBy(id = "com.casparhealth.android.patient:id/password_text")
    public WebElement password;

    public LoginScreen(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public void login() {
        signIn.click();
        casparId.sendKeys(Configuration.CASPAR_ID.getValue());
        password.sendKeys(Configuration.PASSWORD.getValue());
        signIn.click();
    }


}
