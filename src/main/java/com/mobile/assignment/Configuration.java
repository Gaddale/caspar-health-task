package com.mobile.assignment;

import static java.lang.System.getenv;

public enum Configuration {

    SDK_PATH("SDK_PATH", "/home/nagaraj/android-sdk/"),
    DRIVER_EXE_PATH("DRIVER_EXE_PATH", "/usr/local/bin/node"),
    APPIUM_JS_Path("APPIUM_JS_Path","/usr/local/lib/node_modules/appium/build/lib/main.js"),
    EMULATOR_NAME("EMULATOR_NAME", "NagarajEmulator123"),
    CASPAR_ID("CASPAR_ID","NGY3621"),
    PASSWORD("PASSWORD", "ac0n3x72");

    private final String value;

    Configuration(String mode, String defaultValue) {
        if (getenv(mode) != null)
            this.value = getenv(mode);
        else
            this.value = defaultValue;
    }

    public String getValue() {
        return this.value;
    }
}
