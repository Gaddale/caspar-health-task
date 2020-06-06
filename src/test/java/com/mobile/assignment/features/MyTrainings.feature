Feature: Test My Trainings

  Background:
    Given user login to the app

  Scenario: Match Exercise count
    When user captures the exercise count and lands on Training overview screen
    Then exercise count should match
    When user is ready for the training
    Then exercise count should match the exercise progress

  Scenario: Skip the training once started
    When user captures the exercise count and lands on Training overview screen
    Then user can skip all the exercises


