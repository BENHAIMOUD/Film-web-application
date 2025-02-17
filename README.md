# Film Demo Web app 
A film directory sample web app developped with an Angular 4 and SpringBoot



# Stack
  - Angular 4 / Angular Material
  - Spring Data Rest / Spring security
  - MySQL

# You will need
- Java 8+
- Node 8+
- Mysql 5+
- Maven 3+


# Setup and run backend

You need a Mysql 5+ instance running on your network or local host

- Create a "filmdb" database,
- Edit database connection settings in film/src/main/resources/aplications.properties 

```sh
cd film
mvn clean install
```

And run the backend

```sh
 mvn spring-boot:run
```

# Setup and run front-end
```sh
cd film-front
npm i
ng serve
```

And then open your browser to [localhost:4200](http://localhost:4200)


# Limitations

No Unitary tests. NgRx state management not used.
Tested only on Chrome.

# Dev stack
The project is aim to showcase a sample CRUD web application using Angular 4/5 and Spring Data Rest. 
It's a film directory database listing films actors and directors.

A simple data model is setup with Film, Actor and Director tables with many-to-many relationships between Film/Actor and Film/Director.


A REST API is generated with Spring Data Rest (in Hateos format).

A JWT token based authentication based on Spring Security is in place to secure POST/PUT/DELETE REST requests. 
Only GET and OPTIONS requests are available without authentication.

The front end is based on Angular 4 and uses Angular Material components. 










 
