# Documentation 

### Introduction:
Api that provides some insights about SpaceX flights

### Requirements that I have implement are as follows:
1. Calculate overall success rate of all rockets
2. Calculate total load sent to space using all rockets
3. Calculate total load sent to space using Falcon
4. Calculate total number of all launches
5. Calculate total number of successful launches
6. Calculate total time in space of all Crew Dragon flights

### Swagger UI
 - https://spacex-flights-dev.herokuapp.com/swagger-ui/index.html#/
 
## How to run the project

### Using Docker
- Make sure you are under spacex-flight-api folder and then run ``` mvn package ``` then run the following commands
- ``` docker build -t spacex-flights . ```
- ``` docker run -it -p 8080:8080 --rm spacex-flights ```


### Endpoints
