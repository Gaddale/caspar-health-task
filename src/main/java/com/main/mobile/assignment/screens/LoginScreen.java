package com.main.mobile.assignment.screens;

import com.main.mobile.assignment.Configuration;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginScreen extends Screen {

    public static String notNowLocator = "com.casparhealth.android.patient:id/btnNotNow";

    @iOSXCUITFindBy(id = "login_button")
    @AndroidFindBy(id = "com.casparhealth.android.patient:id/login_button")
    public MobileElement signIn;

    @iOSXCUITFindBy(id = "email_text")
    @AndroidFindBy(id = "com.casparhealth.android.patient:id/email_text")
    public MobileElement casparId;

    @iOSXCUITFindBy(id = "password_text")
    @AndroidFindBy(id = "com.casparhealth.android.patient:id/password_text")
    public MobileElement password;

    @iOSXCUITFindBy(id = "btnNotNow")
    @AndroidFindBy(id = "com.casparhealth.android.patient:id/btnNotNow")
    public MobileElement notNowButton;

    public LoginScreen() {
        super();
    }

    public void login() {
        signIn.click();
        casparId.sendKeys(Configuration.CASPAR_ID.getValue());
        password.sendKeys(Configuration.PASSWORD.getValue());
        signIn.click();
        waitForScreenLoad(notNowLocator);
        notNowButton.click();
    }


}
