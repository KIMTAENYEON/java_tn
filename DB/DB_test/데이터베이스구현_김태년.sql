CREATE SCHEMA `fruit_shop_exam` ;
use fruit_shop_exam;
CREATE TABLE `fruit_shop_exam`.`fruit` (
  `fr_name` VARCHAR(15) NOT NULL,
  `fr_price` INT NOT NULL,
  `fr_amount` INT NOT NULL,
  PRIMARY KEY (`fr_name`));
CREATE TABLE `fruit_shop_exam`.`trade` (
  `tr_num` INT NOT NULL AUTO_INCREMENT,
  `tr_amount` INT NOT NULL,
  `tr_type` VARCHAR(4) NOT NULL DEFAULT 'sell',
  `tr_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tr_price` INT NOT NULL,
  `tr_fr_name` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`tr_num`),
  INDEX `FK_fruit_idx` (`tr_fr_name` ASC) VISIBLE,
  CONSTRAINT `FK_TRADE_FRUIT`
    FOREIGN KEY (`tr_fr_name`)
    REFERENCES `fruit_shop_exam`.`fruit` (`fr_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);