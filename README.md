Dentist appointment application
===

## The application is designed to make an appointment at a dental clinic.
The application is designed to make an appointment at a dental clinic.
On the main page of the application, the user sees an appointment booking form.
The list of dentists is displayed in the drop-down list. This list is generated 
upon request to the database.
The user then selects a date for the appointment. 
After that, a drop-down list with the schedule of appointments will become available.
The "confirm" button saves the appointment time in the database and redirects 
to a page to view all booked appointments. This information is presented in a sortable table.
The sorting feature is implemented using the external library.
On this page, the user can delete appointments, after which he remains on the current page.
To edit the appointment, the user will be redirected back to the registration page.
Also, the transition from page to page is available via the links.

 
#### Library for sortable table: https://www.kryogenix.org/code/browser/sorttable/


## Requirements:
##### Java 1.8
#### Maven
#### H2

## Database:
username "sa" 
jdbc:h2:tcp://localhost:9092/mem:app_db

## Commands for building the project:
###### mvn install

## Run project without using IDE:
###### mvn spring-boot:run

## The application is running on localhost
###### http://localhost:8080/
