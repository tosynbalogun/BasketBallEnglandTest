Feature: User Registration Validation
  As a new user
  I want to register an account on the Basketball England membership site
  So that I can access supporter features and information

  Background:
    Given I am on the New Supporter Account registration page

  @FailWithoutLastName
  Scenario Outline: Attempt to create user without a last name
    When I fill in all required fields except for the Last Name
    And I attempt to submit the form
    Then I should be prevented from creating an account
    And I should see a message indicating the last name is required
    Examples:
      |  |

  @FailWithPasswordMismatch
  Scenario Outline: Attempt to create user with a password that does not match
    When I fill in all required fields
    And I enter Password and ConfirmPassword that do not match
    And I attempt to submit the form
    Then I should be prevented from creating an account
    And I should see a message indicating the passwords do not match
    Examples:
      | Password | ConfirmPassword |
      | Pass1234!| Pass1234!       |

  @FailWithoutTerms
  Scenario Outline: Attempt to create user without accepting terms and conditions
    When I fill in all required fields
    And I do not accept the terms and conditions
    And I attempt to submit the form
    Then I should be prevented from creating an account
    And I should see a message indicating terms and conditions acceptance is required
    Examples:
      |  |

  @Success
  Scenario Outline: Successfully create a user with all required fields filled
    When I fill in all required fields including First Name, Last Name, Email, Password, and accept the terms and conditions
    And I attempt to submit the form
    Then I should be successfully registered
    And I should be redirected to the account dashboard

    Examples:
      | Password   | ConfirmPassword |
      | Pass1234!  | Pass1234!       |
      | WrongPass! | CorrectPass!    |
