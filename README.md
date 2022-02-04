# Documentation 

### Introduction:
REST API that provides insights about SpaceX flights.

### Requirements that I have implement are as follows:
1. Calculate overall success rate of all rockets
2. Calculate total load sent to space using all rockets
3. Calculate total load sent to space using Falcon
4. Calculate total number of all launches
5. Calculate total number of successful launches
6. Calculate total time in space of all Crew Dragon flights

### CI/CD Pipeline
CI/CD are two crucial practices of modern software deployment. 

The continuous early feedback from CI tools allows developers to detect bugs early and track them down more easily. CD prescribes to regularly deploy software artifacts to production environments for user acceptance testing and to obtain customer feedback.

I have setup the pipeline which includes two jobs, one for package and one for deployment.

### Swagger UI
 - https://spacex-flights-dev.herokuapp.com/swagger-ui/index.html#/
 
## How to run the project

- Make sure you are under spacex-flight-api folder and run ``` mvn package ```, then run the following command

- ``` java -jar target/spacex-flight-api-0.0.1-SNAPSHOT.jar ```


### Endpoints

Get overall success rate

```https://spacex-flights-dev.herokuapp.com/rockets/successRate```


Get total load of all rockets

```https://spacex-flights-dev.herokuapp.com/rockets/load```


Get total load of Falcon rockets

```https://spacex-flights-dev.herokuapp.com/rockets/load/falcon```


Get total number of launches

```https://spacex-flights-dev.herokuapp.com/launches/total```


Get total number of successful launches

```https://spacex-flights-dev.herokuapp.com/launches/successful```


Get total time spent in space of all Dragon flights

```https://spacex-flights-dev.herokuapp.com/dragons/totalTime```


## Built With

* [Java](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html) -  Amazon Corretto 11
* [Spring Boot](https://spring.io/projects/spring-boot) - Spring Boot
* [Maven](https://maven.apache.org/) - Dependency Management
* [Docker](https://www.docker.com/) - Containerized App


## Versioning

This project does not have versioning

## Authors 

* **Pellumb Baboci**


## Note: 

When you try to make a request to the live api for the first time, it might take some time because i am using free version of the cloud provider







