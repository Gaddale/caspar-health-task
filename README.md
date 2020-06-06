# Caspar-Health-Assignment

## Task1: Manual Testing

* Scenarios are written in BDD Gherkin format under the folder Task1.

## Task2: Test Automation

### Tools Used

* Appium with Java
* Cucumber html for reporting

### Execution

1. Update these Configuration variables before running in any local machine

  * SDK_PATH
  * EMULATOR_NAME
    
2. From the command prompt run `mvn clean install` or `mvn verify -Dplatform='ANDROID'`

### Reporting

* Cucumber html reports `target/cucumber-html-reports/overview-features.html`

### Note

* Automated against Android, not able to test against IOS since I do not have mac.  
