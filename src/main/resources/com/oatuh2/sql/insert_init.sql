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
select * from tbl_company;



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
INSERT INTO public.tbl_role_permissions (role_id, permission_id) VALUES(1, 1);
INSERT INTO public.tbl_role_permissions (role_id, permission_id) VALUES(1, 2);
INSERT INTO public.tbl_role_permissions (role_id, permission_id) VALUES(1, 3);
INSERT INTO public.tbl_role_permissions (role_id, permission_id) VALUES(1, 4);
INSERT INTO public.tbl_role_permissions (role_id, permission_id) VALUES(2, 2);
INSERT INTO public.tbl_role_permissions (role_id, permission_id) values(2, 3);
INSERT INTO public.tbl_role_permissions (role_id, permission_id) VALUES(3, 5);
INSERT INTO public.tbl_role_permissions (role_id, permission_id) values(3, 6);



-- Company
INSERT INTO public.tbl_company
(company_id, cnpj, address, city, complement, neighbourhood, number_address, 
state, zip_code, corporate_name, date_create, market_segment, register_status)
VALUES(1, '26.649.086/0001-71', 'Rua José Guilherme Pagnani', 'Suzano', 'Ap 108 Bl 05',
'Vila Figueira', '809', 'São Paulo', '02476200', 'Gambiarra Company LTDA', '2014-08-20', 'Vendas Online', true);

INSERT INTO public.tbl_company
(company_id, cnpj, address, city, complement, neighbourhood, number_address, 
state, zip_code, corporate_name, date_create, market_segment, register_status)
VALUES(2, '45.649.075/0001-v1', 'Rua Nao Sei', 'Mogi das Cruzes', '',
'Vila Morim', '1101', 'São Paulo', '12676200', 'Somos Juntos LTDA', '2015-08-20', 'Mercado Online', true);

INSERT INTO public.tbl_company
(company_id, cnpj, address, city, complement, neighbourhood, number_address, 
state, zip_code, corporate_name, date_create, market_segment, register_status)
VALUES(3, '44.444.086/0003-71', 'Av. Almeida Lima', 'Timbaia', 'prox ao mercado',
'Jupitrans', '4433', 'Rio de Janeiro', '14576200', 'Praia Love S/A', '2010-08-20', 'Mercadinho', true);



-- User
INSERT INTO public.tbl_user
(user_id, cell_phone_number, email, phone_number, 
date_inclusion, login, "name", password_user, register_status, uuid, company_id)
VALUES(1, '1147474848', 'murillopezzuol@hotmail.com', '11988115473', 
'2019-11-25', 'mupezzuol', 'Murillo Pezzuol', 
'$2a$10$DJr9REpKHS5SknDJxUwVPOXQ6SCI72qt5ki5vvYOa4ln3Hfrh67.u', true, '85205603-3f7a-4b64-b1e2-b34e1774a52e', 1);

INSERT INTO public.tbl_user
(user_id, cell_phone_number, email, phone_number, 
date_inclusion, login, "name", password_user, register_status, uuid, company_id)
VALUES(2, '1147474848', 'aux@hotmail.com', '11934345656', 
'2019-11-24', 'aux', 'Aux Pezzuka', 
'$2a$10$Ui91L7As0DQzgHiYwTsmv.BrnF9iBY2N3qPpbf/vR6cDAXUPAlqOK', true, 'de499c3b-12ca-432f-a849-960dd9d5889d', 2);

INSERT INTO public.tbl_user
(user_id, cell_phone_number, email, phone_number, 
date_inclusion, login, "name", password_user, register_status, uuid, company_id)
VALUES(3, '1190909090', 'teste@hotmail.com', '11901010101', 
'2019-11-23', 'test', 'Teste Test', 
'$2a$10$Ui91L7As0DQzgHiYwTsmv.BrnF9iBY2N3qPpbf/vR6cDAXUPAlqOK', true, 'd91f4088-db3a-4346-a692-f3e4828aff2e', 3);

INSERT INTO public.tbl_user
(user_id, cell_phone_number, email, phone_number, 
date_inclusion, login, "name", password_user, register_status, uuid, company_id)
VALUES(4, '1111111111', 'teste2@hotmail.com', '1199990000', 
'2019-11-23', 'test2', 'Teste2 Test', 
'$2a$10$Ui91L7As0DQzgHiYwTsmv.BrnF9iBY2N3qPpbf/vR6cDAXUPAlqOK', true, '5412f8e0-09fc-4dba-bc89-11b2598dffdc', 3);



-- User + Role
INSERT INTO public.tbl_user_roles (user_id, role_id) VALUES(1, 1);
INSERT INTO public.tbl_user_roles (user_id, role_id) VALUES(2, 2);
INSERT INTO public.tbl_user_roles (user_id, role_id) VALUES(3, 3);
INSERT INTO public.tbl_user_roles (user_id, role_id) VALUES(4, 3);
INSERT INTO public.tbl_user_roles (user_id, role_id) VALUES(4, 2);



