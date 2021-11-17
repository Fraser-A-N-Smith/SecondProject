DROP TABLE IF EXISTS `order` CASCADE;
CREATE TABLE `order`
(
	`order_id` BIGINT PRIMARY KEY AUTO_INCREMENT,
	`drink_id` BIGINT,
	`food_id` BIGINT,
	`table_id` BIGINT,
    `tav_table_id` BIGINT
);