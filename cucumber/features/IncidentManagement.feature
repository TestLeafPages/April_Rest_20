Feature: Incident Management

#Background:
#Given set the Endpoint
#And set the Authorization

Scenario: Create a new Incident with File
And set the content type as json
When send the request as post with file Incident1.json
Then confirm the response status code is 201
And confirm the response type is json

Scenario Outline: Create a new Incident with Multi File
And set the content type as json
When send the request as post with file <File>
Then confirm the response status code is 201
And confirm the response type is json

Examples:
#|HeaderName1|HeaderName2|
#|Data11|Data12|
|File|
|Incident1.json|
|Incident2.json|