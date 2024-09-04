Feature: Fill out Forms on DemoQA

  Scenario: Fill out and submit a form
    Given I am on the DemoQA homepage
    And I click on the Forms section
    When I fill out the form with valid data
    And I submit the form
    Then I should see a success message
