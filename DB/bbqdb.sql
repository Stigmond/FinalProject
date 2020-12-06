-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bbqdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bbqdb` ;

-- -----------------------------------------------------
-- Schema bbqdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bbqdb` DEFAULT CHARACTER SET utf8 ;
USE `bbqdb` ;

-- -----------------------------------------------------
-- Table `address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address` ;

CREATE TABLE IF NOT EXISTS `address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(100) NULL,
  `city` VARCHAR(100) NULL,
  `state` VARCHAR(2) NULL,
  `zip` VARCHAR(5) NULL,
  `enabled` TINYINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chain`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chain` ;

CREATE TABLE IF NOT EXISTS `chain` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `logo` LONGTEXT NULL,
  `website` VARCHAR(1000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `restaurant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `restaurant` ;

CREATE TABLE IF NOT EXISTS `restaurant` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `phone_number` VARCHAR(45) NULL,
  `description` LONGTEXT NULL,
  `website` VARCHAR(5000) NULL,
  `logo` LONGTEXT NULL,
  `dine_in` TINYINT NULL,
  `hours` VARCHAR(1000) NULL,
  `enabled` TINYINT NOT NULL,
  `address_id` INT NOT NULL,
  `chain_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_restaurants_address1_idx` (`address_id` ASC),
  INDEX `fk_restaurant_chain1_idx` (`chain_id` ASC),
  CONSTRAINT `fk_restaurants_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_restaurant_chain1`
    FOREIGN KEY (`chain_id`)
    REFERENCES `chain` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  `role` VARCHAR(45) NOT NULL,
  `image` LONGTEXT NULL,
  `address_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_address1_idx` (`address_id` ASC),
  CONSTRAINT `fk_user_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `main_dish`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `main_dish` ;

CREATE TABLE IF NOT EXISTS `main_dish` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `meat_type` VARCHAR(100) NULL,
  `description` LONGTEXT NULL,
  `prep_type` VARCHAR(100) NULL,
  `image` LONGTEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `side_dish`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `side_dish` ;

CREATE TABLE IF NOT EXISTS `side_dish` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(200) NULL,
  `image` LONGTEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `review`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `review` ;

CREATE TABLE IF NOT EXISTS `review` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `review_score` INT NOT NULL,
  `review` LONGTEXT NULL,
  `review_date` DATE NULL,
  `restaurant_id` INT NULL,
  `user_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_reviews_restaurants_idx` (`restaurant_id` ASC),
  INDEX `fk_reviews_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_reviews_restaurants`
    FOREIGN KEY (`restaurant_id`)
    REFERENCES `restaurant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reviews_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sauce`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sauce` ;

CREATE TABLE IF NOT EXISTS `sauce` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(200) NULL,
  `image` LONGTEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `style`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `style` ;

CREATE TABLE IF NOT EXISTS `style` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` LONGTEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `style_has_restaurant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `style_has_restaurant` ;

CREATE TABLE IF NOT EXISTS `style_has_restaurant` (
  `style_id` INT NOT NULL,
  `restaurant_id` INT NOT NULL,
  PRIMARY KEY (`style_id`, `restaurant_id`),
  INDEX `fk_style_has_restaurant_restaurant1_idx` (`restaurant_id` ASC),
  INDEX `fk_style_has_restaurant_style1_idx` (`style_id` ASC),
  CONSTRAINT `fk_style_has_restaurant_style1`
    FOREIGN KEY (`style_id`)
    REFERENCES `style` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_style_has_restaurant_restaurant1`
    FOREIGN KEY (`restaurant_id`)
    REFERENCES `restaurant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pitmaster`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pitmaster` ;

CREATE TABLE IF NOT EXISTS `pitmaster` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `description` LONGTEXT NULL,
  `image` LONGTEXT NULL,
  `restaurant_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_pitmaster_restaurant1_idx` (`restaurant_id` ASC),
  CONSTRAINT `fk_pitmaster_restaurant1`
    FOREIGN KEY (`restaurant_id`)
    REFERENCES `restaurant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sauce_has_restaurant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sauce_has_restaurant` ;

CREATE TABLE IF NOT EXISTS `sauce_has_restaurant` (
  `sauce_id` INT NOT NULL,
  `restaurant_id` INT NOT NULL,
  PRIMARY KEY (`sauce_id`, `restaurant_id`),
  INDEX `fk_sauce_has_restaurant_restaurant1_idx` (`restaurant_id` ASC),
  INDEX `fk_sauce_has_restaurant_sauce1_idx` (`sauce_id` ASC),
  CONSTRAINT `fk_sauce_has_restaurant_sauce1`
    FOREIGN KEY (`sauce_id`)
    REFERENCES `sauce` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sauce_has_restaurant_restaurant1`
    FOREIGN KEY (`restaurant_id`)
    REFERENCES `restaurant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `side_dish_has_restaurant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `side_dish_has_restaurant` ;

CREATE TABLE IF NOT EXISTS `side_dish_has_restaurant` (
  `side_dish_id` INT NOT NULL,
  `restaurant_id` INT NOT NULL,
  PRIMARY KEY (`side_dish_id`, `restaurant_id`),
  INDEX `fk_side_dish_has_restaurant_restaurant1_idx` (`restaurant_id` ASC),
  INDEX `fk_side_dish_has_restaurant_side_dish1_idx` (`side_dish_id` ASC),
  CONSTRAINT `fk_side_dish_has_restaurant_side_dish1`
    FOREIGN KEY (`side_dish_id`)
    REFERENCES `side_dish` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_side_dish_has_restaurant_restaurant1`
    FOREIGN KEY (`restaurant_id`)
    REFERENCES `restaurant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `main_dish_has_restaurant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `main_dish_has_restaurant` ;

CREATE TABLE IF NOT EXISTS `main_dish_has_restaurant` (
  `main_dish_id` INT NOT NULL,
  `restaurant_id` INT NOT NULL,
  PRIMARY KEY (`main_dish_id`, `restaurant_id`),
  INDEX `fk_main_dish_has_restaurant_restaurant1_idx` (`restaurant_id` ASC),
  INDEX `fk_main_dish_has_restaurant_main_dish1_idx` (`main_dish_id` ASC),
  CONSTRAINT `fk_main_dish_has_restaurant_main_dish1`
    FOREIGN KEY (`main_dish_id`)
    REFERENCES `main_dish` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_main_dish_has_restaurant_restaurant1`
    FOREIGN KEY (`restaurant_id`)
    REFERENCES `restaurant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS bbquser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'bbquser'@'localhost' IDENTIFIED BY 'bbquser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'bbquser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `address`
-- -----------------------------------------------------
START TRANSACTION;
USE `bbqdb`;
INSERT INTO `address` (`id`, `street`, `city`, `state`, `zip`, `enabled`) VALUES (1, '315 South 31st Street', 'Colorado Springs', 'CO', '80904', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `chain`
-- -----------------------------------------------------
START TRANSACTION;
USE `bbqdb`;
INSERT INTO `chain` (`id`, `name`, `logo`, `website`) VALUES (1, 'Rudy\'s \"Country Store\" and Bar-B-Q', 'https://rudysbbq.com/img/logo.png', 'https://rudysbbq.com/');

COMMIT;


-- -----------------------------------------------------
-- Data for table `restaurant`
-- -----------------------------------------------------
START TRANSACTION;
USE `bbqdb`;
INSERT INTO `restaurant` (`id`, `name`, `phone_number`, `description`, `website`, `logo`, `dine_in`, `hours`, `enabled`, `address_id`, `chain_id`) VALUES (1, 'Rudy\'s \"Country Store\" and Bar-B-Q', '7194714120', 'Brisket, Ribs & sides served up cafeteria-style in a no fills settings with indoor picnic tables', 'https://rudysbbq.com/location/detail/colorado-springs-co', 'https://rudysbbq.com/img/logo.png', 1, 'Sun-Thu 7am-9pm\nFri-Sat 7am-10pm', 1, 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `bbqdb`;
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `email`, `enabled`, `role`, `image`, `address_id`) VALUES (1, 'Bob', 'Jones', 'admin', 'admin', 'fake@gmail.com', 1, 'ROLE_ADMIN', NULL, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `main_dish`
-- -----------------------------------------------------
START TRANSACTION;
USE `bbqdb`;
INSERT INTO `main_dish` (`id`, `name`, `meat_type`, `description`, `prep_type`, `image`) VALUES (1, 'Pork Spare Ribs', 'Pork', 'Pork spare ribs are taken from the belly side of the pig\'s rib cage above the sternum (breast bone) and below the back ribs which extend about 6\" down from the spine.', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `side_dish`
-- -----------------------------------------------------
START TRANSACTION;
USE `bbqdb`;
INSERT INTO `side_dish` (`id`, `name`, `description`, `image`) VALUES (1, 'JUMBO SMOKED POTATO WITH 2 MEATS', 'Potato stacked with meat of your choice and cheese', 'https://s3-media0.fl.yelpcdn.com/bphoto/l9xszqZ5TBvMb39y8NEBGA/180s.jpg');

COMMIT;


-- -----------------------------------------------------
-- Data for table `review`
-- -----------------------------------------------------
START TRANSACTION;
USE `bbqdb`;
INSERT INTO `review` (`id`, `review_score`, `review`, `review_date`, `restaurant_id`, `user_id`) VALUES (1, 5, 'tasty food', '2020/10/20', 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `sauce`
-- -----------------------------------------------------
START TRANSACTION;
USE `bbqdb`;
INSERT INTO `sauce` (`id`, `name`, `description`, `image`) VALUES (1, 'ORIGINAL BAR-B-Q SAUCE', 'This sause and our Texas brisket put us on the map.  Great for the pantry, a gift to a good friend or even a bloody mary.  ', 'https://cdn11.bigcommerce.com/s-vzdxh8cvru/images/stencil/1024x1024/products/112/378/DSC01232_1132x954__14831.1474916701.jpg?c=2');

COMMIT;


-- -----------------------------------------------------
-- Data for table `style`
-- -----------------------------------------------------
START TRANSACTION;
USE `bbqdb`;
INSERT INTO `style` (`id`, `name`, `description`) VALUES (1, 'Texas Style', 'Our pits are 100% wood fired with oak, a slower burning wood than the mesquite used by others.');

COMMIT;


-- -----------------------------------------------------
-- Data for table `style_has_restaurant`
-- -----------------------------------------------------
START TRANSACTION;
USE `bbqdb`;
INSERT INTO `style_has_restaurant` (`style_id`, `restaurant_id`) VALUES (1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `pitmaster`
-- -----------------------------------------------------
START TRANSACTION;
USE `bbqdb`;
INSERT INTO `pitmaster` (`id`, `first_name`, `last_name`, `description`, `image`, `restaurant_id`) VALUES (1, 'Larry', 'Dude', 'Amazing at smoking', NULL, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `sauce_has_restaurant`
-- -----------------------------------------------------
START TRANSACTION;
USE `bbqdb`;
INSERT INTO `sauce_has_restaurant` (`sauce_id`, `restaurant_id`) VALUES (1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `side_dish_has_restaurant`
-- -----------------------------------------------------
START TRANSACTION;
USE `bbqdb`;
INSERT INTO `side_dish_has_restaurant` (`side_dish_id`, `restaurant_id`) VALUES (1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `main_dish_has_restaurant`
-- -----------------------------------------------------
START TRANSACTION;
USE `bbqdb`;
INSERT INTO `main_dish_has_restaurant` (`main_dish_id`, `restaurant_id`) VALUES (1, 1);

COMMIT;

