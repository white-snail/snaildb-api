alter table snail_genus add subfamily_id int;
alter table snail_genus add constraint fk_subfamily_id FOREIGN KEY (subfamily_id) REFERENCES snail_subfamily(subfamily_id);