# Dummy Web app 2

A simple web application developed in Java 8.

## Dependencies 

* Spring Framework
  * Core
  * Web MVC
  * Data JPA
  * Transaction Management
* Hibernate 5.3 / JPA 2.1
* Hibernate Validator 6
* Lombok
* Gson

**RDBMS**: MySQL;  
**Build system**: Maven 3;  
**Servlet container**: Tomcat 8 or 9;  
**View technologies**: JSP / JSTL + CSS (EL and Spring Form taglib);  
**Logging utility**: Log4j.

## How to build & run?

Make sure that MySQL service is running and configure connection properties in /resources/db.properties file

### Using command line

1. Package app

       mvn clean package

2. Deploy spring-mvc-jpa-jdk8.war to Tomcat  
   Just copy the war file to webapps folder and launch Tomcat via bin/catalina.bat or bin/catalina.sh

### Using IntelliJ IDEA

1. Import project in IDEA
2. Create new Run/Debug configuration (Tomcat Server > Local) and configure your application server (specify path to Tomcat in your environment).
3. Run this configuration

## Screenshots

![Students list](/screenshots/homepage.png)

![Faculties list](/screenshots/faculties.png)
