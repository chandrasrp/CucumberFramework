Feature: Login into account at webdriveruniversity using logon portal

Background:
Given User navigates to webdriveruniversity.com
And I clicks on the login portal button
And I enters a username

Scenario: Log into account with valid credentials
And I enters "valid" password
When I clicks on the login button
Then I should be presented with a successful validation alert

Scenario: Log into account with invalid credentials

And I enters "invalid" password
When I clicks on the login button
Then I should be presented with a unsuccessful validation alert