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
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `co_num` int NOT NULL AUTO_INCREMENT,
  `co_bd_num` int NOT NULL,
  `co_me_id` varchar(20) NOT NULL,
  `co_reg_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `co_del` varchar(2) NOT NULL DEFAULT 'N',
  `co_ori_num` int NOT NULL,
  `co_content` longtext NOT NULL,
  PRIMARY KEY (`co_num`),
  KEY `co_bd_num_idx` (`co_bd_num`),
  KEY `co_me_id_idx` (`co_me_id`),
  CONSTRAINT `co_bd_num` FOREIGN KEY (`co_bd_num`) REFERENCES `board` (`bd_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `co_me_id` FOREIGN KEY (`co_me_id`) REFERENCES `member` (`me_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,43,'qwe','2022-01-24 11:08:56','N',1,'zz'),(2,43,'qwe','2022-01-24 12:12:31','N',2,'fdzz'),(3,43,'qwe','2022-01-24 12:42:35','N',3,'aa'),(4,33,'qwe','2022-01-24 14:26:31','N',4,'수정'),(5,33,'qwe','2022-01-24 14:26:35','N',5,'2'),(6,33,'qwe','2022-01-24 14:26:37','Y',6,'3'),(7,33,'qwe','2022-01-24 14:26:40','N',7,'4'),(8,33,'qwe','2022-01-24 14:26:42','N',8,'5'),(9,33,'qwe','2022-01-24 14:26:45','N',9,'6'),(10,33,'qwe','2022-01-24 16:50:53','N',10,'7'),(11,33,'qwe','2022-01-24 17:09:32','N',11,'8'),(13,33,'qwe','2022-01-25 15:18:18','N',4,'답글'),(14,43,'qwe','2022-01-25 16:21:11','N',14,'댓글 수정'),(15,43,'qwe','2022-01-25 16:36:11','Y',14,'답글 테스트'),(16,44,'qwe','2022-01-26 12:54:17','N',16,'댓글등록'),(17,44,'qwe','2022-01-26 14:19:52','N',17,'댓글 2'),(21,44,'qwe','2022-02-03 09:26:27','Y',18,'댓글 3'),(22,44,'qwe','2022-02-03 09:26:39','Y',22,'댓글4'),(23,44,'qwe','2022-02-03 09:27:37','N',23,'댓글 3 수정'),(24,44,'qwe','2022-02-03 12:59:03','N',24,'댓글 4'),(25,44,'qwe','2022-02-03 13:01:20','N',23,'답글'),(26,44,'qwe','2022-02-03 13:05:05','N',24,'4');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
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
