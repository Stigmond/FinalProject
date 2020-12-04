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
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chain`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chain` ;

CREATE TABLE IF NOT EXISTS `chain` (
  `id` INT NOT NULL,
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
  `restaurant_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_main_dish_restaurants1_idx` (`restaurant_id` ASC),
  CONSTRAINT `fk_main_dish_restaurants1`
    FOREIGN KEY (`restaurant_id`)
    REFERENCES `restaurant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
  `restaurant_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_side_dish_restaurants1_idx` (`restaurant_id` ASC),
  CONSTRAINT `fk_side_dish_restaurants1`
    FOREIGN KEY (`restaurant_id`)
    REFERENCES `restaurant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `review`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `review` ;

CREATE TABLE IF NOT EXISTS `review` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `review_score` INT NOT NULL,
  `review` LONGTEXT NULL,
  `review_date` DATETIME NULL,
  `restaurant_id` INT NOT NULL,
  `user_id` INT NOT NULL,
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
  `restaurant_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_sauces_restaurants1_idx` (`restaurant_id` ASC),
  CONSTRAINT `fk_sauces_restaurants1`
    FOREIGN KEY (`restaurant_id`)
    REFERENCES `restaurant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
  `id` INT NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `description` LONGTEXT NULL,
  `image` LONGTEXT NULL,
  `restaurant_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_pitmaster_restaurant1_idx` (`restaurant_id` ASC),
  CONSTRAINT `fk_pitmaster_restaurant1`
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
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `bbqdb`;
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `email`, `enabled`, `role`, `image`, `address_id`) VALUES (DEFAULT, NULL, NULL, 'admin', 'admin', 'fake@gmail.com', 1, 'ROLE_ADMIN', NULL, NULL);

COMMIT;

