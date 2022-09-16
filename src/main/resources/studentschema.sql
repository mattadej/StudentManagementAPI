DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
    `id` BIGINT AUTO_INCREMENT,
    `first_name` VARCHAR(255) NOT NULL,
    `second_name` VARCHAR(255) NOT NULL,
    `age` INT NOT NULL,
    `contact_number` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    PRIMARY KEY(`id`)
);