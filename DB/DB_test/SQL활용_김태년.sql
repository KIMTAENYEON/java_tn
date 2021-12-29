CREATE SCHEMA `school` ;
use school;
CREATE TABLE `school`.`student` (
  `st_num` CHAR(10) NOT NULL,
  `st_name` VARCHAR(20) NOT NULL,
  `st_major` VARCHAR(10) NULL,
  PRIMARY KEY (`st_num`));
show databases;
show tables;