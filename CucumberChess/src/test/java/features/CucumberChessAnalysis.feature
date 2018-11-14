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
 
Scenario: Move knights from opening squares
	Given the user is on the analysis board
	When they click on the b1 knight
	Then an option to move it to a3 is shown
	And an option to move it to c3 is shown