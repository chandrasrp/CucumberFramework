Feature: send message to webdriveruniversity.com using contact us form

Scenario: Submit valid data via contact us form
	Given I access webdriveruniversity contact us form
	When I enter a valid firstname
	And I enter a valid lastname
	|woods|jack|jones|
	And I enter valid email address
	And I enter comments
	|example comment one|example comment two|
	And I click on the submit button
	Then the information successfully be submitted 
	