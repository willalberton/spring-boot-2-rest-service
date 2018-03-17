# Introduction

To use this code, your need run the application.
After this, you should edit the `application.properties`. There you will find the database connection for mysql.

# Tables

2 tables are needed for this application: `city` and `country`.

Below, follows the sql.

`
CREATE TABLE `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
`

`
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL DEFAULT '',
  `id_country` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_country` (`id_country`),
  CONSTRAINT `fk_country` FOREIGN KEY (`id_country`) REFERENCES `country` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
`

# Using

After the application has been started, its time to load the content from txt file into database.
Just make a `POST` request to `http://localhost:8080/cities`.

There are `GET` methods for view the content of database.

1 - `GET http://localhost:8080/cities` for all cities;
2 - `GET http://localhost:8080/cities/{id}` for a specific city;

#Tests

The resource of load is covered by unit tests.
