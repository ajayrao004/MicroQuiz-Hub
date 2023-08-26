# MicroQuiz-Hub
## Description:
This project demonstrates the implementation of a microservices architecture using Spring Cloud. It consists of multiple services, an API Gateway, and a Service Registry to manage 
the communication and discovery between the services.
## Overview
We have two key services:
1. **Quiz Service:** The Quiz Service is responsible for the orchestration and management of quizzes. It allows users to create new quizzes, access quiz questions, submit responses, 
and retrieve quiz results. Leveraging microservices principles, this service ensures the seamless execution of quiz-related operations.
2. **Question Service:** The Question Service deals with the management of questions and quiz content. It enables users to fetch questions based on categories, add new questions,
update existing ones, and delete questions. By adopting a microservices approach,this service ensures efficient organization and retrieval of question data.

We use API-Gateway and Service-Registry to communicate between Question Service and Quiz Service:
1. **API Gateway:** Serving as the primary entry point, the API Gateway centralizes incoming requests from external clients. It handles request routing, load balancing, and security 
enforcement. The API Gateway ensures that users can access the appropriate services without needing to understand the underlying architecture.
2. **Service Registry:** The Service Registry, powered by Spring Cloud Eureka, facilitates service registration and discovery. Each microservice registers itself with the registry,
allowing other services to dynamically locate and interact with available instances. This enhances the application's resilience and scalability.

## Features and Operations:
1. **Quiz Service:**
* Create Quiz: Users can create new quizzes by specifying the desired category and the number of questions.
* Fetch Quiz Questions: The service fetches a set of quiz questions based on the user's criteria, such as category and question count.
* Submit Responses: Users can submit their responses to quiz questions for evaluation.
* Get Quiz Result: The service calculates and returns the user's quiz result based on the submitted responses.
2. **Question Service:**
* Fetch Questions by Category: Users can retrieve a list of questions belonging to a specific category.
* Add New Question: Users can contribute to the question bank by adding new questions along with their options and correct answers.
* Update Question: The service allows users to modify existing questions, their options, or correct answers.
* Delete Question: Users have the option to remove questions from the database.

## Steps to Setup and run the appication:
1. Clone the repository using Git Bash: git clone https://github.com/ajayrao004/MicroQuiz-Hub.git
2. Navigate to each module's directory (e.g.,quiz-service, question-service, api-gateway, service-registry) 
3. Run each services from main component(e.g: QuestionserviceApplication)
4. Dowmload Postgres SQL create a questiondb(It contains questions table),quizdb (quiz table which contains generated quiz by REST API's)
5. Test the RESTFul API's using Postman for each of the operation in quiz and question service.

## Tools & Technologies Used:                      
Java,Spring Boot ,Spring Cloud (Eureka, OpenFeign),Spring Data JPA,Hibernate (ORM),Microservices Architecture,RESTful APIs,Postgres SQL,POSTMAN,Eclipse IDE



