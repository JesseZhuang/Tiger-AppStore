## Use a MySQL database in a Spring Boot Web Application through Hibernate

### Import Project

With IntelliJ IDEA up and running, click Import Project on the Welcome Screen. In the pop-up dialog make sure to select Maven's pom.xml.

### Usage

- Run the application and go on http://localhost:8080/
- Use the following urls to invoke controllers methods and see the interactions
  with the database:
    * `/app/create?appid=[appid]&url=[url]`: create a new app with an 
      auto-generated id and appid and url as passed values.
    * `/app/get-by-appid?appid=[appid]`: retrieve the url for the app with the
      passed appid value.

### Reference

http://blog.netgloo.com/2014/08/17/use-mysql-database-in-a-spring-boot-web-application-through-hibernate/

