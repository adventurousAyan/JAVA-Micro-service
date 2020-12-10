# JAVA-Micro-service
Java Repositories for Micro-services

1) Order Micro-service - Responsible for fetching Orders, Creating Orders. It calls Order Item Micro-service to add the Order Items

Sample JSON for creating Order :-

{
  "customerName": "Ayan", 
  "orderDate": "2020-12-10",
  "orderItems": [
    {     
      "orderId": 0,
      "perItemCost": 20,
      "productCode": "PA3",
      "productName": "Shampoo",
      "quantity": 2
    }
  ],
  "shippingAddress": "Hyd",
  "total": 0
}

Swagger URL - http://localhost:8080/swagger-ui.html


2) Order-Item Microservice - Responsible for Creating Order Items, once Order has been created. Also fetches Order Items for a particular Order Id and also create single order item.

Sample Json Structure:-

[
  {    
    "orderId": 6,
    "perItemCost": 20,
    "productCode": "AS",
    "productName": "AS",
    "quantity": 1
  }
]


Swagger URL - http://localhost:8090/swagger-ui.html

*** Both micro-services uses Feign Client for communication between them

*** Uses H2 DB as Temprary Data Store

*** Uses Global Exception Handler for exceptions and validates User Input

*** API's exposed as REST API's



