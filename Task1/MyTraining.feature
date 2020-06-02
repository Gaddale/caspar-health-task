Feature: As as user I should be able to see my daily trainings
  and access those and practice by myself by seeing the playing videos

  Background:
    Given user logged with username "NGY3621" and password "28272708"

  Scenario: Sections displayed on the home screen
    Then user should land on the home screen with these sections displayed
      | My Training |
      | KNOWLEDGE   |
      | WELLBEING   |
      | Steps       |

  Scenario: User start and do the exercises
    When user is on "My Training" screen
    Then user should be displayed with SETS, REPS numbers and video section
    When user starts the training
    Then user should be displayed with countdown screen from 8 to 1
    And user should see the video playing, repetitions countdown with number of sets increasing
    And user should be able to see a countdown from 4 to 1 between each set

  Scenario: User starts and complete all the exercises assigned
    When user is on "My Training" screen
    And user starts the training
    And user finishes first training
    Then user should be able to continue to the rest of the trainings and complete it

  Scenario: User can skip the training
    When user is on "My Training" screen
    And user starts the training
    And user skips the training when its is process
    Then in progress training should be skipped and land on "My Training" screen
    And user is displayed with next training to be started

  Scenario: Verify the numbers of trainings played matches to the number displayed "My Training" section
    When user is on "Home screen"
    And user taps on "My training" section with 6 trainings displayed on the top right corner
    Then user starts the training, 6 trainings should be played one after another
    When user finishes 1 training and skips
    Then user should be displayed with 5 trainings remaining on the "My Training" section of the home screen

  Scenario: User can pause the training
    When user is on "My Training" screen
    And user starts the training
    And user pause the training
    Then video and repetition countdown should be paused
    And resumed again once clicked on pause

  Scenario: User can play, pause, fast forward and go backward the video in trainings
    When user is on "My Training" screen
    And user starts the training
    And user play, pause, fast forward and go backward the video
    Then user should see respective operations performed on the video

  Scenario: User can update the speed of the exercise
    When user is on "My Training" screen
    And user updates the speed from medium to high
    And user starts the training
    Then user should see the exercise video played faster than medium speed

  Scenario: User set settings to view yourself while doing
    When user is on "My Training" screen
    And user change setting "Do you want to view yourself while doing the exercise" to on
    And user starts the training
    Then user should be able to view himself while doing the exercise

