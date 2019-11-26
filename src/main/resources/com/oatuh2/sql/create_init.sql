-- Drop table

-- DROP TABLE sch_superdigital.tbl_company;

CREATE TABLE sch_superdigital.tbl_company (
	company_id int8 NOT NULL,
	cnpj varchar(255) NULL,
	address varchar(255) NULL,
	city varchar(255) NULL,
	complement varchar(255) NULL,
	neighbourhood varchar(255) NULL,
	number_address varchar(255) NULL,
	state varchar(255) NULL,
	zip_code varchar(255) NULL,
	corporate_name varchar(255) NULL,
	date_create date NULL,
	market_segment varchar(255) NULL,
	register_status bool NULL,
	CONSTRAINT tbl_company_pkey PRIMARY KEY (company_id)
);



-- Drop table
-- DROP TABLE sch_superdigital.tbl_user;

CREATE TABLE sch_superdigital.tbl_user (
	user_id int8 NOT NULL,
	cell_phone_number varchar(255) NULL,
	email varchar(255) NULL,
	phone_number varchar(255) NULL,
	date_inclusion date NULL,
	login varchar(255) NOT NULL,
	"name" varchar(255) NOT NULL,
	password_user varchar(255) NOT NULL,
	register_status bool NULL,
	uuid uuid NOT NULL,
	company_id int8 NULL,
	CONSTRAINT idx_tbl_user_email UNIQUE (email),
	CONSTRAINT tbl_user_pkey PRIMARY KEY (user_id)
);

ALTER TABLE sch_superdigital.tbl_user ADD CONSTRAINT fk_tbl_user_company FOREIGN KEY (company_id) REFERENCES tbl_company(company_id);



-- Drop table
-- DROP TABLE sch_superdigital.tbl_role;

CREATE TABLE sch_superdigital.tbl_role (
	role_id int8 NOT NULL,
	"name" varchar(255) NULL,
	CONSTRAINT tbl_role_pkey PRIMARY KEY (role_id)
);



-- Drop table
-- DROP TABLE sch_superdigital.tbl_user_roles;

CREATE TABLE sch_superdigital.tbl_user_roles (
	user_id int8 NOT NULL,
	role_id int8 NOT NULL,
	CONSTRAINT tbl_user_roles_pkey PRIMARY KEY (user_id, role_id)
);

ALTER TABLE sch_superdigital.tbl_user_roles ADD CONSTRAINT fk_tbl_user_roles_role FOREIGN KEY (role_id) REFERENCES tbl_role(role_id);
ALTER TABLE sch_superdigital.tbl_user_roles ADD CONSTRAINT fk_tbl_user_roles_user FOREIGN KEY (user_id) REFERENCES tbl_user(user_id);



-- Drop table
-- DROP TABLE sch_superdigital.tbl_permission;

CREATE TABLE sch_superdigital.tbl_permission (
	permission_id int8 NOT NULL,
	"name" varchar(255) NULL,
	CONSTRAINT tbl_permission_pkey PRIMARY KEY (permission_id)
);



-- Drop table
-- DROP TABLE sch_superdigital.tbl_role_permissions;

CREATE TABLE sch_superdigital.tbl_role_permissions (
	role_id int8 NOT NULL,
	permission_id int8 NOT NULL,
	CONSTRAINT tbl_role_permissions_pkey PRIMARY KEY (role_id, permission_id)
);

ALTER TABLE sch_superdigital.tbl_role_permissions ADD CONSTRAINT fk_tbl_role_permissions_permission FOREIGN KEY (permission_id) REFERENCES tbl_permission(permission_id);
ALTER TABLE sch_superdigital.tbl_role_permissions ADD CONSTRAINT fk_tbl_role_permissions_role FOREIGN KEY (role_id) REFERENCES tbl_role(role_id);










-- SEQUENCE


-- DROP SEQUENCE sch_superdigital.hibernate_sequence;

CREATE SEQUENCE sch_superdigital.hibernate_sequence
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1;


-- DROP SEQUENCE sch_superdigital.tbl_company_seq;

CREATE SEQUENCE sch_superdigital.tbl_company_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1;


-- DROP SEQUENCE sch_superdigital.tbl_user_seq;

CREATE SEQUENCE sch_superdigital.tbl_user_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1;


-- DROP SEQUENCE sch_superdigital.tbl_role_seq;

CREATE SEQUENCE sch_superdigital.tbl_role_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1;


-- DROP SEQUENCE sch_superdigital.tbl_permission_seq;

CREATE SEQUENCE sch_superdigital.tbl_permission_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1;


