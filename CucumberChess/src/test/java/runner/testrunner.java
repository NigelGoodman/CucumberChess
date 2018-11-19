package runner;

import org.junit.*;
//import org.junit.runner.*;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

// please ensure that you use JUnit4 to run these tests as a suite.

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/java/features"
,glue= {"seleniumgluecode"},
tags= {"@analysis,@import"}
)

public class testrunner {

}