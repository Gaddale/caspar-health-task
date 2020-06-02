package com.mobile.assignment.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeScreen extends Screen {
    public WebDriverWait wait;

    @AndroidFindBy(id = "com.casparhealth.android.patient:id/my_training_arrow")
    public WebElement goButton;

    @AndroidFindBy(id = "com.casparhealth.android.patient:id/knowledge_arrow")
    public WebElement knowledgeArrow;

    @AndroidFindBy(id = "com.casparhealth.android.patient:id/progressTextView")
    public WebElement stepsProgressCounter;

    @AndroidFindBy(id = "com.casparhealth.android.patient:id/activityAddCountButton")
    public WebElement addStepsButton;

    @AndroidFindBy(id = "com.casparhealth.android.patient:id/total_exercise_count_text")
    public WebElement totalExerciseCount;

    @AndroidFindBy(id = "com.casparhealth.android.patient:id/no_exercise_layout")
    public WebElement noExerciseLayout;

    public HomeScreen(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public void clickTrainingSection() {
        goButton.click();
    }

    public String getTotalExerciseText() {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.casparhealth.android.patient:id/my_training_arrow")));
        return totalExerciseCount.getText();
    }

}
