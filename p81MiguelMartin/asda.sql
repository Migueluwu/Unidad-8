CREATE DATABASE  IF NOT EXISTS `BaseDeDatosProgramacion` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `BaseDeDatosProgramacion`;
-- MySQL dump 10.13  Distrib 8.0.25, for Linux (x86_64)
--
-- Host: 192.168.56.101    Database: BaseDeDatosProgramacion
-- ------------------------------------------------------
-- Server version	8.0.27-0ubuntu0.20.04.1

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
-- Table structure for table `Libreria`
--

DROP TABLE IF EXISTS `Libreria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Libreria` (
  `numLibreria` int NOT NULL,
  `nomLibreria` varchar(30) DEFAULT NULL,
  `dir` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`numLibreria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Libreria`
--

LOCK TABLES `Libreria` WRITE;
/*!40000 ALTER TABLE `Libreria` DISABLE KEYS */;
/*!40000 ALTER TABLE `Libreria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Librero`
--

DROP TABLE IF EXISTS `Librero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Librero` (
  `idLibrero` int NOT NULL,
  `numLibreria` int NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `apellidos` varchar(60) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `fecNac` date DEFAULT NULL,
  PRIMARY KEY (`numLibreria`,`idLibrero`),
  CONSTRAINT `fk_Librero_Libreria` FOREIGN KEY (`numLibreria`) REFERENCES `Libreria` (`numLibreria`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Librero`
--

LOCK TABLES `Librero` WRITE;
/*!40000 ALTER TABLE `Librero` DISABLE KEYS */;
/*!40000 ALTER TABLE `Librero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Libro`
--

DROP TABLE IF EXISTS `Libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Libro` (
  `IdLibro` int NOT NULL,
  `numLibreria` int NOT NULL,
  `titulo` varchar(30) DEFAULT NULL,
  `autor` varchar(30) DEFAULT NULL,
  `numPag` int DEFAULT NULL,
  PRIMARY KEY (`numLibreria`,`IdLibro`),
  CONSTRAINT `fk_Libro_Libreria` FOREIGN KEY (`numLibreria`) REFERENCES `Libreria` (`numLibreria`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Libro`
--

LOCK TABLES `Libro` WRITE;
/*!40000 ALTER TABLE `Libro` DISABLE KEYS */;
/*!40000 ALTER TABLE `Libro` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-17 14:24:10
