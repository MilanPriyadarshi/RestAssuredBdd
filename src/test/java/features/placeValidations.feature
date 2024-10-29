Feature: Validating AddPlace API's

Scenario: Verify if place is being successfully added using AddPlace API
	Given Add place payload
	When User calls "AddPlaceAPI" with POST http request
	Then The API call got success with status code 200
	And "status" in response body is "OK"