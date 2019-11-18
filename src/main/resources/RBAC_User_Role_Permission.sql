-- BCrypt
-- admin: $2a$10$DJr9REpKHS5SknDJxUwVPOXQ6SCI72qt5ki5vvYOa4ln3Hfrh67.u
-- 1234: $2a$10$Ui91L7As0DQzgHiYwTsmv.BrnF9iBY2N3qPpbf/vR6cDAXUPAlqOK

-- docker run --name meu-postgres --network=project-example-springboot-oauth2-rbac_minha-rede -e "POSTGRES_PASSWORD=postgres" -e "POSTGRES_PASSWORD=postgres" -e "POSTGRES_USER=postgres" -e "POSTGRES_DB=db_project_oauth2" -e "PGDATA=/var/lib/postgresql/data/pgdata" -p 5432:5432 -v /Users/murillo/development/docker/volumes/postgres:/var/lib/postgresql/data -d postgres:9.5

-- Selects in order
select * from tbl_role;
select * from tbl_permission;
select * from tbl_role_permissions;
select * from tbl_user;
select * from tbl_user_roles;


-- Role
INSERT INTO public.tbl_role (role_id, "name") VALUES(1, 'ADMIN');
INSERT INTO public.tbl_role (role_id, "name") VALUES(2, 'AUX');
INSERT INTO public.tbl_role (role_id, "name") VALUES(3, 'TESTE');

	
-- Permission
INSERT INTO public.tbl_permission (permission_id, "name") VALUES(1, 'user_create');
INSERT INTO public.tbl_permission (permission_id, "name") VALUES(2, 'user_read');
INSERT INTO public.tbl_permission (permission_id, "name") VALUES(3, 'user_update');
INSERT INTO public.tbl_permission (permission_id, "name") VALUES(4, 'user_delete');
INSERT INTO public.tbl_permission (permission_id, "name") VALUES(5, 'abcd');
INSERT INTO public.tbl_permission (permission_id, "name") VALUES(6, 'efgh');


-- Role + Permission
INSERT INTO public.tbl_role_permissions (roles_role_id, permissions_permission_id) VALUES(1, 1);
INSERT INTO public.tbl_role_permissions (roles_role_id, permissions_permission_id) VALUES(1, 2);
INSERT INTO public.tbl_role_permissions (roles_role_id, permissions_permission_id) VALUES(1, 3);
INSERT INTO public.tbl_role_permissions (roles_role_id, permissions_permission_id) VALUES(1, 4);
INSERT INTO public.tbl_role_permissions (roles_role_id, permissions_permission_id) VALUES(2, 2);
INSERT INTO public.tbl_role_permissions (roles_role_id, permissions_permission_id) values(2, 3);
INSERT INTO public.tbl_role_permissions (roles_role_id, permissions_permission_id) VALUES(3, 5);
INSERT INTO public.tbl_role_permissions (roles_role_id, permissions_permission_id) values(3, 6);

-- User
INSERT INTO public.tbl_user (user_id, email, inclusion_date, "name", password_user, uuid) 
VALUES(1, 'murillopezzuol@hotmail.com', '2019-08-22', 'Murillo Pezzuol', '$2a$10$DJr9REpKHS5SknDJxUwVPOXQ6SCI72qt5ki5vvYOa4ln3Hfrh67.u', '85205603-3f7a-4b64-b1e2-b34e1774a52e');
INSERT INTO public.tbl_user (user_id, email, inclusion_date, "name", password_user, uuid)
VALUES(2, 'aux@hotmail.com', '2019-08-20', 'Elvis Pexuka', '$2a$10$Ui91L7As0DQzgHiYwTsmv.BrnF9iBY2N3qPpbf/vR6cDAXUPAlqOK', 'de499c3b-12ca-432f-a849-960dd9d5889d');
INSERT INTO public.tbl_user (user_id, email, inclusion_date, "name", password_user, uuid)
VALUES(3, 'teste@hotmail.com', '2019-08-22', 'Teste Nome', '$2a$10$Ui91L7As0DQzgHiYwTsmv.BrnF9iBY2N3qPpbf/vR6cDAXUPAlqOK', 'd91f4088-db3a-4346-a692-f3e4828aff2e');


-- User + Role
INSERT INTO public.tbl_user_roles (user_id, role_id) VALUES(1, 1);
INSERT INTO public.tbl_user_roles (user_id, role_id) VALUES(2, 2);
INSERT INTO public.tbl_user_roles (user_id, role_id) VALUES(3, 3);



