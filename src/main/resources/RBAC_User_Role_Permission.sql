-- BCrypt
-- admin: $2a$10$DJr9REpKHS5SknDJxUwVPOXQ6SCI72qt5ki5vvYOa4ln3Hfrh67.u
-- 1234: $2a$10$Ui91L7As0DQzgHiYwTsmv.BrnF9iBY2N3qPpbf/vR6cDAXUPAlqOK



-- Selects in order
select * from tbl_role;
select * from tbl_permission;
select * from tbl_role_permissions;
select * from tbl_user;
select * from tbl_user_roles;


-- Role
INSERT INTO public.tbl_role (role_id, "name") VALUES(1, 'ADMIN');
INSERT INTO public.tbl_role (role_id, "name") VALUES(2, 'AUX');


-- Permission
INSERT INTO public.tbl_permission (permission_id, "name") VALUES(1, 'create');
INSERT INTO public.tbl_permission (permission_id, "name") VALUES(2, 'read');
INSERT INTO public.tbl_permission (permission_id, "name") VALUES(3, 'update');
INSERT INTO public.tbl_permission (permission_id, "name") VALUES(4, 'delete');


-- Role + Permission
INSERT INTO public.tbl_role_permissions (role_id, permission_id) VALUES(1, 1);
INSERT INTO public.tbl_role_permissions (role_id, permission_id) VALUES(1, 2);
INSERT INTO public.tbl_role_permissions (role_id, permission_id) VALUES(1, 3);
INSERT INTO public.tbl_role_permissions (role_id, permission_id) VALUES(1, 4);
INSERT INTO public.tbl_role_permissions (role_id, permission_id) VALUES(2, 2);
INSERT INTO public.tbl_role_permissions (role_id, permission_id) values(2, 3);


-- User
INSERT INTO public.tbl_user (user_id, email, inclusion_date, "name", password_user, fk_clinic) 
VALUES(1, 'murillopezzuol@hotmail.com', '2019-08-22', 'Murillo Pezzuol', '$2a$10$DJr9REpKHS5SknDJxUwVPOXQ6SCI72qt5ki5vvYOa4ln3Hfrh67.u', NULL);
INSERT INTO public.tbl_user (user_id, email, inclusion_date, "name", password_user, fk_clinic)
VALUES(2, 'aux@hotmail.com', '2019-08-20', 'Elvis Pexuka', '$2a$10$Ui91L7As0DQzgHiYwTsmv.BrnF9iBY2N3qPpbf/vR6cDAXUPAlqOK', NULL);


-- User + Role
INSERT INTO public.tbl_user_roles (user_id, role_id) VALUES(1, 1);
INSERT INTO public.tbl_user_roles (user_id, role_id) VALUES(2, 2);







