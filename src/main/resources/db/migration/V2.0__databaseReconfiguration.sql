SET foreign_key_checks = 0;
DROP TABLE IF EXISTS `class`, `final_grades`, `grades`, `group`, `schedule`, `subject`, `teaching`, `users`;
SET foreign_key_checks = 1;

CREATE TABLE `class` (
  `id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `type` ENUM ('COURSE', 'LABORATORY', 'SEMINAR') DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL
);

CREATE TABLE `final_grades` (
  `id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `grade` float DEFAULT NULL,
  `grade_date` date,
  `subject_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL
);

CREATE TABLE `grades` (
  `id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `grade` float DEFAULT NULL,
  `grade_date` date,
  `teaching_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL
);

CREATE TABLE `group` (
  `id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `series_id` int(11) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `faculty` varchar(45) DEFAULT NULL
);

CREATE TABLE `schedule` (
  `teaching_id` int(11) NOT NULL,
  `group` int(11) NOT NULL,
  `day` ENUM ('MONDAY', 'TUESDAY', 'WEDNESDAY', 'THURSDAY', 'FRIDAY') DEFAULT NULL,
  `time` time DEFAULT NULL,
  `parity` ENUM ('ODD', 'EVEN', 'BOTH') DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`teaching_id`, `group`)
);

CREATE TABLE `subject` (
  `id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `year` int(4) DEFAULT NULL,
  `semester` ENUM ('FIRST', 'SECOND') DEFAULT NULL,
  `credits` int(11) DEFAULT NULL,
  `course_weight` int(11) DEFAULT NULL,
  `lab_weight` int(11) DEFAULT NULL,
  `seminar_weight` int(11) DEFAULT NULL
);

CREATE TABLE `teaching` (
  `class_id` int(11) NOT NULL,
  `professor_id` int(11) NOT NULL,
  `id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT
);

CREATE TABLE `users` (
  `id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `role` ENUM ('STUDENT', 'PROFESSOR', 'ADMIN') DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  `activation_token` varchar(60) DEFAULT NULL,
  `activated` bit(1) DEFAULT NULL
);

ALTER TABLE `class` ADD FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`);

ALTER TABLE `final_grades` ADD FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`);

ALTER TABLE `final_grades` ADD FOREIGN KEY (`student_id`) REFERENCES `users` (`id`);

ALTER TABLE `grades` ADD FOREIGN KEY (`teaching_id`) REFERENCES `teaching` (`id`);

ALTER TABLE `grades` ADD FOREIGN KEY (`student_id`) REFERENCES `users` (`id`);

ALTER TABLE `schedule` ADD FOREIGN KEY (`teaching_id`) REFERENCES `teaching` (`id`);

ALTER TABLE `schedule` ADD FOREIGN KEY (`group`) REFERENCES `group` (`id`);

ALTER TABLE `teaching` ADD FOREIGN KEY (`class_id`) REFERENCES `class` (`id`);

ALTER TABLE `teaching` ADD FOREIGN KEY (`professor_id`) REFERENCES `users` (`id`);

ALTER TABLE `users` ADD FOREIGN KEY (`group_id`) REFERENCES `group` (`id`);