Feature: SauceLabs Login
  User is able to login with correct credentials, add item to the cart, checkout, fill in the fields, finish the order and go to home page.


  @browser
  Scenario: User is able to make an order in saucedemo webpage
    Given user is navigated to page 'https://www.saucedemo.com/'
    When user enters login 'standard_user' and password 'secret_sauce'
    And user clicks button to login
    When user adds item to cart
    And user clicks cart button
    When user sees item 'Sauce Labs Bike Light'
    And user clicks checkout button
    When user enter name 'Agita' and lastname 'Karklite' and zip 'LV-4201'
    And user clicks continue button
    When checkout data is correct
    And user clicks finish button
    Then order is created successfully

@browser
Scenario: User sees correct error messages
  Given user is navigated to page 'https://www.saucedemo.com/'
  When user enters login 'standard_user' and password 'secret_sauce'
  And user clicks button to login
  When user adds item to cart
  And user clicks cart button
  And user clicks checkout button
  Then users sees error message '<errors_text>'
  Examples:
    | name  | lastname | zip     | errors_text                    |
    | Agita |          |         | Error: Last Name is required   |
    | Agita | Karklite |         | Error: Postal Code is required |
    |       | Karklite | LV-4201 | Error: First Name is required  |



