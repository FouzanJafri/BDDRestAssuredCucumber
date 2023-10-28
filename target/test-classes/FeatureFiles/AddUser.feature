Feature: Validating Place API's

  Scenario Outline: Verify if user has been using AddUser
    Given "Register" User Payload
    When user calls "RegisterAPI" with "Post" http request
    Then the api call should be sucess with status code "200"
    And status code should be "OK"
    And user should view with id Post http request
    And get Users "<name>" and "<job>"
    When user calls "GetUser" with "get" http request

    Examples: 
      | name     | job    |
      | morpheus | leader |
      | Fouzan   | CEO    |
      | Test1    | Test1  |
      | Test2    | Test2  |

