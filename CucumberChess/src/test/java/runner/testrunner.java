package runner;

//import org.junit.*;
//import org.junit.runner.*;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/javaFeatures"
,glue= {"seleniumgluecode"},
tags= {"@analysis,@import"}
)

public class testrunner {

}