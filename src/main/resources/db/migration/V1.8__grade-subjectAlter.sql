RENAME TABLE `subject` TO `class`;

CREATE TABLE `subject` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100),
	`year` INT(4),
	`semester` ENUM('FIRST', 'SECOND'),
	`credits` INT,
	`course_weight` INT,
	`lab_weight` INT,
	`seminar_weight` INT,
	PRIMARY KEY (`id`)
);

ALTER TABLE `class` DROP `name`;
ALTER TABLE `class` ADD `subject_id` INT;
ALTER TABLE `class` ADD FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`);

RENAME TABLE `subject_professors` TO `teaching`;
ALTER TABLE `teaching` RENAME COLUMN `subject_id` TO `class_id`;

ALTER TABLE `grades` DROP `date`;
ALTER TABLE `grades` DROP `year`;
ALTER TABLE `grades` DROP `semester`;
ALTER TABLE `grades` RENAME COLUMN `subject_professor_id` TO `teaching_id`;

CREATE TABLE `final_grades` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `subject_id` INT NOT NULL,
    `student_id` INT NOT NULL,
    `grade` FLOAT,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
    FOREIGN KEY (`student_id`) REFERENCES `users` (`id`)
);

ALTER TABLE `schedule` RENAME COLUMN `subject_prof_id` TO `teaching_id`;