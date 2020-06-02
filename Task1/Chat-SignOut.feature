Feature: As as user I should be able to chat with others
  in the Therapist Chat section
  And I should be logged out, when I click on Logout link.  

  Background:
    Given user logged with username "NGY3621" and password "28272708"

  Scenario: user should be able to type and send to the chat window
    When user is on the chat screen and type text "Hello World"
    Then user should see the same text in the chat window

  Scenario: user should be logged out after clicking on logout
    When clicks on "More" tab
    And clicks on "LOGOUT"
    Then user should be logged out and land on sign in screen
