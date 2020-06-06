package com.main.mobile.assignment.screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomeScreen extends Screen {

    public static String trainingArrowLocator = "com.casparhealth.android.patient:id/my_training_arrow";

    @iOSXCUITFindBy(id = "my_training_arrow")
    @AndroidFindBy(id = "com.casparhealth.android.patient:id/my_training_arrow")
    public MobileElement goButton;

    @iOSXCUITFindBy(id = "total_exercise_count_text")
    @AndroidFindBy(id = "com.casparhealth.android.patient:id/total_exercise_count_text")
    public MobileElement totalExerciseCount;

    public HomeScreen() {
        super();
    }

    public void clickTrainingSection() {
        waitForScreenLoad(trainingArrowLocator);
        goButton.click();
    }

    public String getTotalExerciseText() {
        waitForScreenLoad(trainingArrowLocator);
        return totalExerciseCount.getText();
    }

}
