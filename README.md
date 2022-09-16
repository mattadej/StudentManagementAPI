src/main/java coverage: 80%

# StudentManagementAPI

This is a Spring Boot web application for teachers to manage a database of students.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

#### Java

The JDK can be downloaded from [here](https://www.oracle.com/java/technologies/downloads/)

Make sure to run the installer with admin privileges

Instructions on how to add Java to your **_PATH_** can be found [here](https://www.ibm.com/docs/en/b2b-integrator/5.2?topic=installation-setting-java-variables-in-windows)

#### Eclipse

Go to this link to [download Eclipse](https://www.eclipse.org/downloads/)

Download the **_x84_x64_** executable.

Run the exe. and follow the instruction in the download wizard to complete the installation.

#### MySQL Server

Go to this link to [download MySql](https://dev.mysql.com/downloads/windows/installer/8.0.html)

Download the **_mysql-installer-community-8.0.30.0.msi_**. There will be tww of them, download the bigger one.

Go through the setup wizard, making sute to select **_MySQL Server_**.


## Installing

A step by step series of examples that tell you how to get a development env running

### Cloning the project

Run the following command to clone the repository to your local machine

```
git clone https://github.com/mattadej/StudentManagementAPI.git
```

## Running the application

### Method One

The root folder should contain a file called **_student_management-0.0.1-SNAPSHOT.jar_**.

Open a terminal and navigate to the root folder.

Then in the terminal run the command  

```
java -jar student_management-0.0.1-SNAPSHOT.jar
```
When the server has started, you can then navigate to the link http://localhost:8080/index.html to begin interacting with the database.

### Method Two

To run the program from Eclipse first open Eclipse.

Then in Eclipse, choose **_File > Import_**.

Then, under **_Maven_** choose **_Existing Maven Project_**.

Select the imported repository as the root directory.

Make sure the pom.xml file is present, then right click it and choose Import.

Then right click the project folder, **_Run as > Spring Boot App_**.

When the server has started, you can then navigate to the link http://localhost:8080/index.html to begin interacting with the database.

## Running the tests

Explain how to run the automated tests for this system. Break down into which tests and what they do

### Unit Tests 

A unit test is a way of testing a unit - the smallest piece of code that can be logically isolated in a system.

This will test the Student Controller class in isolation, by testing that each method functions the way it was intended to.

To run the unit test, find the **_StudentControllerUnitTest.java_** and **_Right click_ > _Run as_ > _Junit Test_**

### Integration Tests 
Integration testing is the phase in software testing in which individual software modules are combined and tested as a group.

MockMVC will be used to make API calls to test the integration of the the controller, service and repo layers.

To run the integration test, find the **_StudentControllerIntegrationTest.java_** and **_Right click_ > _Run as_ > _Junit Test_**

## Swagger API Endpoints

![image](https://github.com/mattadej/StudentManagementAPI/blob/main/documentation/Swagger.PNG)

## Project Management Board

* [Jira](https://mattadej.atlassian.net/jira/software/projects/SMA/boards/1/) - Agile Project Management

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring Boot](https://spring.io/projects/spring-boot/) - Java-based framework

## Ackknowledgements/References

* [Bootstrap](https://getbootstrap.com/) - CSS/JS
* [Axios](https://axios-http.com/docs/intro) - HTTP Requests
* [QA](https://www.qa.com/) - Learning Resources



