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
INSERT INTO users (first_name, last_name, email, username, password, role, group_id) VALUES ('Enea', 'Todoran', 'eneatodoran@gmail.com', 'etodoran', '12345', 'PROFESSOR', 1);
INSERT INTO users (first_name, last_name, email, username, password, role, group_id) VALUES ('Mihai', 'Negru', 'mnegru@gmail.com', 'negrumihai', '12345', 'PROFESSOR', 1);
INSERT INTO users (first_name, last_name, email, username, password, role, group_id) VALUES ('Laura', 'Darabant', 'electrolaura@gmail.com', 'electrolaura', '12345', 'PROFESSOR', 1);
INSERT INTO users (first_name, last_name, email, username, password, role, group_id) VALUES ('Florin', 'Oniga', 'florinoniga@gmail.com', 'onigaf', '12345', 'PROFESSOR', 1);
INSERT INTO users (first_name, last_name, email, username, password, role, group_id) VALUES ('Camelia', 'Lemnaru', 'clemnaru@gmail.com', 'clemnaru', '12345', 'PROFESSOR', 1);
INSERT INTO users (first_name, last_name, email, username, password, role, group_id) VALUES ('Victor', 'Bacu', 'bacuv@gmail.com', 'bacuv', '12345', 'PROFESSOR', 1);

INSERT INTO subject (name, year, semester, credits, course_weight, lab_weight, seminar_weight) VALUES('Inginerie Software', 3, 'FIRST', 5, 70, 30, 0);
INSERT INTO subject (name, year, semester, credits, course_weight, lab_weight, seminar_weight) VALUES('Programarea Calculatoarelor', 1, 'FIRST', 5, 60, 30, 10);
INSERT INTO subject (name, year, semester, credits, course_weight, lab_weight, seminar_weight) VALUES('Elemente de grafica asistata de calculator', 2, 'SECOND', 4, 60, 40, 0);
INSERT INTO subject (name, year, semester, credits, course_weight, lab_weight, seminar_weight) VALUES('Electrotehnica', 1, 'SECOND', 4, 90, 10, 0);
INSERT INTO subject (name, year, semester, credits, course_weight, lab_weight, seminar_weight) VALUES('Proiectare cu microprocesoare', 3, 'FIRST', 5, 80, 20, 0);
INSERT INTO subject (name, year, semester, credits, course_weight, lab_weight, seminar_weight) VALUES('Arhitectura Calculatoarelor', 2, 'SECOND', 5, 70, 30, 0);


INSERT into schedule(subject_prof_id, `group`, day, time, parity, location) VALUES (1 , 10, 'MONDAY', '08:00:00', 'BOTH', 'D21');
INSERT into schedule(subject_prof_id, `group`, day, time, parity, location)  VALUES (4 , 10, 'MONDAY', '10:00:00', 'BOTH', 'D21');
INSERT into schedule(subject_prof_id, `group`, day, time, parity, location) VALUES (7 , 10, 'MONDAY', '12:00:00', 'BOTH', 'D21');
INSERT into schedule(subject_prof_id, `group`, day, time, parity, location) VALUES (1 , 9, 'MONDAY', '08:00:00', 'BOTH', 'D21');
INSERT into schedule(subject_prof_id, `group`, day, time, parity, location) VALUES (4 , 9, 'MONDAY', '10:00:00', 'BOTH', 'D21');
INSERT into schedule(subject_prof_id, `group`, day, time, parity, location) VALUES (7 , 9, 'MONDAY', '12:00:00', 'BOTH', 'D21');
INSERT into schedule(subject_prof_id, `group`, day, time, parity, location) VALUES (1 , 7, 'MONDAY', '08:00:00', 'BOTH', 'D21');
INSERT into schedule(subject_prof_id, `group`, day, time, parity, location) VALUES (4 , 7, 'MONDAY', '10:00:00', 'BOTH', 'D21');
INSERT into schedule(subject_prof_id, `group`, day, time, parity, location) VALUES (7 , 7, 'MONDAY', '12:00:00', 'BOTH', 'D21');
INSERT into schedule(subject_prof_id, `group`, day, time, parity, location) VALUES (2 , 10, 'TUESDAY', '12:00:00', 'BOTH', '103');
INSERT into schedule(subject_prof_id, `group`, day, time, parity, location) VALUES (5 , 10, 'TUESDAY', '14:00:00', 'BOTH', '105');
INSERT into schedule(subject_prof_id, `group`, day, time, parity, location) VALUES (8 , 10, 'TUESDAY', '16:00:00', 'BOTH', '107');
INSERT into schedule(subject_prof_id, `group`, day, time, parity, location) VALUES (12 , 7, 'TUESDAY', '10:00:00', 'ODD', '107');
INSERT into schedule(subject_prof_id, `group`, day, time, parity, location) VALUES (14 , 7, 'TUESDAY', '12:00:00', 'BOTH', '107');
INSERT into schedule(subject_prof_id, `group`, day, time, parity, location) VALUES (3 , 9, 'WEDNESDAY', '08:00:00', 'EVEN', '36');
INSERT into schedule(subject_prof_id, `group`, day, time, parity, location) VALUES (6 , 9, 'WEDNESDAY', '10:00:00', 'EVEN', '26b');
INSERT into schedule(subject_prof_id, `group`, day, time, parity, location) VALUES (3 , 10, 'WEDNESDAY', '08:00:00', 'ODD', '36');
INSERT into schedule(subject_prof_id, `group`, day, time, parity, location) VALUES (6 , 10, 'WEDNESDAY', '10:00:00', 'ODD', '26b');
INSERT into schedule(subject_prof_id, `group`, day, time, parity, location) VALUES (9 , 10, 'THURSDAY', '08:00:00', 'BOTH', 'D21');
INSERT into schedule(subject_prof_id, `group`, day, time, parity, location) VALUES (11 , 10, 'THURSDAY', '10:00:00', 'BOTH', 'D21');
INSERT into schedule(subject_prof_id, `group`, day, time, parity, location) VALUES (13 , 10, 'THURSDAY', '12:00:00', 'BOTH', 'D21');
INSERT into schedule(subject_prof_id, `group`, day, time, parity, location) VALUES (9 , 9, 'THURSDAY', '08:00:00', 'BOTH', 'D21');
INSERT into schedule(subject_prof_id, `group`, day, time, parity, location) VALUES (11 , 9, 'THURSDAY', '10:00:00', 'BOTH', 'D21');
INSERT into schedule(subject_prof_id, `group`, day, time, parity, location) VALUES (13 , 9, 'THURSDAY', '12:00:00', 'BOTH', 'D21');
INSERT into schedule(subject_prof_id, `group`, day, time, parity, location) VALUES (9 , 7, 'THURSDAY', '08:00:00', 'BOTH', 'D21');
INSERT into schedule(subject_prof_id, `group`, day, time, parity, location) VALUES (11 , 7, 'THURSDAY', '10:00:00', 'BOTH', 'D21');
INSERT into schedule(subject_prof_id, `group`, day, time, parity, location) VALUES (13 , 7, 'THURSDAY', '12:00:00', 'BOTH', 'D21');

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

INSERT INTO teaching(subject_id, professor_id) VALUES (2, 8),
                                                      (2, 10),
                                                      (2, 11),
                                                      (1, 14),
                                                      (3, 19),
                                                      (4, 16),
                                                      (5, 15),
                                                      (6, 17);

INSERT INTO grades (grade, grade_date, teaching_id, student_id) VALUES (8, '12-06-2019', 1, 2);
INSERT INTO grades (grade, grade_date, teaching_id, student_id) VALUES (10, '22-05-2019', 2, 1);
INSERT INTO grades (grade, grade_date, teaching_id, student_id) VALUES (9, '18-06-2019', 5, 2);
INSERT INTO grades (grade, grade_date, teaching_id, student_id) VALUES (7.5, '05-07-2019', 8, 2);
INSERT INTO grades (grade, grade_date, teaching_id, student_id) VALUES (5.6, '05-07-2019', 8, 6);
INSERT INTO grades (grade, grade_date, teaching_id, student_id) VALUES (6, '12-06-2019', 1, 6);
INSERT INTO grades (grade, grade_date, teaching_id, student_id) VALUES (8, '18-06-2019', 5, 6);
INSERT INTO grades (grade, grade_date, teaching_id, student_id) VALUES (9.25, '15-06-2019', 7, 1);
INSERT INTO grades (grade, grade_date, teaching_id, student_id) VALUES (8.70, '09-06-2019', 6, 1);
INSERT INTO grades (grade, grade_date, teaching_id, student_id) VALUES (7.55, '12-06-2019', 1, 3);
INSERT INTO grades (grade, grade_date, teaching_id, student_id) VALUES (9, '12-06-2019', 1, 4);
INSERT INTO grades (grade, grade_date, teaching_id, student_id) VALUES (9.2, '18-06-2019', 5, 3);
INSERT INTO grades (grade, grade_date, teaching_id, student_id) VALUES (8.75, '15-06-2019', 7, 3);














