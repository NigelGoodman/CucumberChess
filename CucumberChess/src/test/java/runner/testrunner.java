package runner;

import java.io.File;

import org.junit.*;
//import org.junit.runner.*;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//import com.vimalselvam.listener.ExtentCucumberFormatter;
//import com.cucumber.listener.Reporter;

import com.aventstack.extentreports.reporter.*;
import com.vimalselvam.cucumber.listener.ExtentCucumberFormatter;
import com.vimalselvam.cucumber.listener.Reporter;

//import com.vimalselvam.listener.ExtentCucumberFormatter;
//import com.cucumber.listener.Reporter;

// please ensure that you use JUnit4 to run these tests as a suite.

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/java/features"
,glue= {"seleniumgluecode"},
plugin = { "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}//, 
//monochrome = true
)

public class testrunner 
{
	@AfterClass
    public static void writeExtentReport() 
	{
        Reporter.loadXMLConfig(new File("config/report.xml"));
    
    }

}