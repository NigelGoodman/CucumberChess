package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class analysisBoard 
{
	private static WebDriver driver;
	private static char[] titleOfPage = "Analysis board • lichess.org".toCharArray();
	private static By analysisSwitch = By.className("switch");
	private static By currentEvaluation = By.tagName("pearl");
	private static By b1Knight = By.cssSelector("piece.white:nth-child(26)");
	private static By dest1 = By.cssSelector("square.move-dest:nth-child(2)");
	private static By dest2 = By.cssSelector("square.move-dest:nth-child(1)");
		
	
	public analysisBoard(WebDriver testDriver) 
	{
		driver = testDriver;
	}
	
	public char[] titleOfPage()
	{
		return titleOfPage;
	}

	public void turnOnAnalysis()
	{		
		driver.findElement(analysisSwitch).click();
	}
	
	public String returnCurrentEvaluation()
	{
		return  driver.findElement(currentEvaluation).getText();
	}
	
	public void waitUntilExpectedEvaluation(String expectedEval)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(currentEvaluation), expectedEval));
	}
	
	public void clickOnb1Knight()
	{		
		Actions moveToLocOnBoard = new Actions(driver);
		
		moveToLocOnBoard.moveToElement(driver.findElement(b1Knight));
		moveToLocOnBoard.click();
		moveToLocOnBoard.perform();
		//driver.findElement(b1Knight).click(); // lichess seems to have placed the board on top of the actual pieces. 
												// Using actions to work around this issue
	}
	
	public boolean dest1IsVisible()
	{
		return driver.findElement(dest1).isDisplayed();
		
	}
	
	public String dest1Location()
	{
		return driver.findElement(dest1).getAttribute("style").substring(21, driver.findElement(dest1).getAttribute("style").length()-2);//(21);
		
	}
	
	public boolean dest2IsVisible()
	{
		return driver.findElement(dest2).isDisplayed();
		
	}
	
	public String dest2Location()
	{
		return driver.findElement(dest2).getAttribute("style").substring(21, driver.findElement(dest2).getAttribute("style").length()-2);//(21);
		
	}
}