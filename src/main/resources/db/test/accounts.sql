insert into role (role) values ("USER");
set @ruser := (select last_insert_id());
insert into role (role) values ("ADMIN");
set @radmin := (select last_insert_id());
insert into user (username, password) values ("User", "$2a$10$SFASADedDzbUNojeyrkMquthdDNBU//jbkrS2D50LsIJFcGroIs/K");
set @uuser := (select last_insert_id());
insert into user (username, password) values ("Admin", "$2a$10$SFASADedDzbUNojeyrkMquthdDNBU//jbkrS2D50LsIJFcGroIs/K");
set @uadmin := (select last_insert_id());
insert into user_role (user_id, role_id) values (@uuser, @ruser);
insert into user_role (user_id, role_id) values (@uadmin, @ruser);
insert into user_role (user_id, role_id) values (@uadmin, @radmin);
