CREATE DATABASE  IF NOT EXISTS `star_wars` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `star_wars`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: star_wars
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `planet`
--

DROP TABLE IF EXISTS `planet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `planet` (
  `id` int(11) NOT NULL,
  `name` text,
  `rotation_period` int(11) DEFAULT NULL,
  `orbital_period` int(11) DEFAULT NULL,
  `diameter` int(11) DEFAULT NULL,
  `climate` text,
  `gravity` text,
  `terrain` text,
  `surface_water` text,
  `population` bigint(20) DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT NULL,
  `updated_date` timestamp NULL DEFAULT NULL,
  `url` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planet`
--

LOCK TABLES `planet` WRITE;
/*!40000 ALTER TABLE `planet` DISABLE KEYS */;
INSERT INTO `planet` VALUES (3,'Yavin IV',24,4818,10200,'temperate, tropical','1 standard','jungle, rainforests','8',0,'2014-12-09 23:00:00','2019-11-07 23:00:00','https://swapi.co/api/planets/3/'),(4,'Hoth',23,549,7200,'frozen','1.1 standard','tundra, ice caves, mountain ranges','100',NULL,'2014-12-10 10:39:13','2014-12-20 19:58:18','https://swapi.co/api/planets/4/'),(5,'Dagobah',23,341,8900,'murky','N/A','swamp, jungles','8',NULL,'2014-12-10 10:42:22','2014-12-20 19:58:18','https://swapi.co/api/planets/5/'),(6,'Bespin',12,5110,118000,'temperate','1.5 (surface), 1 standard (Cloud City)','gas giant','0',5999000,'2014-12-09 23:00:00','2019-11-07 23:00:00','https://swapi.co/api/planets/6/');
/*!40000 ALTER TABLE `planet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-08 17:10:26
