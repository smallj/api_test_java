Feature: Support Admin Retailer gets

    Scenario: Login
        Given I have entered username: "user1@loadtest.com" and password: "crown123"
        When I do a login request
        Then I should contain a JWT token

    Scenario: Get a single retailer
        Given  I have logged in.
        When    I request a retailer with id "49"
        Then response should contain:
            """
            {
              "id": 49,
              "name": "Action Lift",
              "code": "01450",
              "type": "DLR",
              "editable": true,
              "bodyType": "Retailer"
            }
            """