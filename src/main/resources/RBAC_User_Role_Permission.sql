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
INSERT INTO public.tbl_user (user_id, email, inclusion_date, "name", password_user, uuid) 
VALUES(1, 'murillopezzuol@hotmail.com', '2019-08-22', 'Murillo Pezzuol', '$2a$10$DJr9REpKHS5SknDJxUwVPOXQ6SCI72qt5ki5vvYOa4ln3Hfrh67.u', '85205603-3f7a-4b64-b1e2-b34e1774a52e');
INSERT INTO public.tbl_user (user_id, email, inclusion_date, "name", password_user, uuid)
VALUES(2, 'aux@hotmail.com', '2019-08-20', 'Elvis Pexuka', '$2a$10$Ui91L7As0DQzgHiYwTsmv.BrnF9iBY2N3qPpbf/vR6cDAXUPAlqOK', 'de499c3b-12ca-432f-a849-960dd9d5889d');
INSERT INTO public.tbl_user (user_id, email, inclusion_date, "name", password_user, uuid)
VALUES(3, 'teste@hotmail.com', '2019-08-22', 'Teste Nome', '$2a$10$DJr9REpKHS5SknDJxUwVPOXQ6SCI72qt5ki5vvYOa4ln3Hfrh67.u', 'd91f4088-db3a-4346-a692-f3e4828aff2e');


-- User + Role
INSERT INTO public.tbl_user_roles (user_id, role_id) VALUES(1, 1);
INSERT INTO public.tbl_user_roles (user_id, role_id) VALUES(2, 2);
INSERT INTO public.tbl_user_roles (user_id, role_id) VALUES(3, 1);
INSERT INTO public.tbl_user_roles (user_id, role_id) VALUES(3, 2);







