Feature: Validating AddPlace API's

Scenario Outline: Verify if place is being successfully added using AddPlace API
	Given Add place payload with "<name>" "<language>" "<address>"
	When User calls "AddPlaceAPI" with POST http request
	Then The API call got success with status code 200
	And "status" in response body is "OK"
	
	Examples:
		|name  |language|address  |
		|Tarun |Hindi   |Tirtol   |
		|Sarada|Odia    |Manijanga|