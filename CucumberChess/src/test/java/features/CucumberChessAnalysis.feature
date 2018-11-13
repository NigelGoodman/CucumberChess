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