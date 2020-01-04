#Author: wingtak7@gmail.com

@tag
Feature: Amazon Key Term Search
  I want to use this template for my feature file

  @KeyTermSearch
  Scenario Outline: Search with a specific key term
    Given Launch the Amazon home page
    When I enter <keyterm> into search bar and search
    Then Result should bring up and Displaying total number of results    
    
    Examples:
    | keyterm              |
    | software development |
    | hardware             |
    
  @PartialKeyTerm
  Scenario Outline: Search with a partial key term
    Given Launch the Amazon home page
    When I enter a partial keyterm <partial term>
    Then Related keyterm will display & clicking on any will bring related item
    
    Examples:
	  | partial term         |
    | software             |
 
