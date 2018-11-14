package seleniumgluecode;



import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.*;


public class CucumberChessAnalysis 
{
	public static WebDriver driver;
	public static menuBar testMenuBar;
	public static analysisBoard testAnalysisBoard;
        
    @Given("^the user is on lichess$")
    public void the_user_is_on_lichess() throws Throwable 
    {
        
    	System.setProperty("webdriver.gecko.driver","geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://lichess.org/");
    }

    @Given("^they hover over the tools menu$")
    public void they_hover_over_the_tools_menu() throws Throwable 
    {
    	testMenuBar = new menuBar(driver);
    	testMenuBar.hoverOverTools();    	
    }

    @When("^they click on Analysis board$")
    public void they_click_on_Analysis_board() throws Throwable 
    {
        testMenuBar.clickAnalysisBoard();
    }

    @Then("^They are taken to the analysis board$")
    public void they_are_taken_to_the_analysis_board() throws Throwable 
    {
    	testAnalysisBoard = new analysisBoard(driver);
        Assert.assertArrayEquals("You are actually on " + driver.getTitle(), driver.getTitle().toCharArray(), testAnalysisBoard.titleOfPage());
        
    }
    
    @Given("^the user is on the analysis board$")
    public void the_user_is_on_the_analysis_board() throws Throwable 
    {
        this.the_user_is_on_lichess();
        this.they_hover_over_the_tools_menu();
        this.they_click_on_Analysis_board();
        this.they_are_taken_to_the_analysis_board();
    }

    @When("^they turn the analysis on$")
    public void they_turn_the_analysis_on() throws Throwable 
    {
    	testAnalysisBoard = new analysisBoard(driver);
        testAnalysisBoard.turnOnAnalysis();
    }

    @Then("^analysis activates$")
    public void analysis_activates() throws Throwable 
    {
    	testAnalysisBoard.waitUntilExpectedEvaluation("+0.2");
    	Assert.assertArrayEquals("actualText " + testAnalysisBoard.returnCurrentEvaluation(), "+0.2".toCharArray() , testAnalysisBoard.returnCurrentEvaluation().toCharArray());
        
    }
    

    @When("^they click on the b(\\d+) knight$")
    public void they_click_on_the_b_knight(int arg1) throws Throwable 
    {
    	testAnalysisBoard.clickOnb1Knight();
    }

    @Then("^an option to move it to a(\\d+) is shown$")
    public void an_option_to_move_it_to_a_is_shown(int arg1) throws Throwable 
    {
    	
    	Assert.assertTrue(testAnalysisBoard.dest1IsVisible());
    	Assert.assertArrayEquals("The thing is actually " + testAnalysisBoard.dest1Location(), "0px, 320px".toCharArray() , testAnalysisBoard.dest1Location().toCharArray());
    	
    }

    @Then("^an option to move it to c(\\d+) is shown$")
    public void an_option_to_move_it_to_c_is_shown(int arg1) throws Throwable 
    {
    	Assert.assertTrue(testAnalysisBoard.dest2IsVisible());
    	Assert.assertArrayEquals("The thing is actually " + testAnalysisBoard.dest2Location(), "128px, 320px".toCharArray() , testAnalysisBoard.dest2Location().toCharArray());

    }

    @After
    public void afterTest() {
    	driver.quit();
    }
    
}
