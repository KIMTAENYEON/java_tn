-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: community_tn
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `file` (
  `fi_num` int NOT NULL AUTO_INCREMENT,
  `fi_ori_name` varchar(255) DEFAULT NULL,
  `fi_name` varchar(255) DEFAULT NULL,
  `fi_bd_num` int NOT NULL,
  `fi_del` varchar(2) DEFAULT NULL,
  `fi_del_date` datetime DEFAULT NULL,
  PRIMARY KEY (`fi_num`),
  KEY `FK_board_TO_file_1` (`fi_bd_num`),
  CONSTRAINT `FK_board_TO_file_1` FOREIGN KEY (`fi_bd_num`) REFERENCES `board` (`bd_num`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (1,'게시판 구현 순서.txt','/2022/01/14/2f65c4e2-9c72-4398-8f9e-682e11d706dd_게시판 구현 순서.txt',9,NULL,NULL),(2,'SQL응용_김태년.hwp','/2022/01/18/8e2feded-d04e-483a-9307-ccba62474374_SQL응용_김태년.hwp',9,'Y','2022-01-19 12:50:59'),(3,'SQL활용_김태년.hwp','/2022/01/18/38a0c981-038e-49ef-9e62-0971bb890fb3_SQL활용_김태년.hwp',6,'Y','2022-01-18 09:21:22'),(4,'day1_2_cat.jfif','/2022/01/18/917f3b6d-958d-40b5-ad0b-0715e3454811_day1_2_cat.jfif',18,'Y','2022-01-18 14:47:57'),(5,'day1_2_cat.jfif','/2022/01/18/690b8659-bd26-4c2f-9962-1f590ddf994a_day1_2_cat.jfif',26,NULL,NULL),(6,'day1_2_cat.jfif','/2022/01/19/25961c24-474d-4a6e-a2dc-43df7ecd83d3_day1_2_cat.jfif',9,NULL,NULL),(8,'자바프로그래밍_김태년.hwp','/2022/01/19/4b6ef5b9-1fc3-49e1-b2ee-b7a81ee90fd6_자바프로그래밍_김태년.hwp',32,'Y','2022-01-19 12:54:59'),(9,'요구사항확인_김태년.hwp','/2022/01/19/da2b777d-62a7-4884-a795-fba80cf4dc10_요구사항확인_김태년.hwp',32,'Y','2022-01-19 17:17:35'),(10,'애플리케이션설계_김태년.hwp','/2022/01/19/c80ca808-f30e-431b-8c62-6df9b9dcd912_애플리케이션설계_김태년.hwp',32,'Y','2022-01-19 12:55:14'),(11,'데이터베이스구현_김태년.hwp','/2022/01/19/e05c5db9-e014-43d8-b524-8b2970903925_데이터베이스구현_김태년.hwp',32,'Y','2022-01-19 12:58:42'),(13,'SQL응용_김태년.hwp','/2022/01/19/7889d00a-65b3-4001-9f35-3310e5d7aa49_SQL응용_김태년.hwp',33,'Y','2022-01-19 16:27:52'),(14,'SQL활용_김태년.hwp','/2022/01/19/7815d83e-266b-47ca-b6fb-d67d61c2c624_SQL활용_김태년.hwp',33,'Y','2022-01-19 16:27:46'),(15,'자바프로그래밍_김태년.hwp','/2022/01/19/b29e79eb-357d-4b73-8e4b-a468d8632da0_자바프로그래밍_김태년.hwp',32,'Y','2022-01-19 13:03:12'),(17,'애플리케이션설계_김태년.hwp','/2022/01/19/e607952f-78d3-4bbc-ae0a-6896e15dcfb1_애플리케이션설계_김태년.hwp',32,'Y','2022-01-19 13:03:24'),(20,'데이터베이스구현_김태년.hwp','/2022/01/19/560727bc-ba7c-4266-80e0-dde1bfebc751_데이터베이스구현_김태년.hwp',32,'Y','2022-01-19 13:26:15'),(21,'자바프로그래밍_김태년.hwp','/2022/01/19/8abb109e-2f8b-4191-9f70-97e216a4a884_자바프로그래밍_김태년.hwp',32,'Y','2022-01-19 13:07:39'),(22,'게시판 구현 순서.txt','/2022/01/19/3ffd8f69-fb49-494d-acde-ea8e11d9d4b3_게시판 구현 순서.txt',33,NULL,NULL),(23,'SQL응용_김태년.hwp','/2022/01/19/478c9815-b43d-4f6e-8993-03c59ff059a4_SQL응용_김태년.hwp',33,NULL,NULL),(24,'.gitignore','/2022/01/19/46c80932-f6f4-4437-9c39-20c419884bb0_.gitignore',34,'Y','2022-01-19 17:18:46'),(25,'README.md','/2022/01/19/861a4a65-8cdc-46bd-886f-d83c0070ca7e_README.md',34,'Y','2022-01-19 17:18:46'),(26,'.gitignore','/2022/01/20/59388d92-e504-4307-9a1b-e23f8d3d6dd4_.gitignore',35,'Y','2022-01-20 09:41:55'),(27,'README.md','/2022/01/20/ecb49263-6e5c-4970-a36f-6b2dc60c9874_README.md',35,'Y','2022-01-20 09:41:55');
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-07 17:35:54
