use snaildb;

create table user (
	user_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	username varchar(32) NOT NULL UNIQUE,
	password binary(32) NOT NULL,
	name varchar(64),
	surname varchar(32),
	admin boolean NOT NULL DEFAULT false,
	social varchar(4000) NOT NULL DEFAULT '{}'
);
