Feature: Reqres Register API

Scenario: verify Success Scenario for Register API of Reqres website
Given valid email and password as payload for register api
When register api is called as POST http request
Then it should give 200 in response
And id and token should display in response