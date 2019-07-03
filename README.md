[![CircleCI](https://circleci.com/gh/Ithar/java-spring-pet-clinic/tree/master.svg?style=svg)](https://circleci.com/gh/Ithar/java-spring-pet-clinic/tree/master)

# java-spring-pet-clinic


#### URLs
http://localhost:8080

### H2 Console
http://localhost:8080/h2-console/login.jsp

Driver Class:   org.h2.Driver
JDBC URL:       jdbc:h2:mem:testdbd
User Name:      sa
 
### Intellij
-Dspring.profiles.active=map
-Dspring.profiles.active=jpa

#### MVN Commands 

> mvn springboot:run

> mvn release:prepare

> mvn release:perform