CREATE TABLE ers_user_roles(
	user_role_id serial PRIMARY KEY,
	user_role VARCHAR(10) 
);

CREATE TABLE ers_users(
	ers_user_id serial PRIMARY KEY,
	ers_username VARCHAR(50),
	ers_password VARCHAR(50),
	user_first_name VARCHAR(100),
	user_last_name VARCHAR(100),
	user_email VARCHAR(150),
	user_role_id_fk int REFERENCES ers_user_roles (user_role_id)
);

CREATE TABLE ers_reimbursement_status(
	reimb_status_id serial PRIMARY KEY,
	reimb_status VARCHAR(10)
);

CREATE TABLE ers_reimbursement_types(
	reimb_type_id serial PRIMARY KEY,
	reimb_type VARCHAR(10)
);

CREATE TABLE ers_reimbursements (
	reimb_id serial PRIMARY KEY,
	reimb_amount int NOT NULL,
	reimb_submitted TEXT,
	reimb_author_id_fk int REFERENCES ers_users (ers_user_id),
	reimb_status_id_fk int REFERENCES ers_reimbursement_status (reimb_status_id),
	reimb_type_id_fk int REFERENCES ers_reimbursement_types (reimb_type_id)
);

INSERT INTO ers_user_roles (user_role)
VALUES('Admin'),
('Employee');

INSERT INTO ers_users (ers_username, ers_password, user_first_name,user_last_name,user_email,user_role_id_fk)
VALUES('user', 'password', 'Perry', 'Anderson', 'peryanderson@gmail.com', 1),
	('user2', 'password2', 'Steve', 'Guy', 'test@test.com', 2),
	('user3', 'password3', 'Ryu', 'Person', 'person@test.com', 2);

INSERT INTO ers_reimbursement_status (reimb_status)
VALUES('Pending'),
	('Approved'),
	('Denied');

INSERT INTO ers_reimbursement_types (reimb_type)
VALUES('Vaccation'),
	('Travel'),
	('Other');

INSERT INTO ers_reimbursements  (reimb_amount, reimb_submitted, reimb_author_id_fk, reimb_status_id_fk, reimb_type_id_fk)
VALUES (1000, '07/19/2020', 2, 1, 3),
	   (1500, '07/20/2020', 2, 1, 2),
	   (1200, '07/23/2020', 2, 1, 1),
	   (1200, '07/23/2020', 1, 1, 1),
	   (1300, '07/24/2020', 3, 1, 3),
	   (1450, '07/24/2020', 3, 1, 1);

select * from employees inner join roles 
on role_id = role_id_fk where role_title = ?;

SELECT * 
FROM ers_reimbursements 
LEFT JOIN ers_users ON ers_reimbursements.reimb_author_id_fk = ers_users.ers_user_id 
ORDER BY ers_users.ers_user_id 


SELECT * FROM ers_reimbursements;
SELECT * FROM ers_users;
SELECT * FROM ers_reimbursment_status;
SELECT * FROM ers_reimbursment_types;
SELECT * FROM ers_user_roles;

DROP TABLE ers_reimbursements;
DROP TABLE ers_users;
DROP TABLE ers_reimbursement_status;
DROP TABLE ers_reimbursement_types;
DROP TABLE ers_user_roles;
