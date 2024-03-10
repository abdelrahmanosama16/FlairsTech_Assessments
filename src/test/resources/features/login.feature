Feature: Login and user management

  Scenario: Add and delete user
    Given I am on the login page
    When I enter username "Admin" and password "admin123" and click login
    Then I should be on the admin page
    When I click on the Admin tab
    And I get the number of records before adding a new user
    When I add a new user with required data
    Then I should see the number of records increased by 1
    When  I search for the new user
    And I delete the new user
    Then I should see the number of records decreased by 1