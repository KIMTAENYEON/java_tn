CREATE TABLE `community_tn`.`comment` (
  `co_num` INT NOT NULL AUTO_INCREMENT,
  `co_bd_num` INT NOT NULL,
  `co_me_id` VARCHAR(20) NOT NULL,
  `co_reg_date` DATETIME NOT NULL DEFAULT now(),
  `co_del` VARCHAR(2) NOT NULL DEFAULT 'N',
  `co_ori_num` INT NOT NULL,
  `co_content` LONGTEXT NOT NULL,
  PRIMARY KEY (`co_num`));
ALTER TABLE `community_tn`.`comment` 
ADD INDEX `co_bd_num_idx` (`co_bd_num` ASC) VISIBLE;
;
ALTER TABLE `community_tn`.`comment` 
ADD CONSTRAINT `co_bd_num`
  FOREIGN KEY (`co_bd_num`)
  REFERENCES `community_tn`.`board` (`bd_num`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
ALTER TABLE `community_tn`.`comment` 
ADD INDEX `co_bd_num_idx` (`co_bd_num` ASC) VISIBLE;
;
ALTER TABLE `community_tn`.`comment` 
ADD CONSTRAINT `co_bd_num`
  FOREIGN KEY (`co_bd_num`)
  REFERENCES `community_tn`.`board` (`bd_num`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
