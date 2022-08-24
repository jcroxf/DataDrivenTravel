Hello there


# Data Driven Travel
Create a Travel-app class and automate testing with data driven from SQL database<br>

[data types](https://www.w3schools.com/sql/sql_datatypes.asp),
[hsqldb](http://hsqldb.org/),
[java api](https://docs.oracle.com/javase/7/docs/api/),
[sql](https://www.w3schools.com/sql/)

## Steps
* Ensure the Eclipse IDE has Maven by looking for M2E from Help About ([details](https://www.vogella.com/tutorials/EclipseMaven/article.html))
* Install `DBViewer Plugin 1.2.2.v20101009` by ZIGEN from the Eclipse IDE marketplace
* Import into Eclipse as Git with smart import (accepting all defaults in wizard)
* Let the IDE finish building dependencies before proceeding (see bottom right of Eclipse)
* Run as JUnit test the file `TravelAppTest.java` for sanity testing the local database

## Database Schema

**Animal table**
- Hunger INT
- Id CHAR(36)
- Name VARCHAR(100)
- OwnerId CHAR(36)
- Species CHAR(1)

**Owner table**
- Id CHAR(36)
- Name VARCHAR(100)
- Town VARCHAR(100)

**To create the Owner table**<br>
`CREATE TABLE Owner (Id CHAR(36), Name VARCHAR(100), Town VARCHAR(100), PRIMARY KEY(Id));`

**To create the Animal table**<br>
`CREATE TABLE Animal (Hunger INT, Id CHAR(36), Name VARCHAR(100), OwnerId CHAR(36), Species CHAR(1), PRIMARY KEY(Id), FOREIGN KEY(OwnerId) REFERENCES Owner(Id));`

**To insert a new Owner row**<br>
`INSERT INTO Owner (Id, Name, Town) VALUES ('614ad61d-608c-43bb-966a-4fe348762ee2', 'Floz', 'Bridgnorth');`

**To insert a new Cat row**<br>
`INSERT INTO Animal (Hunger, Id, Name, OwnerId, Species) VALUES (0, '86644422-2eea-448d-9670-d127446ab69b', 'Jess', '614ad61d-608c-43bb-966a-4fe348762ee2', 'C');`

**To insert a new Dog row**<br>
`INSERT INTO Animal (Hunger, Id, Name, OwnerId, Species) VALUES (0, 'e0e122d7-65f8-4a0a-901a-a4e57ee1e1a2', 'Milo', '614ad61d-608c-43bb-966a-4fe348762ee2', 'D');`

**To query an animal**<br>
`SELECT Hunger, Id, Species FROM Animal WHERE Name = 'Jess';`

**To query all pets for an owner**<br>
`SELECT animal.Name, animal.Species FROM Animal animal, Owner owner WHERE owner.Name = 'Floz';`


**Examples of using the Factory**<br>
`Cat jess = Factory.createCat("Jess");`<br>
`Dog milo = Factory.createDog("Milo");`<br>
`Owner floz = Factory.createOwner("Floz", "Bridgnorth");`<br>


# AHOY! TRAVEL FUNCTIONALITY
## User Stories

*USER STORY 1:* <br>
As a user, I can have a specific account for the AHOY! App to link to my past tickets

*USER STORY 2:* <br>
As a user, I would like to see the ticket IDs for all my train and bus fares

*USER STORY 3:* <br>
As a user, for any fare I've purchased I would like to check the price

*USER STORY 4:* <br>
As a user, for any fare I have purchased I would like to be able to check where a train/bus ticket commenced, and where my ticket terminated at 

## Database Schema- AHOY! Travel App

**Customer Table**
- Id CHAR(36)
- Name VARCHAR(100)

**Ticket table**
- Price INT
- TravelType CHAR(25)
- StationStart VARCHAR(100)
- StationEnd VARCHAR(100)
- CustomerId CHAR(36)
- TicketId CHAR(36)

**To create the Customer table**<br>
`CREATE TABLE Customer (Id CHAR(36), Name VARCHAR(100), PRIMARY KEY(Id));`

**To create the Ticket table**<br>
`CREATE TABLE Ticket (Price INT, TravelType CHAR(25), StationStart VARCHAR(100), StationEnd VARCHAR(100), TicketId CHAR(36), CustomerId CHAR(36), FOREIGN KEY(CustomerId) REFERENCES Customer(Id));`

**To insert a new Customer row**<br>
`INSERT INTO Customer (Id, Name) VALUES ('eea72b1a-a638-4cd5-bce4-7b632ea7dfeb', 'James');`

**To insert a new Customer row**<br>
`INSERT INTO Customer (Id, Name) VALUES ('118114ad-e6cc-44ad-bdc5-ad7a34db5e07', 'Alec');`

**To insert a new Customer row**<br>
`INSERT INTO Customer (Id, Name) VALUES ('ac97b189-de69-4914-818d-dbbc968a4671', 'Avais');`

**To insert a new Ticket row**<br>
`INSERT INTO Ticket (Price, TravelType, StationStart, StationEnd, TicketId, CustomerId) VALUES ('1000', 'Train', 'Deansgate', 'Euxton', 'be30708f-4bdc-4302-b17b-7920848728d7', 'eea72b1a-a638-4cd5-bce4-7b632ea7dfeb');`

**To insert a new Ticket row**<br>
`INSERT INTO Ticket (Price, TravelType, StationStart, StationEnd, TicketId, CustomerId) VALUES ('525', 'Train', 'Liverpool', 'Prescot', 'daa4fac5-a7b0-434f-98f1-9a4f8923e0a1', '118114ad-e6cc-44ad-bdc5-ad7a34db5e07');`

**To insert a new Ticket row**<br>
`INSERT INTO Ticket (Price, TravelType, StationStart, StationEnd, TicketId, CustomerId) VALUES ('7750', 'Train', 'Liverpool', 'Edinburgh',  '7402d754-688d6-a274-c0490bb723cc', 'ac97b189-de69-4914-818d-dbbc968a4671');`

**To insert a new Ticket row**<br>
`INSERT INTO Ticket (Price, TravelType, StationStart, StationEnd, TicketId, CustomerId) VALUES ('350', 'Bus', 'Manchester Victoria', 'Oxford Road', '897287b8-fe0b-4dae-9176-ef8d9c8ec52b', 'ac97b189-de69-4914-818d-dbbc968a4671');`

**To query an ticket where station start is a particular station**<br>
`SELECT TicketId, TravelType, StationStart, StationEnd, Price FROM Ticket WHERE StationStart = 'Liverpool';`

**User Story 4- To query all tickets for an customer**<br>
`SELECT customer.Name, ticket.StationStart, ticket.StationEnd FROM Ticket ticket, Customer customer WHERE customer.Name = 'Avais' AND ticket.CustomerId = customer.Id;`

