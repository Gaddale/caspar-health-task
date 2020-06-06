package com.main.mobile.assignment.commons;

import com.main.mobile.assignment.Configuration;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.apache.log4j.Logger.getLogger;

public class Hooks {

    static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    static ThreadLocal<AppiumDriverLocalService> service = new ThreadLocal<>();
    private static String adbPath = Configuration.SDK_PATH.getValue() + "platform-tools" + File.separator + "adb";
    private static String emulatorPath = Configuration.SDK_PATH.getValue() + "tools" + File.separator + "emulator";

    public static void launchEmulator(String nameOfAVD) {
        String[] aCommand = new String[]{emulatorPath, "-avd", nameOfAVD};
        try {
            Process process = new ProcessBuilder(aCommand).start();
            process.waitFor(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeEmulator() {
        String[] aCommand = new String[]{adbPath, "emu", "kill"};
        try {
            Process process = new ProcessBuilder(aCommand).start();
            process.waitFor(1, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String setPlatform() {
        String platform = System.getProperty("platform");
        if (platform == null) {
            platform = System.getenv("platform");
        }
        return platform;
    }

    public AppiumDriver getDriver() {
        return driver.get();
    }

    @Before
    public void setUp() throws Exception {
        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1");
        service.set(appiumServiceBuilder.build());
        service.get().start();

        if (service == null || !service.get().isRunning()) {
            throw new AppiumServerHasNotBeenStartedLocallyException("An appium server node is not started!");
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (setPlatform().equals("ANDROID")) {
            launchEmulator(Configuration.EMULATOR_NAME.getValue());
            File appDir = new File("src");
            File app = new File(appDir, "caspar-health.apk");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "NagarajEmulator123");
            //capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            driver.set(new AndroidDriver<MobileElement>(service.get().getUrl(), capabilities));
        } else if (setPlatform().equals("IOS")) {
            capabilities.setCapability("automationName", "XCUITest");
            driver.set(new IOSDriver<MobileElement>(service.get().getUrl(), capabilities));
        }
    }

    @After
    public void stopServer() {
        closeEmulator();
        if (driver.get() != null) {
            driver.get().quit();
        }
        if (service.get() != null) {
            service.get().stop();
        }
    }
}
