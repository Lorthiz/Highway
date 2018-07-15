
-- USER ROLES

INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_INSTRUCTOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');


-- ROOT ADMINISTRATOR

INSERT INTO users(name, username, email, password)
VALUES('Administrator', 'adm', 'adm@adm.adm', 'adm');

INSERT INTO users_roles(user_id, role_id)
VALUES(1, 3);

------------------
-- TEST/MOCK DATA
------------------

-- TEST USERS DATA

INSERT INTO users(name, username, email, password)
VALUES('Instructor', 'ins', 'ins@adm.adm', 'ins');

INSERT INTO users_roles(user_id, role_id)
VALUES(2, 2);

INSERT INTO users(name, username, email, password)
VALUES('User', 'usr', 'usr@adm.adm', 'usr');

INSERT INTO users_roles(user_id, role_id)
VALUES(3, 1);


INSERT INTO users(name, username, email, password)
VALUES('Instructor2', 'ins2', 'ins2@adm.adm', 'ins2');

INSERT INTO users_roles(user_id, role_id)
VALUES(4, 2);

-- TEST VEHICLES DATA

INSERT INTO vehicles(status, registration_number, production_date, model)
VALUES(true, 'LU33645', 2006, 'Passat');

-- TEST RIDES DATA

INSERT INTO rides(length, start_time, instructor_id, student_id, vehicle_id)
VALUES(30,'2018-07-15T18:00:00.000',  2, 3, 1);

INSERT INTO rides(length, start_time, instructor_id, student_id, vehicle_id)
VALUES(30,'2018-07-15T19:00:00.000',  4, 3, 1);