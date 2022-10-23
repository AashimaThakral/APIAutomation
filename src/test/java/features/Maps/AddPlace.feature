Feature: Add Place Api

Scenario: Verify Success Scenario for Add Place Api
Given valid request payload is passed for add place api
When add place api request is called
Then it should give 200 status code in response
And "status" in response should be "OK"
  And "scope" in response should be "APP"