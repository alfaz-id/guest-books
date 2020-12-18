Project Test1

TOOLS
- maven 3.5.4
- JDK 8
- Intellij IDEA Community Edition

Framework
- spring-boot
- database msyql
- HTML Engine thymeleaf
- CSS Bootstrap


create database 
- create database guest_books;

CREATE TABLE guest_books.guest
(
  id integer PRIMARY KEY NOT NULL,
  name character varying(30),
  phone_number character varying(15)
);

Running aplikasi

- mvn clean install
- mvn spring-boot:run

*note
change username adn password on application.yml



