Feature: Amazon

  Background: 
    Given User launches the browser and opens the "Amazon" url
    When User verifies the title "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in" of the "Amazon Home" page

  Scenario: User verifies the title of page
    Then User verifies "Search Bar" is "displayed" on Amazon Home page
    When User verifies "Search Dropdown" is "displayed" on Amazon Home page
    Then User verifies "All Category" is "selected" for "Search Dropdown" on Amazon Home page
    And User verifies "46" values are displayed in "Search Dropdown" on Amazon Home page
    And User enters "JBL" in the "Search Bar" textfield on Amazon Home page
    And User clicks on "Search" button on Amazon Home page
