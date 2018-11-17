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
	private static By b1Knight = By.cssSelector("piece.white.knight:nth-child(26)");
	private static By g1Knight = By.cssSelector("piece.white.knight:nth-child(31)");
	private static By ruyLopezg1Knight  = By.cssSelector("piece.white.knight:nth-child(33)");
	private static By b8Knight = By.cssSelector("piece.black.knight:nth-child(4)");
	private static By f1Bishop = By.cssSelector("piece.white.bishop:nth-child(32)");
	private static By a2Pawn = By.cssSelector("piece.white.pawn:nth-child(17)");
	private static By b2Pawn = By.cssSelector("piece.white.pawn:nth-child(18)");
	private static By c2Pawn = By.cssSelector("piece.white.pawn:nth-child(19)");
	private static By d2Pawn = By.cssSelector("piece.white.pawn:nth-child(20)");
	private static By e2Pawn = By.cssSelector("piece.white.pawn:nth-child(21)");
	private static By f2Pawn = By.cssSelector("piece.white.pawn:nth-child(22)");
	private static By g2Pawn = By.cssSelector("piece.white.pawn:nth-child(23)");
	private static By h2Pawn = By.cssSelector("piece.white.pawn:nth-child(24)");
	private static By dest1 = By.cssSelector("square.move-dest:nth-child(1)");
	private static By dest2 = By.cssSelector("square.move-dest:nth-child(2)");
	private static By dest3 = By.cssSelector("square.move-dest:nth-child(3)");
	private static By e7Pawn = By.cssSelector("piece.black.pawn:nth-child(15)");
	private static By openingBox = By.className("opening_box");
	private static String expectedDestinationString;
	private static By expectedDestinationBy;
		
	
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
	
	public void waitUntilExpectedString(String expectedString, By usedElement)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(usedElement), expectedString));
	}
	
	public void waitUntilExpectedEvaluation(String expectedEval)
	{
		waitUntilExpectedString(expectedEval, currentEvaluation);
	}
	
	public void waitUntilExpectedOpening(String expectedOpening)
	{
		waitUntilExpectedString(expectedOpening, openingBox);
	}
	
	private void clickOnPiece(By pieceName)
	{
		Actions moveToLocOnBoard = new Actions(driver);
		
		moveToLocOnBoard.moveToElement(driver.findElement(pieceName));
		moveToLocOnBoard.click();
		moveToLocOnBoard.perform();
		//driver.findElement(b1Knight).click(); // lichess seems to have placed the board on top of the actual pieces. 
												// Using actions to work around this issue
	}
	
	public void clickOnb1Knight()	//specific piece clicking is done using the generic generic piece move function, these are for the tests to use
	{		
		this.clickOnPiece(b1Knight);
	}
	
	public void clickOng1Knight()
	{		
		this.clickOnPiece(g1Knight);
	}
	
	public void clickOnA2Pawn()
	{		
		this.clickOnPiece(a2Pawn);
	}
	
	public void clickOnB2Pawn()
	{		
		this.clickOnPiece(b2Pawn);
	}
	
	public void clickOnC2Pawn()
	{		
		this.clickOnPiece(c2Pawn);
	}
	
	public void clickOnD2Pawn()
	{		
		this.clickOnPiece(d2Pawn);
	}
	
	public void clickOnE2Pawn()
	{		
		this.clickOnPiece(e2Pawn);
	}
	
	public void clickOnF2Pawn()
	{		
		this.clickOnPiece(f2Pawn);
	}
	
	public void clickOnG2Pawn()
	{		
		this.clickOnPiece(g2Pawn);
	}
	
	public void clickOnH2Pawn()
	{		
		this.clickOnPiece(h2Pawn);
	}
	
	public void moveE2toE4()
	{
		this.clickOnPiece(e2Pawn);
		this.clickOnPiece(dest1);
	}
	
	public void moveE7toE5()
	{
		this.clickOnPiece(e7Pawn);
		this.clickOnPiece(dest1);
	}
	
	public void ruyLopezmoveNg1tof3()
	{
		this.clickOnPiece(ruyLopezg1Knight);
		this.clickOnPiece(dest3);
	}
	
	public void moveNb8toc6()
	{
		this.clickOnPiece(b8Knight);
		this.clickOnPiece(dest1);
	}
	
	public void moveBf1toc6()
	{
		this.clickOnPiece(f1Bishop);
		this.clickOnPiece(dest2);
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
	
	public void setExpectedPawnDestination(String expectedDestination)
	{
		switch(expectedDestination)
		{
			case "a3" : expectedDestinationString = "0px, 256px"; expectedDestinationBy = dest1; break;			// This setup allows us to use the same assertions for all pawn moves.
			case "a4" : expectedDestinationString = "0px, 320px"; expectedDestinationBy = dest2; break;			// Depending on the co-ordinate given, the expected destination of
			case "b3" : expectedDestinationString = "64px, 256px"; expectedDestinationBy = dest1; break;		// the co-ordinate in its attribute is set to the expected destination string
			case "b4" : expectedDestinationString = "64px, 320px"; expectedDestinationBy = dest2; break;		// and the option that destination is represented by is set.
			case "c3" : expectedDestinationString = "128px, 256px"; expectedDestinationBy = dest1; break;
			case "c4" : expectedDestinationString = "128px, 320px"; expectedDestinationBy = dest2; break;
			case "d3" : expectedDestinationString = "192px, 256px"; expectedDestinationBy = dest1; break;
			case "d4" : expectedDestinationString = "192px, 320px"; expectedDestinationBy = dest2; break;
			case "e3" : expectedDestinationString = "256px, 256px"; expectedDestinationBy = dest1; break;
			case "e4" : expectedDestinationString = "256px, 320px"; expectedDestinationBy = dest2; break;
			case "f3" : expectedDestinationString = "320px, 256px"; expectedDestinationBy = dest1; break;
			case "f4" : expectedDestinationString = "320px, 320px"; expectedDestinationBy = dest2; break;
			case "g3" : expectedDestinationString = "384px, 256px"; expectedDestinationBy = dest1; break;
			case "g4" : expectedDestinationString = "384px, 320px"; expectedDestinationBy = dest2; break;
			case "h3" : expectedDestinationString = "448px, 256px"; expectedDestinationBy = dest1; break;
			case "h4" : expectedDestinationString = "448px, 320px"; expectedDestinationBy = dest2; break;
			default : expectedDestinationString = "invalid expected destination for piece";  expectedDestinationBy = null; break;
		}
	}
	
	public boolean expectedPawnDestinationIsVisible()
	{
		return driver.findElement(expectedDestinationBy).isDisplayed();		
	}
	
	public String expectedPawnLocation()
	{
		return driver.findElement(expectedDestinationBy).getAttribute("style").substring(21, driver.findElement(expectedDestinationBy).getAttribute("style").length()-2);//(21);
		
	}
	
	public char[] expectedPawnDestinationCharArr()
	{
		return expectedDestinationString.toCharArray();
		
	}
	
	public String displayedOpening()
	{
		return driver.findElement(openingBox).getAttribute("title");
	}
	
	
}