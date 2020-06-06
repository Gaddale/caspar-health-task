package com.mobile.assignment.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = "src/test/java/com/mobile/assignment/features",
        glue = {"com.mobile.assignment.steps","com.main.mobile.assignment.commons"},
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"
        }
)
public class TestRunner {

}
