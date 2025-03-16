package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class importGamePage 
{
	private static WebDriver driver;
	private static char[] titleOfPage = "Import game • lichess.org".toCharArray();
	private static By pasteBox = By.name("pgn");
	private static By submitButton = By.cssSelector(".submit");
	private static By gameInfo = By.cssSelector(".game__meta__players");
	private static By whitePlayer = By.cssSelector("div.player:nth-child(1) > span:nth-child(1)");
	private static By blackPlayer = By.cssSelector("div.player:nth-child(2) > span:nth-child(1)");
	
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
	
	public String returnPlayerName(By playerName)
	{
		return driver.findElement(playerName).getText().substring(0, driver.findElement(playerName).getText().length()-4);
	}
	
	public String returnWhitePlayerName()
	{
		
		return this.returnPlayerName(whitePlayer);

	}
	
	public String returnBlackPlayerName()
	{
		return this.returnPlayerName(blackPlayer);
	}
}
