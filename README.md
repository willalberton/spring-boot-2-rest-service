# Introduction

To use this code, your need run the application.
After this, you should edit the `application.properties`. There you will find the database connection for mysql.

# Using

After the application has been started, its time to load the content from txt file into database.
Just make a `POST` request to `http://localhost:8080/cities`.

There are `GET` methods for view the content of database.

1 - `GET http://localhost:8080/cities` for all cities;
2 - `GET http://localhost:8080/cities/{id}` for a specific city;

#Tests

The resource of load is covered by unit tests.
