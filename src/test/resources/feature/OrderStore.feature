Feature: Test APIs of Pet Store

  Scenario:To Place an order for a pet with some values
    Given User comes to the pet store
    When User places a request to order pet with Pet Id 123 id 100 quantity 1
    Then Assert Response is successful
    And Response matches content same as "response/pet123Response.json"

    Scenario:To Place an order for a pet with all valid values
    Given User comes to the pet store
    When User places a request to order pet with Pet Id 999 id 121 quantity 2 shipdate "2021-06-17T15:38:50.341Z" status "InProgress" complete "false"
    Then Assert Response is successful
    And Response matches content same as "response/petId999.json"

   Scenario:To Place an order for a pet with invalid values
    Given User comes to the pet store
    When User places a request to order an invalidOrder
    Then Assert Response is badRequest

  Scenario:To Get Order details for pet with valid id
    Given User comes to the pet store
    When User places a request find details with order 2
    Then Assert Response is successful
    And Response matches content same as "response/OrderId1Response.json"

  Scenario:To Get Order details for pet with invalid Id
    Given User comes to the pet store
    When User places a request find details with order 333
    Then Assert Response is notFound
    And Response matches content same as "response/OrderIdInvalidResponse.json"

  Scenario:To Delete Order details for pet with valid id
    Given User comes to the pet store
    When User places a request delete order with order orderid as 2
    Then Assert Response is successful
    And Response matches content same as "response/OrderId1Response.json"

  Scenario:To Delete Order details for pet with non existing id
    Given User comes to the pet store
    When User places a request delete order with order orderid as 4566777
    Then Assert Response is notFound
    And Response matches content same as "response/deletedResponseInvalid.json"
