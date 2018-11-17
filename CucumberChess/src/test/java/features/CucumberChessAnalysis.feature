@tag
Feature: The user can use the lichess analysis board
  I want the user to be able to navigate to and use the analysis board on lichess.org

Scenario: Go to Analysis board
 Given the user is on lichess
 And they hover over the tools menu
 When they click on Analysis board
 Then They are taken to the analysis board
 
Scenario: Turn on analysis
 Given the user is on the analysis board
 When they turn the analysis on
 Then analysis activates
 
Scenario Outline: Move pips shown for knights from opening squares
	Given the user is on the analysis board
	When they click on the <knight> knight
	Then an option to move the knight to <location1> is shown
	And an option to move knight to <location2> is shown
	Examples: 
	| knight | location1 | location2 |
	|   b1   |     a3    |    c3     |
	|   g1   |     f3    |    h3     |
	
Scenario Outline: Move pips shown for pawns from opening squares
	Given the user is on the analysis board
	When they click on the <pawn> pawn
	Then an option to move the pawn to <location1> is shown
	And an option to move the pawn to <location2> is shown
	Examples: 
	| pawn   | location1   | location2   |
	|   a2   |     "a3"    |    "a4"     |
  |   b2   |     "b3"    |    "b4"     |
	|   c2   |     "c3"    |    "c4"     |
	|   d2   |     "d3"    |    "d4"     |
	|   e2   |     "e3"    |    "e4"     |
	|   f2   |     "f3"    |    "f4"     |
	|   g2   |     "g3"    |    "g4"     |
	|   h2   |     "h3"    |    "h4"     |	
	
Scenario: Playing the Ruy Lopez is recognised as by the opening display
	Given the user is on the analysis board
	And the moves "1. e4 e5 2. Nf3 Nc6" have been played
	When the move "3. Bb5" is played
	Then the opening display shows "C60 Ruy Lopez"
	