# Mini Project-4 Microservices
- Andeas Jørgensen - https://github.com/DDomino
- Jonatan Bakke https://github.com/JonatanMagnusBakke
- Jonas Hein - https://github.com/Zenzus
- Thomas Ebsen - https://github.com/Srax 

## Assignment
Task 1 (10 study points)

Extend the rent-a-car application by adding a new service - user rating of cars. Create and use a MongoDB database as a storage of users. Enable the clients of the application to see

- the ratings of a particular car
- the ratings they selves have given earlier


Task 2 (10 study points)  
Deploy your microservices application in Kubernetes and explore its behaviour.

## Info

#### APIGateway* is the gateway that connects both the `CarCatalog` & `UserRating` so both  of their api's can be called through one program.  
- `CarsCatalog API` : `localhost:8090/cars`
- `UserRating API` : `localhost:5000/users` & `localhost:5000/users/{name}`
- `ApiGateway API` : **Cars:** `localhost:8080/cars` & `localhost:8080/cars/{brand}` **Rtings** `localhost:8080/rating` & `localhost:8080/rating/{name}`

## Setup
What you'll need:
1. Docker to set up Kubernetes.
2. Your favorite IDE that can run java, we use IntelliJ.

## How to run the project
1. Run `Microservices`
2. Run `CarCatalog` & `UserRating`
3. Run `ApiGateway`
4. When they are all running, you should be able to get ratings and cars from the ApiGateway by querying the ApiGateway api.
