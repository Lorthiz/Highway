INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_INSTRUCTOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO users(name, username, email, password)
VALUES('Administrator', 'adm', 'adm@adm.adm', 'adm');

INSERT INTO users_roles(user_id, role_id)
VALUES(1, 3);