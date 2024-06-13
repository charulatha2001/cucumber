@Feature1
Feature: To check the mynthra application

Background:
Given To launch the url of the Browser
When To launch the url


  @tag1
  Scenario: To check the Women section
    And To pass the womens wear 
    And To pass the men wear
    And To check whether it navigate to the homepage or not
    Then To close the browser

  @tag2
  Scenario Outline: To validate the things browsing system
    And To pass the value "<women>" in women session
    And To pass the value "<men>"   in men session
    And To pass the value "<Kids>"  in kids session
    Then To close the browser

    Examples: 
      | women       |     men    | Kids         |
      | kurtas      |     shirts | girls kurtas |
      | western top |     pants  | Boy salwar   |
