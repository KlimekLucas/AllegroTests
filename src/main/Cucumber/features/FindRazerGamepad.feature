Feature: FindRazerGamepad

  Scenario: FindRazerGamepad
    Given Open page: https://allegro.pl
    When  AcceptCookies
    And SearchForProduct Razer Gamepad
    And SetMax Price 500
    Then take Screenshot




