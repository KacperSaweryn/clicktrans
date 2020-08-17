Feature: ProperForm

  @ProperForm
  Scenario: ProperForm
    Given User is on site "https://dev-1.clicktrans.pl/register-test/courier"
    When User fill Pełna nazwa firmy
    And User fill Email
    And User fill Imię i nazwysko
    And User fill Polish phone number
    And User fill 8 digit long password
    And User click on Zapoznałem się z regulaminem checkbox
    And User click on second checkbox
    And User click Zarejestruj button
    Then User is registered
