use snaildb;

create table snail_taxonomer (
	taxonomer_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name varchar(255) NOT NULL,
	surname varchar(255) NOT NULL
);


create table snail_superfamily (
	superfamily_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name varchar(255) NOT NULL,
	taxonomy_year int NOT NULL
);

create table snail_superfamily_taxonomer (
	superfamily_id int NOT NULL,
	taxonomer_id int NOT NULL,
	FOREIGN KEY(superfamily_id) REFERENCES snail_superfamily(superfamily_id) ON DELETE CASCADE,
	FOREIGN KEY(taxonomer_id) REFERENCES snail_taxonomer(taxonomer_id) ON DELETE CASCADE
);


create table snail_family (
	family_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	superfamily_id int NOT NULL,
	name varchar(255) NOT NULL,
	taxonomy_year int NOT NULL,
	FOREIGN KEY(superfamily_id) REFERENCES snail_superfamily(superfamily_id) ON DELETE CASCADE
);

create table snail_family_taxonomer (
	family_id int NOT NULL,
	taxonomer_id int NOT NULL,
	FOREIGN KEY(family_id) REFERENCES snail_family(family_id) ON DELETE CASCADE,
	FOREIGN KEY(taxonomer_id) REFERENCES snail_taxonomer(taxonomer_id) ON DELETE CASCADE
);


create table snail_genus (
	genus_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	family_id int NOT NULL,
	name varchar(255) NOT NULL,
	taxonomy_year int NOT NULL,
	FOREIGN KEY(family_id) REFERENCES snail_family(family_id) ON DELETE CASCADE
);

create table snail_genus_taxonomer (
	genus_id int NOT NULL,
	taxonomer_id int NOT NULL,
	FOREIGN KEY(genus_id) REFERENCES snail_genus(genus_id) ON DELETE CASCADE,
	FOREIGN KEY(taxonomer_id) REFERENCES snail_taxonomer(taxonomer_id) ON DELETE CASCADE
);


create table snail_species (
	species_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	genus_id int NOT NULL,
	name varchar(255) NOT NULL,
	taxonomy_year int NOT NULL,
	FOREIGN KEY(genus_id) REFERENCES snail_genus(genus_id) ON DELETE CASCADE
);

create table snail_species_taxonomer (
	species_id int NOT NULL,
	taxonomer_id int NOT NULL,
	FOREIGN KEY(species_id) REFERENCES snail_species(species_id) ON DELETE CASCADE,
	FOREIGN KEY(taxonomer_id) REFERENCES snail_taxonomer(taxonomer_id) ON DELETE CASCADE
);


create table snail_subspecies (
	subspecies_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	species_id int NOT NULL,
	name varchar(255) NOT NULL,
	taxonomy_year int NOT NULL,
	min_height int,
	max_height int,
	min_width int,
	max_width int,
	extinct boolean NOT NULL DEFAULT false,
	viviparous boolean,
	FOREIGN KEY(species_id) REFERENCES snail_species(species_id) ON DELETE CASCADE
);

create table snail_subspecies_taxonomer (
	subspecies_id int NOT NULL,
	taxonomer_id int NOT NULL,
	FOREIGN KEY(subspecies_id) REFERENCES snail_subspecies(subspecies_id) ON DELETE CASCADE,
	FOREIGN KEY(taxonomer_id) REFERENCES snail_taxonomer(taxonomer_id) ON DELETE CASCADE
);
