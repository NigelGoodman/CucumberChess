package seleniumgluecode;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class CucumberChessAnalysis 
{
	public static WebDriver driver;
        
    @Given("^the user is on lichess$")
    public void the_user_is_on_lichess() throws Throwable 
    {
        // Write code here that turns the phrase above into concrete actions
    	System.setProperty("webdriver.gecko.driver","geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://lichess.org/");
    }

    @Given("^they hover over the tools menu$")
    public void they_hover_over_the_tools_menu() throws Throwable 
    {
    	Actions moveOverItem = new Actions(driver);
    	moveOverItem.moveToElement(driver.findElement(By.cssSelector("#topmenu > section:nth-child(5) > a:nth-child(1)"))).build().perform();

    }

    @When("^they click on Analysis board$")
    public void they_click_on_Analysis_board() throws Throwable 
    {
        driver.findElement(By.linkText("Analysis board")).click();
    }

    @Then("^They are taken to the analysis board$")
    public void they_are_taken_to_the_analysis_board() throws Throwable 
    {
        Assert.assertArrayEquals("You are actually on " + driver.getTitle(), driver.getTitle().toCharArray(), "Analysis board • lichess.org".toCharArray());
        driver.close();
    }
    
    @Given("^the user is on the analysis board$")
    public void the_user_is_on_the_analysis_board() throws Throwable 
    {
        this.the_user_is_on_lichess();
        this.they_hover_over_the_tools_menu();
        this.they_click_on_Analysis_board();
    }

    @When("^they turn the analysis on$")
    public void they_turn_the_analysis_on() throws Throwable 
    {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.className("switch")).click();
    }

    @Then("^analysis activates$")
    public void analysis_activates() throws Throwable 
    {
    	
        WebDriverWait wait = new WebDriverWait(driver, 20);
    	wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.tagName("pearl")), "+0.2"));
    	Assert.assertArrayEquals("actualText " + driver.findElement(By.tagName("pearl")).getText(), "+0.2".toCharArray(), driver.findElement(By.tagName("pearl")).getText().toCharArray());
        driver.close();
    }
}
