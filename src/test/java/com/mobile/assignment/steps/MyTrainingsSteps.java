package com.mobile.assignment.steps;

import com.main.mobile.assignment.screens.HomeScreen;
import com.main.mobile.assignment.screens.LoginScreen;
import com.main.mobile.assignment.screens.MyTrainingsScreen;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class MyTrainingsSteps {

    String homeScreenExerciseCount = null;

    LoginScreen loginScreen = new LoginScreen();
    HomeScreen homeScreen = new HomeScreen();
    MyTrainingsScreen myTrainings = new MyTrainingsScreen();

    @Given("^user login to the app$")
    public void userLoginToApp() {
        loginScreen.login();
    }

    @When("^user captures the exercise count and lands on Training overview screen$")
    public void userCapturesTheExerciseCountAndLandsOnTrainingOverviewScreen() {
        homeScreenExerciseCount = homeScreen.getTotalExerciseText();
        homeScreen.clickTrainingSection();
    }

    @Then("^exercise count should match$")
    public void exerciseCountShouldMatch() {
        Assert.assertEquals(myTrainings.getExerciseCountText(), homeScreenExerciseCount);
    }

    @When("^user is ready for the training$")
    public void userReadyForTraining() {
        myTrainings.readyTraining();
    }

    @Then("^exercise count should match the exercise progress$")
    public void exerciseCountShouldMatchTheExerciseProgress() {
        Assert.assertTrue(myTrainings.progressText.getText().contains(homeScreenExerciseCount));
    }

    @Then("^user can skip all the exercises$")
    public void trainingShouldBeSkippedAndLandOnMyTrainingScreen() {
        myTrainings.readyTraining();
        for (int i = 1; i < Integer.parseInt(homeScreenExerciseCount); i++) {
            myTrainings.waitForScreenLoad(MyTrainingsScreen.exerciseProgressLocator);
            Assert.assertTrue(myTrainings.progressText.getText().contains(i + "/" + homeScreenExerciseCount));
            myTrainings.skipButton.click();
            myTrainings.skipConfirmButton.click();
            myTrainings.waitForScreenLoad(MyTrainingsScreen.exerciseProgressLocator);
        }
    }
}
