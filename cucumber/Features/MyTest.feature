#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: New user registration

Scenario Outline: Registration biblitheque
 
Given I am on a new user registration page

When Enter Username <nom> Surname <prenom> lieunais <lieun> status <stat> passwd <passwd> birthday <datenaissance>

Then the user registration should be successful

Examples: 
 
 |	nom			|	prenom	|	lieun	|	stat			|	passwd				|	datenaissance	|
 
 |	slyvain	|	zongo		|	Hanoi	|	Adherent	|	zongouu				|	20180929		|
 
 



