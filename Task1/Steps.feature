Feature: As as user I should be able to add steps and sync wearables
  so that I can the same in the steps section

  Background:
    Given user logged with username "NGY3621" and password "28272708"

  Scenario: Add steps from home screen as well from My therapy week
    When user clicks on ADD STEPS button from "Home Screen"
    Then user is displayed with "Add Steps" Screen
    When user adds 2000 steps
    Then 16 minutes and 1 kilometer is automatically populated

  Scenario: Add steps from home screen as well from My therapy week and save it
    Given user already has 1000 steps in his bucket
    When user clicks on ADD STEPS button from "Home Screen"
    And user adds 2000 steps and saves it
    Then user steps are updated with 3000

  Scenario: user should be able to sync wearables
    When user clicks on "Sync Wearables" link on the home screen
    Then user should be displayed with list of 3rd party wearables
    When user clicks on one of the wearables
    Then user should see respective wearable landing app screen
