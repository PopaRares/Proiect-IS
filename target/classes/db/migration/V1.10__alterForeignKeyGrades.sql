ALTER TABLE `grades`
ADD CONSTRAINT `teaching_fk`
    FOREIGN KEY (`teaching_id`) REFERENCES `teaching` (`id`);