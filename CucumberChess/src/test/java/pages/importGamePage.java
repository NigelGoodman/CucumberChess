package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class importGamePage 
{
	private static WebDriver driver;
	private static char[] titleOfPage = "Import game • lichess.org".toCharArray();
	private static By pasteBox = By.id("pgn");
	private static By submitButton = By.cssSelector(".submit");
	private static By gameInfo = By.cssSelector(".game_infos");//By.className("spinner");
	
	public importGamePage(WebDriver testDriver) 
	{
		driver = testDriver;
	}
	
	public char[] titleOfPage()
	{
		return titleOfPage;
	}
	
	public void clickPasteBox()
	{
		driver.findElement(pasteBox).click();		
	}
	
	public void clickSubmitButton()
	{
		driver.findElement(submitButton).click();		
	}
	
	public void insertTextIntoPasteBox(String PGNText)
	{
		driver.findElement(pasteBox).clear();
		driver.findElement(pasteBox).sendKeys(PGNText);
	}
	
	public boolean gameInfoIsVisible()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(gameInfo)));
		return driver.findElement(gameInfo).isDisplayed();
		
	}
	

}
