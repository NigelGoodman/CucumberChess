@import
Feature: Importing Games
  I want to be able to import a game into Lichess

@import
Scenario: Title of your scenario
  Given the user is on lichess.org
	And they hover over the tools menu to import a game
	When they click on Import game
	Then they are taken to the Import game page

@import    
Scenario: Importing a game takes the user to a loading screen
	Given the user is on the Import game page
	And they have pasted inthe PGN for "The Uruguayan Immortal"
	When they click the import game button
	Then they are taken to the imported "The Uruguayan Immortal"
 		
@import
Scenario: The imported game has the correct player names
	Given the user has imported the "The Uruguayan Immortal"
	When they are taken to the imported "The Uruguayan Immortal"
	Then the white player is "B Molinari"
	And the black player is "Luis Roux Cabral"