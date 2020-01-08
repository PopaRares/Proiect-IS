INSERT INTO `SINU`.`group` (series_id, year, faculty) VALUES (2, 3, 'Automatica si Calculatoare');
INSERT INTO `SINU`.`group` (series_id, year, faculty) VALUES (2, 3, 'Automatica si Calculatoare');
INSERT INTO `SINU`.`group` (series_id, year, faculty) VALUES (2, 3, 'Automatica si Calculatoare');
INSERT INTO `SINU`.`group` (series_id, year, faculty) VALUES (2, 3, 'Automatica si Calculatoare');
INSERT INTO `SINU`.`group` (series_id, year, faculty) VALUES (2, 3, 'Automatica si Calculatoare');
INSERT INTO `SINU`.`group` (series_id, year, faculty) VALUES (2, 3, 'Automatica si Calculatoare');
INSERT INTO `SINU`.`group` (series_id, year, faculty) VALUES (2, 3, 'Automatica si Calculatoare');
INSERT INTO `SINU`.`group` (series_id, year, faculty) VALUES (2, 3, 'Automatica si Calculatoare');
INSERT INTO `SINU`.`group` (series_id, year, faculty) VALUES (2, 3, 'Automatica si Calculatoare');
INSERT INTO `SINU`.`group` (series_id, year, faculty) VALUES (2, 3, 'Automatica si Calculatoare');

INSERT INTO users (first_name, last_name, email, username, password, role, group_id) VALUES ('Rares', 'Popa', 'raresp98@gmail.com', 'raresp', '12345', 'STUDENT', 10);
INSERT INTO users (first_name, last_name, email, username, password, role, group_id) VALUES ('Cezara', 'Dulceac', 'cezara_sv@yahoo.com', 'cezarad', '12345', 'STUDENT', 10);
INSERT INTO users (first_name, last_name, email, username, password, role, group_id) VALUES ('Luiza', 'Fat', 'luizamf22@yahoo.com', 'luizamf', '12345', 'STUDENT', 10);
INSERT INTO users (first_name, last_name, email, username, password, role, group_id) VALUES ('Grigor', 'Ipatiov', 'grigorIpatiov@yahoo.com', 'grigi', '12345', 'STUDENT', 10);
INSERT INTO users (first_name, last_name, email, username, password, role, group_id) VALUES ('Alin', 'Scarlat', 'alinS@gmail.com', 'alins', '12345', 'STUDENT', 9);
INSERT INTO users (first_name, last_name, email, username, password, role, group_id) VALUES ('Mihai', 'Filip-Dud', 'mihaiFD@gmail.com', 'mihaifd', '12345', 'STUDENT', 7);
INSERT INTO users (first_name, last_name, email, username, password, role, group_id) VALUES ('Lucia', 'Vacariu', 'lvacariu@gmail.com', 'lvacariu', 'asdnpsneviatamea', 'PROFESSOR', 1);
INSERT INTO users (first_name, last_name, email, username, password, role, group_id) VALUES ('Ionel', 'Giosan', 'igiosan@gmail.com', 'giosy', '12345', 'PROFESSOR', 1);
INSERT INTO users (first_name, last_name, email, username, password, role, group_id) VALUES ('Calin', 'Pantea', 'cpantera@gmail.com', 'pantera', '12345', 'STUDENT', 6);
INSERT INTO users (first_name, last_name, email, username, password, role, group_id) VALUES ('Alex', 'Iloie', 'ailoie@gmail.com', 'ailoie', '12345', 'PROFESSOR', 1);
INSERT INTO users (first_name, last_name, email, username, password, role, group_id) VALUES ('Raluca', 'Brehar', 'brehar@gmail.com', 'ralucabrehar', '12345', 'PROFESSOR', 1);
INSERT INTO users (first_name, last_name, email, username, password, role, group_id) VALUES ('Tudor', 'Muresan', 'tmuresan@gmail.com', 'tmuresan', '12345', 'PROFESSOR', 1);
INSERT INTO users (first_name, last_name, email, username, password, role, group_id) VALUES ('Mihai', 'Feier', 'mfeier@gmail.com', 'mfeier', '12345', 'PROFESSOR', 1);
INSERT INTO users (first_name, last_name, email, username, password, role, group_id) VALUES ('Radu', 'Tufisi', 'rtufisi@gmail.com', 'rtufisi', '12345', 'PROFESSOR', 1);
INSERT INTO users (first_name, last_name, email, username, password, role, group_id) VALUES ('Alexandru', 'Sabau', 'asabau@gmail.com', 'asabau', '12345', 'PROFESSOR', 1);
INSERT INTO users (first_name, last_name, email, username, password, role, group_id) VALUES ('Laura', 'Darabant', 'electrolaura@gmail.com', 'electrolaura', '12345', 'PROFESSOR', 1);
INSERT INTO users (first_name, last_name, email, username, password, role, group_id) VALUES ('Grigore', 'Dragomir', 'dragmoir@gmail.com', 'lovebd', '12345', 'PROFESSOR', 1);
INSERT INTO users (first_name, last_name, email, username, password, role, group_id) VALUES ('Camelia', 'Lemnaru', 'clemnaru@gmail.com', 'clemnaru', '12345', 'PROFESSOR', 1);
INSERT INTO users (first_name, last_name, email, username, password, role, group_id) VALUES ('Victor', 'Bacu', 'bacuv@gmail.com', 'bacuv', '12345', 'PROFESSOR', 1);

INSERT INTO subject (name, year, semester, credits, course_weight, lab_weight, seminar_weight) VALUES('Inginerie Software', 3, 'FIRST', 5, 70, 30, 0);
INSERT INTO subject (name, year, semester, credits, course_weight, lab_weight, seminar_weight) VALUES('Programarea Calculatoarelor', 1, 'FIRST', 5, 60, 30, 10);
INSERT INTO subject (name, year, semester, credits, course_weight, lab_weight, seminar_weight) VALUES('Elemente de grafica asistata de calculator', 2, 'SECOND', 4, 60, 40, 0);
INSERT INTO subject (name, year, semester, credits, course_weight, lab_weight, seminar_weight) VALUES('Electrotehnica', 2, 'FIRST', 4, 90, 10, 0);
INSERT INTO subject (name, year, semester, credits, course_weight, lab_weight, seminar_weight) VALUES('Proiectare cu microprocesoare', 3, 'FIRST', 5, 80, 20, 0);

INSERT INTO class (type, subject_id) VALUES ('COURSE', 1);
INSERT INTO class (type, subject_id) VALUES ('LABORATORY', 1);
INSERT INTO class (type, subject_id) VALUES ('COURSE', 2);
INSERT INTO class (type, subject_id) VALUES ('LABORATORY', 2);
INSERT INTO class (type, subject_id) VALUES ('SEMINAR', 2);
INSERT INTO class (type, subject_id) VALUES ('COURSE', 3);
INSERT INTO class (type, subject_id) VALUES ('LABORATORY', 3);
INSERT INTO class (type, subject_id) VALUES ('COURSE', 4);
INSERT INTO class (type, subject_id) VALUES ('LABORATORY', 4);
INSERT INTO class (type, subject_id) VALUES ('COURSE', 5);
INSERT INTO class (type, subject_id) VALUES ('LABORATORY', 5);











