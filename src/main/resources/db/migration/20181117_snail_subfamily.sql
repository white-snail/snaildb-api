create table snail_subfamily (
	subfamily_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name varchar(255) NOT NULL,
	taxonomy_year int NOT NULL
);

create table snail_subfamily_taxonomer (
	subfamily_id int NOT NULL,
	taxonomer_id int NOT NULL,
	FOREIGN KEY(subfamily_id) REFERENCES snail_subfamily(subfamily_id) ON DELETE CASCADE,
	FOREIGN KEY(taxonomer_id) REFERENCES snail_taxonomer(taxonomer_id) ON DELETE CASCADE
);
