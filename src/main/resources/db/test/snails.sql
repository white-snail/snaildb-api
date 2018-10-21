insert into snail_taxonomer (name, surname) values ("William John", "Swainson");
set @swainson := (select last_insert_id());
insert into snail_taxonomer (name, surname) values ("Johann Christian", "Albers");
set @albers := (select last_insert_id());
insert into snail_taxonomer (name, surname) values ("", "Philippi");
set @philippi := (select last_insert_id());

insert into snail_superfamily (name, taxonomer_id, taxonomy_year) values ("achatinaidea", @swainson, 1840);
insert into snail_family (superfamily_id, name, taxonomer_id, taxonomy_year) values ((select last_insert_id()), "achatinidae", @swainson, 1840);
insert into snail_genus (family_id, name, taxonomer_id, taxonomy_year) values ((select last_insert_id()), "archachatina", @albers, 1850);
insert into snail_species (genus_id, name, taxonomer_id, taxonomy_year) values ((select last_insert_id()), "marginata", @swainson, 1821);
insert into snail_subspecies (species_id, name, taxonomer_id, taxonomy_year, min_height, max_height, min_width, max_width) values ((select last_insert_id()), "suturalis", @philippi, 1849, 110, 110, 60, 60);
insert into snail_subspecies (species_id, name, taxonomer_id, taxonomy_year, min_height, max_height, min_width, max_width) values ((select last_insert_id()), "marginata", @swainson, 1821, 176, 176, 80, 80);
