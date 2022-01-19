ALTER TABLE `community_tn`.`member` 
ADD COLUMN `me_authority` VARCHAR(10) NOT NULL DEFAULT '회원' AFTER `me_phone`;
ALTER TABLE `community_tn`.`board` 
ADD COLUMN `bd_views` INT NOT NULL DEFAULT 0 AFTER `bd_del_date`;
