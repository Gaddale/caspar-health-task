package com.mobile.assignment.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MyTrainingsScreen extends Screen {
    @AndroidFindBy(id = "com.casparhealth.android.patient:id/exercise_count_text")
    public WebElement exercises;

    @AndroidFindBy(id = "com.casparhealth.android.patient:id/ready_button")
    public WebElement imReadyButton;

    @AndroidFindBy(id = "com.casparhealth.android.patient:id/yes_button")
    public WebElement yesButton;

    @AndroidFindBy(id = "com.casparhealth.android.patient:id/no_button")
    public WebElement noButton;

    @AndroidFindBy(id="com.casparhealth.android.patient:id/exercise_progress_text")
    public WebElement progressText;

    @AndroidFindBy(id="com.casparhealth.android.patient:id/skip_button")
    public WebElement skipButton;

    @AndroidFindBy(id="com.casparhealth.android.patient:id/start_button")
    public WebElement startButton;

    @AndroidFindBy(id="com.casparhealth.android.patient:id/skip")
    public WebElement skipConfirmButton;

    public MyTrainingsScreen(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

}
