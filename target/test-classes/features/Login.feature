Feature: Application Login

Scenario: Login with valid credentials

Given open any browser
And Navigate to login page
When user enters username as "phaniatw2@gmail.com" and password as "atw@123"
And user clicks on login button
Then verify user is able to successfully login