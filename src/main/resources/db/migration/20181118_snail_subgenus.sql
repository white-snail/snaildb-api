create table snail_subgenus (
	subgenus_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name varchar(255) NOT NULL,
	taxonomy_year int NOT NULL
);

create table snail_subgenus_taxonomer (
	subgenus_id int NOT NULL,
	taxonomer_id int NOT NULL,
	FOREIGN KEY(subgenus_id) REFERENCES snail_subgenus(subgenus_id) ON DELETE CASCADE,
	FOREIGN KEY(taxonomer_id) REFERENCES snail_taxonomer(taxonomer_id) ON DELETE CASCADE
);
