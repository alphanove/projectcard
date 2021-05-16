# projectcard

Please refer the api docmentation attached
 

Objective 

The objective of this API is to post the new card details and get the card details from the in memory database.

 

API SPECIFICATION 

API context path		- /cardapi/v1 

Methods 			      - POST and get 

Input message type 	- application json 

Output message type	- application json 

Authentication 			- none – any authentication can be enabled based on the api gateway 				  used 

Possible HTTP Status Code	- 200,400,500,404 

Input sample 

{ 

	"cardNumber":"1556954993914435", 

	"name":"dddd", 

	"limit": 1234 

} 


Output sample 

 

{ 

    "apiStatusCode": "200", 

    "apiStatusMessage": "Card Added Successfully" 

} 

 

High level diagram :

 

Deployment Strategy : 

 

Git Branching strategy :

 

Using Docker and Kubernetes: 

 
