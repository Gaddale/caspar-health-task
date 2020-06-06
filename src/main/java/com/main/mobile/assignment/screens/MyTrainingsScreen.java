package com.main.mobile.assignment.screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MyTrainingsScreen extends Screen {

    public static String exerciseCountLocator = "com.casparhealth.android.patient:id/exercise_count_text";
    public static String readyButtonLocator = "com.casparhealth.android.patient:id/ready_button";
    public static String exerciseProgressLocator = "com.casparhealth.android.patient:id/exercise_progress_text";


    @iOSXCUITFindBy(id = "exercise_count_text")
    @AndroidFindBy(id = "com.casparhealth.android.patient:id/exercise_count_text")
    public MobileElement exercises;

    @iOSXCUITFindBy(id = "ready_button")
    @AndroidFindBy(id = "com.casparhealth.android.patient:id/ready_button")
    public MobileElement imReadyButton;

    @iOSXCUITFindBy(id = "yes_button")
    @AndroidFindBy(id = "com.casparhealth.android.patient:id/yes_button")
    public MobileElement yesButton;

    @iOSXCUITFindBy(id = "exercise_progress_text")
    @AndroidFindBy(id = "com.casparhealth.android.patient:id/exercise_progress_text")
    public MobileElement progressText;

    @iOSXCUITFindBy(id = "skip_button")
    @AndroidFindBy(id = "com.casparhealth.android.patient:id/skip_button")
    public MobileElement skipButton;

    @iOSXCUITFindBy(id = "start_button")
    @AndroidFindBy(id = "com.casparhealth.android.patient:id/start_button")
    public MobileElement startButton;

    @iOSXCUITFindBy(id = "skip")
    @AndroidFindBy(id = "com.casparhealth.android.patient:id/skip")
    public MobileElement skipConfirmButton;

    public MyTrainingsScreen() {
        super();
    }

    public String getExerciseCountText() {
        waitForScreenLoad(exerciseCountLocator);
        return exercises.getText();
    }

    public void readyTraining() {
        waitForScreenLoad(readyButtonLocator);
        imReadyButton.click();
        yesButton.click();
    }

    public void skipTraining() {
        waitForScreenLoad(exerciseProgressLocator);
        skipButton.click();
        skipConfirmButton.click();
    }

    public void skipTrainings(String count) {
        readyTraining();
        for (int i = 1; i < Integer.parseInt(count); i++) {
            waitForScreenLoad(exerciseProgressLocator);
            skipButton.click();
            skipConfirmButton.click();
        }

    }

}
