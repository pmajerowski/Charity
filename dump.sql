-- MySQL dump 10.13  Distrib 8.0.32, for Linux (x86_64)
--
-- Host: localhost    Database: charity_donation
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `app_user`
--

DROP TABLE IF EXISTS `app_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `app_user` (
  `id` bigint NOT NULL,
  `app_user_role` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `locked` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_user`
--

LOCK TABLES `app_user` WRITE;
/*!40000 ALTER TABLE `app_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `app_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'ubrania'),(2,'buty'),(3,'żywność'),(4,'zabawki'),(5,'książki'),(6,'kosmetyki'),(7,'artykuły 
kuchenne'),(8,'elektronika'),(9,'inne');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_sequence`
--

DROP TABLE IF EXISTS `category_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_sequence`
--

LOCK TABLES `category_sequence` WRITE;
/*!40000 ALTER TABLE `category_sequence` DISABLE KEYS */;
INSERT INTO `category_sequence` VALUES (10);
/*!40000 ALTER TABLE `category_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `confirmation_token`
--

DROP TABLE IF EXISTS `confirmation_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `confirmation_token` (
  `id` bigint NOT NULL,
  `confirmed_at` datetime(6) DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  `expires_at` datetime(6) NOT NULL,
  `token` varchar(255) NOT NULL,
  `app_user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo9fl25wqyh7w7mnfkdqen1rcm` (`app_user_id`),
  CONSTRAINT `FKo9fl25wqyh7w7mnfkdqen1rcm` FOREIGN KEY (`app_user_id`) REFERENCES `app_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `confirmation_token`
--

LOCK TABLES `confirmation_token` WRITE;
/*!40000 ALTER TABLE `confirmation_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `confirmation_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `confirmation_token_sequence`
--

DROP TABLE IF EXISTS `confirmation_token_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `confirmation_token_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `confirmation_token_sequence`
--

LOCK TABLES `confirmation_token_sequence` WRITE;
/*!40000 ALTER TABLE `confirmation_token_sequence` DISABLE KEYS */;
INSERT INTO `confirmation_token_sequence` VALUES (1);
/*!40000 ALTER TABLE `confirmation_token_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact_requests`
--

DROP TABLE IF EXISTS `contact_requests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact_requests` (
  `id` bigint NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact_requests`
--

LOCK TABLES `contact_requests` WRITE;
/*!40000 ALTER TABLE `contact_requests` DISABLE KEYS */;
/*!40000 ALTER TABLE `contact_requests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donation_sequence`
--

DROP TABLE IF EXISTS `donation_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donation_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donation_sequence`
--

LOCK TABLES `donation_sequence` WRITE;
/*!40000 ALTER TABLE `donation_sequence` DISABLE KEYS */;
INSERT INTO `donation_sequence` VALUES (7);
/*!40000 ALTER TABLE `donation_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donations`
--

DROP TABLE IF EXISTS `donations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donations` (
  `id` bigint NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `pick_up_comment` varchar(500) DEFAULT NULL,
  `pick_up_date` date DEFAULT NULL,
  `pick_up_time` time DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zip_code` varchar(255) DEFAULT NULL,
  `institution_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4vbbe785haqnjerv22xjehvbg` (`institution_id`),
  CONSTRAINT `FK4vbbe785haqnjerv22xjehvbg` FOREIGN KEY (`institution_id`) REFERENCES `institutions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donations`
--

LOCK TABLES `donations` WRITE;
/*!40000 ALTER TABLE `donations` DISABLE KEYS */;
INSERT INTO `donations` VALUES (1,'Warszawa','522674565',NULL,NULL,NULL,10,'Marszałkowska 135','00-410',1),(2,'Berlin','228564756',NULL,NULL,NULL,4,'456 
HossfundStrasse','18745',5),(3,'London','228431076',NULL,NULL,NULL,7,'32 Baker St','00981',1),(4,'Warszawa','888123456','','2023-03-10','12:30:00',2,'Mysia 
12','00-414',4),(5,'Lublin','668429523','Klatka z tyłu budynku','2023-03-25','20:00:00',6,'Kwiatowa 
14B/145','20-007',2),(6,'Słupsk','841233438','','2023-03-15','10:45:00',10,'Sobieskiego 11','76-200',3);
/*!40000 ALTER TABLE `donations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donations_categories`
--

DROP TABLE IF EXISTS `donations_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donations_categories` (
  `donation_id` bigint NOT NULL,
  `category_id` bigint NOT NULL,
  KEY `FKrp6h7l1e7u6lt393c7xrlw688` (`category_id`),
  KEY `FK8vte7y1uahh9hvijwuyp0teci` (`donation_id`),
  CONSTRAINT `FK8vte7y1uahh9hvijwuyp0teci` FOREIGN KEY (`donation_id`) REFERENCES `donations` (`id`),
  CONSTRAINT `FKrp6h7l1e7u6lt393c7xrlw688` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donations_categories`
--

LOCK TABLES `donations_categories` WRITE;
/*!40000 ALTER TABLE `donations_categories` DISABLE KEYS */;
INSERT INTO `donations_categories` VALUES (4,2),(4,4),(5,5),(5,6),(5,8),(6,1),(6,2),(6,4);
/*!40000 ALTER TABLE `donations_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `institution_sequence`
--

DROP TABLE IF EXISTS `institution_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `institution_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `institution_sequence`
--

LOCK TABLES `institution_sequence` WRITE;
/*!40000 ALTER TABLE `institution_sequence` DISABLE KEYS */;
INSERT INTO `institution_sequence` VALUES (6);
/*!40000 ALTER TABLE `institution_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `institutions`
--

DROP TABLE IF EXISTS `institutions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `institutions` (
  `id` bigint NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `institutions`
--

LOCK TABLES `institutions` WRITE;
/*!40000 ALTER TABLE `institutions` DISABLE KEYS */;
INSERT INTO `institutions` VALUES (1,'Pomoc dzieciom z ubogich rodzin','Fundacja \"Dbam o Zdrowie\"'),(2,'Pomoc w wybudzaniu dzieci ze śpiączki','Fundacja \"A 
kogo\"'),(3,'Pomoc osobom znajdującym się w trudnej sytuacji życiowej','Fundacja \"Dla dzieci\"'),(4,'Pomoc dla osób nie posiadających miejsca 
zamieszkania','Fundacja \"Bez domu\"'),(5,'Pomoc dla osób i dzieci przebywających w hospicjach','Fundacja \"Każdy oddech\"');
/*!40000 ALTER TABLE `institutions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request_sequence`
--

DROP TABLE IF EXISTS `request_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `request_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request_sequence`
--

LOCK TABLES `request_sequence` WRITE;
/*!40000 ALTER TABLE `request_sequence` DISABLE KEYS */;
INSERT INTO `request_sequence` VALUES (1);
/*!40000 ALTER TABLE `request_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKl5owutjid2yl0vvu8rh95r0nc` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (2,'ROLE_ADMIN'),(1,'ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`),
  CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_sequence`
--

DROP TABLE IF EXISTS `user_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_sequence`
--

LOCK TABLES `user_sequence` WRITE;
/*!40000 ALTER TABLE `user_sequence` DISABLE KEYS */;
INSERT INTO `user_sequence` VALUES (3);
/*!40000 ALTER TABLE `user_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (2,'test@op.pl','$2a$10$woG1z.t59m0qrg/N1W7m2uQYUToc3QhyxYSw2czLxP1eC9OVwgOPy');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-09 22:01:17
