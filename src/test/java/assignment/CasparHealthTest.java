package assignment;

import com.mobile.assignment.screens.HomeScreen;
import com.mobile.assignment.screens.LoginScreen;
import com.mobile.assignment.screens.MyTrainingsScreen;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.apache.log4j.Logger.getLogger;

public class CasparHealthTest extends Hooks {

    private static Logger logger = getLogger(CasparHealthTest.class.getName());

    @Test  //Match Exercise count
    public void matchExerciseCount() {
        LoginScreen loginScreen = new LoginScreen(appiumDriver);
        loginScreen.login();
        HomeScreen homeScreen = new HomeScreen(appiumDriver);
        String homeExerciseCount = homeScreen.getTotalExerciseText();
        homeScreen.goButton.click();
        MyTrainingsScreen myTrainingsScreen = new MyTrainingsScreen(appiumDriver);
        String startTrainingCount = myTrainingsScreen.exercises.getText();
        Assert.assertEquals(homeExerciseCount, startTrainingCount);
        myTrainingsScreen.imReadyButton.click();
        myTrainingsScreen.yesButton.click();
        String myTrainingExerciseText = myTrainingsScreen.progressText.getText();
        Assert.assertTrue(myTrainingExerciseText.contains(homeExerciseCount));
    }
}
