ALTER TABLE `users` ADD activation_token VARCHAR(60);

ALTER TABLE `users` ADD activated BIT;
UPDATE `users` SET activated = TRUE WHERE activated IS NULL;
