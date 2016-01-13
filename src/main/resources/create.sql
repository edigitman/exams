-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `email` VARCHAR(45) NOT NULL COMMENT '',
  `name` VARCHAR(45) NOT NULL COMMENT '',
  `lastname` VARCHAR(45) NOT NULL COMMENT '',
  `password` VARCHAR(45) NULL COMMENT '',
  `enabled` TINYINT(1) NOT NULL COMMENT '',
  `role` VARCHAR(45) NOT NULL COMMENT '',
  `datecreated` TIMESTAMP NULL COMMENT '',
  PRIMARY KEY (`id`, `email`)  COMMENT '')
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`verificationToken`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`verificationToken` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `expiredate` TIMESTAMP NOT NULL DEFAULT now() COMMENT '',
  `token` VARCHAR(37) NOT NULL COMMENT '',
  `verified` TINYINT(1) NULL COMMENT '',
  `userid` INT NOT NULL COMMENT '',
  `datecreated` TIMESTAMP NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  CONSTRAINT `userFK`
  FOREIGN KEY (`userid`)
  REFERENCES `mydb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;

CREATE INDEX `userFK_idx` ON `mydb`.`verificationToken` (`userid` ASC)  COMMENT '';


-- -----------------------------------------------------
-- Table `mydb`.`exam`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`exam` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(100) NOT NULL COMMENT '',
  `userid` INT NOT NULL COMMENT '',
  `dificulty` VARCHAR(10) NULL COMMENT '',
  `datecreated` TIMESTAMP NULL DEFAULT now() COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  CONSTRAINT `profid`
  FOREIGN KEY (`userid`)
  REFERENCES `mydb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;

CREATE INDEX `profid_idx` ON `mydb`.`exam` (`userid` ASC)  COMMENT '';


-- -----------------------------------------------------
-- Table `mydb`.`egroup`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`egroup` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`examinstance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`examinstance` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NOT NULL COMMENT '',
  `status` INT NULL COMMENT '',
  `startdate` TIMESTAMP NULL COMMENT '',
  `enddate` TIMESTAMP NULL COMMENT '',
  `points` DECIMAL NULL COMMENT '',
  `examid` INT NULL COMMENT '',
  `egroupid` INT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  CONSTRAINT `exam-fk`
  FOREIGN KEY (`examid`)
  REFERENCES `mydb`.`exam` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `egroup-fk`
  FOREIGN KEY (`egroupid`)
  REFERENCES `mydb`.`egroup` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;

CREATE INDEX `exam-fk_idx` ON `mydb`.`examinstance` (`examid` ASC)  COMMENT '';

CREATE INDEX `egroup-fk_idx` ON `mydb`.`examinstance` (`egroupid` ASC)  COMMENT '';


-- -----------------------------------------------------
-- Table `mydb`.`egroupuser`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`egroupuser` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `groupid` INT NOT NULL COMMENT '',
  `userid` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  CONSTRAINT `user-fk`
  FOREIGN KEY (`userid`)
  REFERENCES `mydb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `group-fk`
  FOREIGN KEY (`groupid`)
  REFERENCES `mydb`.`egroup` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;

CREATE INDEX `user-fk_idx` ON `mydb`.`egroupuser` (`userid` ASC)  COMMENT '';

CREATE INDEX `group-fk_idx` ON `mydb`.`egroupuser` (`groupid` ASC)  COMMENT '';


-- -----------------------------------------------------
-- Table `mydb`.`examitem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`examitem` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `assertion` VARCHAR(200) NOT NULL COMMENT '',
  `difficulty` INT NULL COMMENT '',
  `points` DECIMAL NULL COMMENT '',
  `type` INT NULL COMMENT '',
  `examid` INT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  CONSTRAINT `examitem-exam-fk`
  FOREIGN KEY (`examid`)
  REFERENCES `mydb`.`exam` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;

CREATE INDEX `exam-fk_idx` ON `mydb`.`examitem` (`examid` ASC)  COMMENT '';


-- -----------------------------------------------------
-- Table `mydb`.`examitemanswer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`examitemanswer` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `correct` TINYINT(1) NOT NULL COMMENT '',
  `value` VARCHAR(100) NOT NULL COMMENT '',
  `itemid` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  CONSTRAINT `eia-item-fk`
  FOREIGN KEY (`itemid`)
  REFERENCES `mydb`.`examitem` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;

CREATE INDEX `item-fk_idx` ON `mydb`.`examitemanswer` (`itemid` ASC)  COMMENT '';


-- -----------------------------------------------------
-- Table `mydb`.`studexaminstance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`studexaminstance` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `examid` INT NOT NULL COMMENT '',
  `userid` INT NOT NULL COMMENT '',
  `status` INT NOT NULL COMMENT '',
  `datecreated` TIMESTAMP NOT NULL DEFAULT NOW() COMMENT '',
  `dateupdated` TIMESTAMP NOT NULL DEFAULT NOW() COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  CONSTRAINT `sei-exam-fk`
  FOREIGN KEY (`examid`)
  REFERENCES `mydb`.`examinstance` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `sei-user-fk`
  FOREIGN KEY (`userid`)
  REFERENCES `mydb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;

CREATE INDEX `user-fk_idx` ON `mydb`.`studexaminstance` (`userid` ASC)  COMMENT '';

CREATE INDEX `exam-fk_idx` ON `mydb`.`studexaminstance` (`examid` ASC)  COMMENT '';


-- -----------------------------------------------------
-- Table `mydb`.`studexamanswer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`studexamanswer` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `studexaminst` INT NOT NULL COMMENT '',
  `examitem` INT NOT NULL COMMENT '',
  `value` VARCHAR(45) NOT NULL COMMENT '',
  `datecreated` TIMESTAMP NOT NULL DEFAULT now() COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  CONSTRAINT `studexaminst-fk`
  FOREIGN KEY (`studexaminst`)
  REFERENCES `mydb`.`studexaminstance` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `examitem-fk`
  FOREIGN KEY (`examitem`)
  REFERENCES `mydb`.`examitem` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;

CREATE INDEX `studexaminst-fk_idx` ON `mydb`.`studexamanswer` (`studexaminst` ASC)  COMMENT '';

CREATE INDEX `examitem-fk_idx` ON `mydb`.`studexamanswer` (`examitem` ASC)  COMMENT '';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
