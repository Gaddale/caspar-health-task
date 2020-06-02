Feature: As as user I should be able to see my knowledge videos
  on the home screen as well as on the My therapy week screen

  Background:
    Given user logged with username "NGY3621" and password "28272708"

  Scenario: Knowledge screen should be displayed from home screen as well as My therapy week screen
    When user taps on KNOWLEDGE section
    Then user should land on KNOWLEDGE screen with multiple videos displayed
    When user taps on KNOWLEDGE section from My therapy week screen
    Then user should land on KNOWLEDGE screen with multiple videos displayed

  Scenario: Knowledge section number should match to the number of videos displayed
    When user is displayed with 21 videos on the KNOWLEDGE section
    Then user is displayed 21 videos on the KNOWLEDGE screen

  Scenario: User should be able to tap a video and play it
    When user on the KNOWLEDGE screen
    And user taps on any one of the video and plays it
    Then video should be played

  Scenario: User watches a complete video, count should be reduced by 1 for the videos to be watched
    When user is displayed with 21 videos on the KNOWLEDGE section
    When user taps on KNOWLEDGE section
    And user taps on any one of the video and plays it
    Then videos count should be reduced to 20 on home screen





