DROP TABLE IF EXISTS `tavern_table` CASCADE;
CREATE TABLE `tavern_table`
(
	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
	`has_magic` BIT(1),
	`party_name` VARCHAR(255),
	`party_tab` BIGINT
);