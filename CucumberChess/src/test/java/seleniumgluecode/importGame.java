package seleniumgluecode;

import java.awt.MenuBar;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
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


public class importGame 
{
	public static WebDriver driver;
	public static menuBar testMenuBar;
	public static importGamePage testImportGamePage;
	public static analysisBoard testAnalysisBoard;
	
	@Before
    public void beforeTest()
    {
		if (driver != null) {
	    	driver.quit();}
    	System.setProperty("webdriver.gecko.driver","geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
    }
	
	@Given("^the user is on lichess\\.org$")
	public void the_user_is_on_lichess_org() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
        driver.get("http://lichess.org/");
	}

	@Given("^they hover over the tools menu to import a game$")
	public void they_hover_over_the_tools_menu_to_import_a_game() throws Throwable {
	    testMenuBar = new menuBar(driver);
	    testMenuBar.hoverOverTools();
	}
	
	@When("^they click on Import game$")
	public void they_click_on_Import_game() throws Throwable 
	{
		
	    //testMenuBar = new menuBar(driver);
	    //testMenuBar.hoverOverTools();
	    testMenuBar.clickImportGame();
	}

	@Then("^they are taken to the Import game page$")
	public void they_are_taken_to_the_Import_game_page() throws Throwable 
	{
	    testImportGamePage = new importGamePage(driver);
	    Assert.assertArrayEquals("Actually on page : " + driver.getTitle() , testImportGamePage.titleOfPage(), driver.getTitle().toCharArray());
	}

	@Given("^the user is on the Import game page$")
	public void the_user_is_on_the_Import_game_page() throws Throwable {
		the_user_is_on_lichess_org();
		they_hover_over_the_tools_menu_to_import_a_game();
		they_click_on_Import_game();
		they_are_taken_to_the_Import_game_page();
	}

	@Given("^they have pasted inthe PGN for \"([^\"]*)\"$")
	public void they_have_pasted_inthe_PGN_for(String arg1) throws Throwable 
	{
		String game = this.readFile("uruguayanImmortal.txt", Charset.defaultCharset());
	    testImportGamePage.clickPasteBox();
	    testImportGamePage.insertTextIntoPasteBox(game);
	}

	@When("^they click the import game button$")
	public void they_click_the_import_game_button() throws Throwable 
	{
	    testImportGamePage.clickSubmitButton();
	}

	@Then("^they are taken to the imported \"([^\"]*)\"$")
	public void they_are_taken_to_the_imported(String arg1) throws Throwable {
	    Assert.assertTrue("The infobox is not visible ", testImportGamePage.gameInfoIsVisible());;
	}
	
	@Given("^the user has imported the \"([^\"]*)\"$")
	public void the_user_has_imported_the(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the correct player names are displayed$")
	public void the_correct_player_names_are_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
		
	private String readFile(String path, Charset encoding) throws IOException 
	{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
	
	@After
    public void afterTest() 
    {
    	if (driver != null) {
    	driver.quit();}
    }


}
