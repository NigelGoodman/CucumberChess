package seleniumgluecode;



import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
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
    	if (driver != null) {driver.quit();}
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
    	Assert.assertArrayEquals("Actual Evaluation : " + testAnalysisBoard.returnCurrentEvaluation(), "+0.2".toCharArray() , testAnalysisBoard.returnCurrentEvaluation().toCharArray());
        
    }
    

    @When("^they click on the b(\\d+) knight$")
    public void they_click_on_the_b_knight(int arg1) throws Throwable 
    {
    	testAnalysisBoard.clickOnb1Knight();
    }

    @Then("^an option to move the knight to a(\\d+) is shown$")
    public void an_option_to_move_the_knight_to_a_is_shown(int arg1) throws Throwable 
    {
    	
    	Assert.assertTrue(testAnalysisBoard.dest2IsVisible());
    	Assert.assertArrayEquals("The destination is actually " + testAnalysisBoard.dest2Location(), "0px, 320px".toCharArray() , testAnalysisBoard.dest2Location().toCharArray());
    	
    }

    @Then("^an option to move knight to c(\\d+) is shown$")
    public void an_option_to_move_knight_to_c_is_shown(int arg1) throws Throwable 
    {
    	Assert.assertTrue(testAnalysisBoard.dest1IsVisible());
    	Assert.assertArrayEquals("The destination is actually " + testAnalysisBoard.dest1Location(), "128px, 320px".toCharArray() , testAnalysisBoard.dest1Location().toCharArray());

    }
    

    @When("^they click on the g(\\d+) knight$")
    public void they_click_on_the_g_knight(int arg1) throws Throwable 
    {
    	testAnalysisBoard.clickOng1Knight();
    }

    @Then("^an option to move the knight to f(\\d+) is shown$")
    public void an_option_to_move_the_knight_to_f_is_shown(int arg1) throws Throwable 
    {
    	Assert.assertTrue(testAnalysisBoard.dest2IsVisible());
    	Assert.assertArrayEquals("The destination is actually " + testAnalysisBoard.dest2Location(), "320px, 320px".toCharArray() , testAnalysisBoard.dest2Location().toCharArray());
    }

    @Then("^an option to move knight to h(\\d+) is shown$")
    public void an_option_to_move_knight_to_h_is_shown(int arg1) throws Throwable 
    {
    	Assert.assertTrue(testAnalysisBoard.dest1IsVisible());
    	Assert.assertArrayEquals("The destination is actually " + testAnalysisBoard.dest1Location(), "448px, 320px".toCharArray() , testAnalysisBoard.dest1Location().toCharArray());
    }



    @When("^they click on the a(\\d+) pawn$")
    public void they_click_on_the_a_pawn(int arg1) throws Throwable 
    {
    	testAnalysisBoard.clickOnA2Pawn();
    }

    @When("^they click on the b(\\d+) pawn$")
    public void they_click_on_the_b_pawn(int arg1) throws Throwable 
    {
    	testAnalysisBoard.clickOnB2Pawn();
    }

    @When("^they click on the c(\\d+) pawn$")
	public void they_click_on_the_c_pawn(int arg1) throws Throwable 
	{
		testAnalysisBoard.clickOnC2Pawn();
	}

    @When("^they click on the d(\\d+) pawn$")
    public void they_click_on_the_d_pawn(int arg1) throws Throwable 
    {
    	testAnalysisBoard.clickOnD2Pawn();
    }

    @When("^they click on the e(\\d+) pawn$")
    public void they_click_on_the_e_pawn(int arg1) throws Throwable 
    {
    	testAnalysisBoard.clickOnE2Pawn();
    }

    @When("^they click on the f(\\d+) pawn$")
    public void they_click_on_the_f_pawn(int arg1) throws Throwable 
    {
    	testAnalysisBoard.clickOnF2Pawn();
    }

    @When("^they click on the g(\\d+) pawn$")
    public void they_click_on_the_g_pawn(int arg1) throws Throwable 
    {
    	testAnalysisBoard.clickOnG2Pawn();
    }

    @When("^they click on the h(\\d+) pawn$")
    public void they_click_on_the_h_pawn(int arg1) throws Throwable 
    {
    	testAnalysisBoard.clickOnH2Pawn();
    }


    @Then("^an option to move the pawn to \"([^\"]*)\" is shown$")
    public void an_option_to_move_the_pawn_to_is_shown(String arg1) throws Throwable 
    {
    	testAnalysisBoard.setExpectedPawnDestination(arg1);
        Assert.assertTrue(testAnalysisBoard.expectedPawnDestinationIsVisible());
    	Assert.assertArrayEquals("The destination is actually " + testAnalysisBoard.expectedPawnLocation(), testAnalysisBoard.expectedPawnLocation().toCharArray() , testAnalysisBoard.expectedPawnDestinationCharArr());

    }
    

    @Given("^the moves \"([^\"]*)\" have been played$")
    public void the_moves_have_been_played(String arg1) throws Throwable 
    {
    	testAnalysisBoard.moveE2toE4();
    	testAnalysisBoard.moveE7toE5();
    	testAnalysisBoard.ruyLopezmoveNg1tof3();
    	testAnalysisBoard.moveNb8toc6();
    	
    }

    @When("^the move \"([^\"]*)\" is played$")
    public void the_move_is_played(String arg1) throws Throwable 
    {
    
    	testAnalysisBoard.moveBf1toc6();
    }

    @Then("^the opening display shows \"([^\"]*)\"$")
    public void the_opening_display_shows(String arg1) throws Throwable 
    {
    	testAnalysisBoard.waitUntilExpectedOpening(arg1);
    
    	Assert.assertArrayEquals("Actual opening : " + testAnalysisBoard.displayedOpening(), arg1.toCharArray(), testAnalysisBoard.displayedOpening().toCharArray());
    }



    @After
    public void afterTest() 
    {
    	if (driver != null) 
    	{
    		driver.quit();
    	}
    }
    
}
