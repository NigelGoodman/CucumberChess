package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class analysisBoard 
{
	private static WebDriver driver;
	private static char[] titleOfPage = "Analysis board • lichess.org".toCharArray();
	private static By analysisSwitch = By.className("switch");
	private static By currentEvaluation = By.tagName("pearl");
	
	
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
}