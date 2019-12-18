ALTER TABLE `users` ADD activated BIT;

UPDATE `users` SET activated = TRUE WHERE activated IS NULL;
