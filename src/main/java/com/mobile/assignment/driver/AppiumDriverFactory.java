package com.mobile.assignment.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class AppiumDriverFactory {

    public static AppiumDriver<MobileElement> appiumDriver;

    private AppiumDriverFactory() {
    }

    public static AppiumDriver<MobileElement> getAppiumDriver(String platformName) throws Exception {
        File appDir = new File("src");
        File app = new File(appDir, "caspar-health.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (platformName.equals("Android")) {
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "NagarajEmulator123");
//        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            appiumDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } else if (platformName.equals("IOS")) {
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
            appiumDriver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        }
        return appiumDriver;
    }

    public static void killDriverInstance() {
        appiumDriver.quit();
    }
}
