package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class menuBar 
{
	private static WebDriver driver;
	private static By toolsMenuButton = By.cssSelector("#topnav > section:nth-child(5) > a:nth-child(1)");
	private static By analysisBoardButton = By.linkText("Analysis board");
	private static By importGameButton = By.cssSelector("#topnav > section:nth-child(5) > div:nth-child(2) > a:nth-child(3)");//By.linkText("Import game");
	
	
	
	public menuBar(WebDriver testDriver) 
	{
		driver = testDriver;
	}

	public void hoverOverTools()
	{		
		Actions moveOverItem = new Actions(driver);
    	moveOverItem.moveToElement(driver.findElement(toolsMenuButton)).build().perform();
	}
	
	public void clickAnalysisBoard()
	{
		driver.findElement(analysisBoardButton).click();
	}
	
	public void clickImportGame()
	{
		driver.findElement(importGameButton).click();
	}
}
