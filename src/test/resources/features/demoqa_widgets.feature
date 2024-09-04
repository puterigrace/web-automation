Feature: Interact with Widgets on DemoQA

  Scenario: Verify the Slider functionality
    Given I am on the Widgets page
    When I interact with the Slider
    Then I should see the updated slider value
