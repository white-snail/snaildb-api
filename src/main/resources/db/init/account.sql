use snaildb;

create table user (
	user_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	username varchar(32) NOT NULL UNIQUE,
	name varchar(64),
	surname varchar(32)
);

create table role (
	role_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	role varchar(32) NOT NULL
);

create table user_role (
	user_id int NOT NULL,
	role_id int NOT NULL,
	FOREIGN KEY(user_id) REFERENCES user(user_id) ON DELETE CASCADE,
	FOREIGN KEY(role_id) REFERENCES role(role_id) ON DELETE CASCADE
);
