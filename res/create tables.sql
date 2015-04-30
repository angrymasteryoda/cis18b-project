CREATE TABLE users (
	id int(8) NOT NULL AUTO_INCREMENT,
	username varchar(50) NOT NULL,
	email VARCHAR(255) NOT NULL,
	password VARCHAR(35) NOT NULL,
	created int(11) NOT NULL,
	PRIMARY KEY (id),
	INDEX (email)
);
