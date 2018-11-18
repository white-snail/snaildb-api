alter table snail_species add subgenus_id int;
alter table snail_species add constraint fk_subgenus_id FOREIGN KEY (subgenus_id) REFERENCES snail_subgenus(subgenus_id);