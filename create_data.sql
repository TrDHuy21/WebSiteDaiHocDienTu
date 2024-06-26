CREATE DATABASE  IF NOT EXISTS `ttcn_nhom2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ttcn_nhom2`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ttcn_nhom2
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `chuong_trinh_hoc`
--

DROP TABLE IF EXISTS `chuong_trinh_hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chuong_trinh_hoc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nganh_id` int DEFAULT NULL,
  `state` tinyint DEFAULT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa67dcxp4hik3nxqlqgmk410yi` (`nganh_id`),
  CONSTRAINT `FKa67dcxp4hik3nxqlqgmk410yi` FOREIGN KEY (`nganh_id`) REFERENCES `nganh` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chuong_trinh_hoc`
--

LOCK TABLES `chuong_trinh_hoc` WRITE;
/*!40000 ALTER TABLE `chuong_trinh_hoc` DISABLE KEYS */;
INSERT INTO `chuong_trinh_hoc` VALUES (3,1,1,'đổi mới','k16'),(4,1,1,'đổi mới','k16'),(5,1,1,'hello','k19'),(6,1,1,'abc','k18'),(7,1,1,'abc','k18'),(8,1,1,'abcas','k10');
/*!40000 ALTER TABLE `chuong_trinh_hoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giang_vien`
--

DROP TABLE IF EXISTS `giang_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giang_vien` (
  `khoa_id` int DEFAULT NULL,
  `state` tinyint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_a0w33f6porsmq3ef4npy05071` (`user_id`),
  KEY `FKcen0d53qsoc57u3oaxmflcm5p` (`khoa_id`),
  CONSTRAINT `FKcen0d53qsoc57u3oaxmflcm5p` FOREIGN KEY (`khoa_id`) REFERENCES `khoa` (`id`),
  CONSTRAINT `FKkvk2hs42wx63ov76sm4yanpiy` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giang_vien`
--

LOCK TABLES `giang_vien` WRITE;
/*!40000 ALTER TABLE `giang_vien` DISABLE KEYS */;
INSERT INTO `giang_vien` VALUES (1,1,2,'GV_00001'),(1,1,5,'GV_00002'),(1,1,6,'GV_00003'),(1,1,7,'GV_00004'),(1,1,11,'GV_00005'),(1,1,12,'GV_00006'),(1,1,13,'GV_00007'),(1,1,14,'GV_00008'),(1,1,15,'GV_00009'),(2,1,16,'GV_00010'),(2,1,17,'GV_00011'),(4,1,18,'GV_00012'),(4,1,19,'GV_00013'),(5,1,20,'GV_00014'),(5,1,21,'GV_00015'),(3,1,22,'GV_00016'),(3,1,23,'GV_00017'),(3,1,24,'GV_00018'),(4,1,25,'GV_00019'),(5,1,26,'GV_00020');
/*!40000 ALTER TABLE `giang_vien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gv_seq`
--

DROP TABLE IF EXISTS `gv_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gv_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gv_seq`
--

LOCK TABLES `gv_seq` WRITE;
/*!40000 ALTER TABLE `gv_seq` DISABLE KEYS */;
INSERT INTO `gv_seq` VALUES (1),(1);
/*!40000 ALTER TABLE `gv_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ket_qua_hoc_tap`
--

DROP TABLE IF EXISTS `ket_qua_hoc_tap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ket_qua_hoc_tap` (
  `giua_ki1` float DEFAULT NULL,
  `giua_ki2` float DEFAULT NULL,
  `giua_ki3` float DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `phuc_khao_1` float DEFAULT NULL,
  `phuc_khao_2` float DEFAULT NULL,
  `qua_trinh_hoc_tap_id` int DEFAULT NULL,
  `thi1` float DEFAULT NULL,
  `thi2` float DEFAULT NULL,
  `tx1` float DEFAULT NULL,
  `tx2` float DEFAULT NULL,
  `tx3` float DEFAULT NULL,
  `mon_hoc_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_rocmfscx9c19y7wuk5v3tt4st` (`qua_trinh_hoc_tap_id`),
  KEY `FKrd48dp8ownucfox5g6o1hmx66` (`mon_hoc_id`),
  CONSTRAINT `FK5u2hh698ybwjs6nopvwb73p5v` FOREIGN KEY (`qua_trinh_hoc_tap_id`) REFERENCES `qua_trinh_hoc_tap` (`id`),
  CONSTRAINT `FKrd48dp8ownucfox5g6o1hmx66` FOREIGN KEY (`mon_hoc_id`) REFERENCES `mon_hoc` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ket_qua_hoc_tap`
--

LOCK TABLES `ket_qua_hoc_tap` WRITE;
/*!40000 ALTER TABLE `ket_qua_hoc_tap` DISABLE KEYS */;
INSERT INTO `ket_qua_hoc_tap` VALUES (NULL,NULL,NULL,2,NULL,NULL,3,NULL,NULL,NULL,NULL,NULL,NULL),(NULL,NULL,NULL,3,NULL,NULL,4,NULL,NULL,NULL,NULL,NULL,NULL),(9,1,1,4,1,1,5,1,1,1,1,1,NULL),(9,1,1,5,1,1,6,1,1,1,1,1,NULL),(9,1,1,8,1,1,NULL,1,1,1,1,1,NULL),(NULL,NULL,NULL,9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(NULL,NULL,NULL,10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(NULL,NULL,NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(NULL,NULL,NULL,12,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(NULL,NULL,NULL,13,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `ket_qua_hoc_tap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khoa`
--

DROP TABLE IF EXISTS `khoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khoa` (
  `id` int NOT NULL AUTO_INCREMENT,
  `state` tinyint DEFAULT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khoa`
--

LOCK TABLES `khoa` WRITE;
/*!40000 ALTER TABLE `khoa` DISABLE KEYS */;
INSERT INTO `khoa` VALUES (1,1,'Khoa cong nghe thong tin','CNTT'),(2,1,'Cơ khí','CK'),(3,1,'Công nghệ Ô tô','CNOT'),(4,1,'Điện','DIEN'),(5,1,'Công nghệ Hoá','CNH'),(6,1,'Kế toán - Kiểm toán.','KTKT');
/*!40000 ALTER TABLE `khoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lop_chinh_quy`
--

DROP TABLE IF EXISTS `lop_chinh_quy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lop_chinh_quy` (
  `chuong_trinh_hoc_id` int DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `khoa` int DEFAULT NULL,
  `state` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3f5didfujsntf9eh2md3cj1yf` (`chuong_trinh_hoc_id`),
  CONSTRAINT `FK3f5didfujsntf9eh2md3cj1yf` FOREIGN KEY (`chuong_trinh_hoc_id`) REFERENCES `chuong_trinh_hoc` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lop_chinh_quy`
--

LOCK TABLES `lop_chinh_quy` WRITE;
/*!40000 ALTER TABLE `lop_chinh_quy` DISABLE KEYS */;
/*!40000 ALTER TABLE `lop_chinh_quy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lop_mon_hoc`
--

DROP TABLE IF EXISTS `lop_mon_hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lop_mon_hoc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `mon_hoc_id` int DEFAULT NULL,
  `state` tinyint DEFAULT NULL,
  `ngay_bat_dau` date DEFAULT NULL,
  `giang_vien_id` varchar(255) DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `khoa_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl8yhig40y30coowmqhtd34obr` (`giang_vien_id`),
  KEY `FK9myvf12yau7oi2eh40q1ekgaa` (`mon_hoc_id`),
  KEY `fg_khoa_idx` (`khoa_id`),
  CONSTRAINT `fg_khoa` FOREIGN KEY (`khoa_id`) REFERENCES `khoa` (`id`),
  CONSTRAINT `FK9myvf12yau7oi2eh40q1ekgaa` FOREIGN KEY (`mon_hoc_id`) REFERENCES `mon_hoc` (`id`),
  CONSTRAINT `FKl8yhig40y30coowmqhtd34obr` FOREIGN KEY (`giang_vien_id`) REFERENCES `giang_vien` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lop_mon_hoc`
--

LOCK TABLES `lop_mon_hoc` WRITE;
/*!40000 ALTER TABLE `lop_mon_hoc` DISABLE KEYS */;
INSERT INTO `lop_mon_hoc` VALUES (1,1,1,'2024-05-20','GV_00001','Lập trình java nâng cao 1',1),(2,1,1,'2024-05-20','GV_00001','Lập trình java nâng cao 2',1),(3,2,1,'2024-05-21','GV_00001','Trí tuệ nhân tạo 1',1),(10,1,NULL,NULL,NULL,'	 Lập trình java nâng cao 3',1);
/*!40000 ALTER TABLE `lop_mon_hoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lopmonhoc_sinhvien`
--

DROP TABLE IF EXISTS `lopmonhoc_sinhvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lopmonhoc_sinhvien` (
  `sinh_vien_id` varchar(255) NOT NULL,
  `lop_mon_hoc_id` int NOT NULL,
  KEY `FK38i2byp9rfl47j14kx6vre47e` (`lop_mon_hoc_id`),
  KEY `FKq51xqp6eqrqds3dayhtohcvgq` (`sinh_vien_id`),
  CONSTRAINT `FK38i2byp9rfl47j14kx6vre47e` FOREIGN KEY (`lop_mon_hoc_id`) REFERENCES `lop_mon_hoc` (`id`),
  CONSTRAINT `FKq51xqp6eqrqds3dayhtohcvgq` FOREIGN KEY (`sinh_vien_id`) REFERENCES `sinh_vien` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lopmonhoc_sinhvien`
--

LOCK TABLES `lopmonhoc_sinhvien` WRITE;
/*!40000 ALTER TABLE `lopmonhoc_sinhvien` DISABLE KEYS */;
INSERT INTO `lopmonhoc_sinhvien` VALUES ('SV_00001',1),('SV_00002',1),('SV_00003',1),('SV_00004',1);
/*!40000 ALTER TABLE `lopmonhoc_sinhvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mon_hoc`
--

DROP TABLE IF EXISTS `mon_hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mon_hoc` (
  `he_so_giua_ki1` float DEFAULT NULL,
  `he_so_giua_ki2` float DEFAULT NULL,
  `he_so_giua_ki3` float DEFAULT NULL,
  `he_so_thi` float DEFAULT NULL,
  `he_so_tx1` float DEFAULT NULL,
  `he_so_tx2` float DEFAULT NULL,
  `he_so_tx3` float DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `khoa_id` int DEFAULT NULL,
  `so_tin` int DEFAULT NULL,
  `state` tinyint DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmu52ftg6qdrfy0j3oy5w3q6b9` (`khoa_id`),
  CONSTRAINT `FKmu52ftg6qdrfy0j3oy5w3q6b9` FOREIGN KEY (`khoa_id`) REFERENCES `khoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mon_hoc`
--

LOCK TABLES `mon_hoc` WRITE;
/*!40000 ALTER TABLE `mon_hoc` DISABLE KEYS */;
INSERT INTO `mon_hoc` VALUES (NULL,NULL,NULL,0.5,0.2,0.3,NULL,1,1,3,1,'Lập trình java nâng cao'),(NULL,NULL,NULL,0.6,0.2,0.2,NULL,2,1,3,1,'Trí tuệ nhân tạo'),(NULL,NULL,NULL,1,NULL,NULL,NULL,3,1,3,1,'Thực tập chuyên ngành'),(NULL,NULL,NULL,0.7,0.15,0.15,NULL,8,1,3,1,'Nhập môn lập trình máy tính');
/*!40000 ALTER TABLE `mon_hoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monhoc_chuong_trinh_hoc`
--

DROP TABLE IF EXISTS `monhoc_chuong_trinh_hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monhoc_chuong_trinh_hoc` (
  `chuong_trinh_hoc_id` int NOT NULL,
  `mon_hoc_id` int NOT NULL,
  KEY `FK64kx6l6mhni3p1rxr3uknftqx` (`chuong_trinh_hoc_id`),
  KEY `FKd47pba5vb4hp2mglcsluxxtrj` (`mon_hoc_id`),
  CONSTRAINT `FK64kx6l6mhni3p1rxr3uknftqx` FOREIGN KEY (`chuong_trinh_hoc_id`) REFERENCES `chuong_trinh_hoc` (`id`),
  CONSTRAINT `FKd47pba5vb4hp2mglcsluxxtrj` FOREIGN KEY (`mon_hoc_id`) REFERENCES `mon_hoc` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monhoc_chuong_trinh_hoc`
--

LOCK TABLES `monhoc_chuong_trinh_hoc` WRITE;
/*!40000 ALTER TABLE `monhoc_chuong_trinh_hoc` DISABLE KEYS */;
/*!40000 ALTER TABLE `monhoc_chuong_trinh_hoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monhoc_giangvien`
--

DROP TABLE IF EXISTS `monhoc_giangvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monhoc_giangvien` (
  `mon_hoc_id` int NOT NULL,
  `giang_vien_id` varchar(255) NOT NULL,
  KEY `FKbdg4xgj2ucvrsuppj9o6ufuj` (`giang_vien_id`),
  KEY `FKq71pkxwxrl8ajclujrw8wxkiw` (`mon_hoc_id`),
  CONSTRAINT `FKbdg4xgj2ucvrsuppj9o6ufuj` FOREIGN KEY (`giang_vien_id`) REFERENCES `giang_vien` (`id`),
  CONSTRAINT `FKq71pkxwxrl8ajclujrw8wxkiw` FOREIGN KEY (`mon_hoc_id`) REFERENCES `mon_hoc` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monhoc_giangvien`
--

LOCK TABLES `monhoc_giangvien` WRITE;
/*!40000 ALTER TABLE `monhoc_giangvien` DISABLE KEYS */;
INSERT INTO `monhoc_giangvien` VALUES (2,'GV_00001'),(1,'GV_00001'),(1,'GV_00009'),(1,'GV_00005');
/*!40000 ALTER TABLE `monhoc_giangvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nganh`
--

DROP TABLE IF EXISTS `nganh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nganh` (
  `id` int NOT NULL AUTO_INCREMENT,
  `khoa_id` int DEFAULT NULL,
  `state` tinyint DEFAULT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf19evb4wgijodpa6il4obpy2y` (`khoa_id`),
  CONSTRAINT `FKf19evb4wgijodpa6il4obpy2y` FOREIGN KEY (`khoa_id`) REFERENCES `khoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nganh`
--

LOCK TABLES `nganh` WRITE;
/*!40000 ALTER TABLE `nganh` DISABLE KEYS */;
INSERT INTO `nganh` VALUES (1,1,1,'Kĩ Thuật Phần Mềm','KTPM'),(2,1,1,'Khoa Học Máy Tính','KHMT'),(3,1,1,'Công nghệ thông tin','CNTT'),(4,1,1,'Hệ thống thông tin','HTTT'),(8,1,1,'Kĩ Thuật Phần Mềm','KTPM');
/*!40000 ALTER TABLE `nganh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qlk_seq`
--

DROP TABLE IF EXISTS `qlk_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qlk_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qlk_seq`
--

LOCK TABLES `qlk_seq` WRITE;
/*!40000 ALTER TABLE `qlk_seq` DISABLE KEYS */;
INSERT INTO `qlk_seq` VALUES (1),(1);
/*!40000 ALTER TABLE `qlk_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qua_trinh_hoc_tap`
--

DROP TABLE IF EXISTS `qua_trinh_hoc_tap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qua_trinh_hoc_tap` (
  `id` int NOT NULL AUTO_INCREMENT,
  `lop_mon_hoc_id` int DEFAULT NULL,
  `so_tiet_nghi` int DEFAULT NULL,
  `sinh_vien_id` varchar(255) DEFAULT NULL,
  `ket_qua_hoc_tap_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_32wetpe0x28phjivv7nwhexmq` (`ket_qua_hoc_tap_id`),
  KEY `FKdrsx4wp1ivbd60k6nl8x2regk` (`lop_mon_hoc_id`),
  KEY `FKjfa4jnwi21gwobpr2wqoeel4e` (`sinh_vien_id`),
  CONSTRAINT `FKc166aymklimpoghs8pma92cjf` FOREIGN KEY (`ket_qua_hoc_tap_id`) REFERENCES `ket_qua_hoc_tap` (`id`),
  CONSTRAINT `FKdrsx4wp1ivbd60k6nl8x2regk` FOREIGN KEY (`lop_mon_hoc_id`) REFERENCES `lop_mon_hoc` (`id`),
  CONSTRAINT `FKjfa4jnwi21gwobpr2wqoeel4e` FOREIGN KEY (`sinh_vien_id`) REFERENCES `sinh_vien` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qua_trinh_hoc_tap`
--

LOCK TABLES `qua_trinh_hoc_tap` WRITE;
/*!40000 ALTER TABLE `qua_trinh_hoc_tap` DISABLE KEYS */;
INSERT INTO `qua_trinh_hoc_tap` VALUES (3,1,0,'SV_00002',2),(4,1,0,'SV_00003',3),(5,2,0,'SV_00001',4),(6,NULL,0,'SV_00002',5),(7,1,0,'SV_00004',9),(8,1,0,'SV_00005',10),(9,1,0,'SV_00010',11),(10,1,0,'SV_00001',12),(11,3,0,'SV_00001',13);
/*!40000 ALTER TABLE `qua_trinh_hoc_tap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quan_ly_khoa`
--

DROP TABLE IF EXISTS `quan_ly_khoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quan_ly_khoa` (
  `khoa_id` int DEFAULT NULL,
  `state` tinyint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_joyaj85fd5oknsxhmja3u5ffk` (`user_id`),
  KEY `FKpec8vco3wak7ykikgjtdvc9mt` (`khoa_id`),
  CONSTRAINT `FKjk3elexno540n248i90ybmhe2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKpec8vco3wak7ykikgjtdvc9mt` FOREIGN KEY (`khoa_id`) REFERENCES `khoa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quan_ly_khoa`
--

LOCK TABLES `quan_ly_khoa` WRITE;
/*!40000 ALTER TABLE `quan_ly_khoa` DISABLE KEYS */;
INSERT INTO `quan_ly_khoa` VALUES (1,1,3,'QLK_00001');
/*!40000 ALTER TABLE `quan_ly_khoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` tinyint NOT NULL AUTO_INCREMENT,
  `state` tinyint DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,1,'SV'),(2,1,'GV'),(3,1,'QLK'),(4,1,'ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_user`
--

DROP TABLE IF EXISTS `role_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_user` (
  `role_id` tinyint NOT NULL,
  `user_id` bigint NOT NULL,
  KEY `FKiqpmjd2qb4rdkej916ymonic6` (`role_id`),
  KEY `FK4320p8bgvumlxjkohtbj214qi` (`user_id`),
  CONSTRAINT `FK4320p8bgvumlxjkohtbj214qi` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKiqpmjd2qb4rdkej916ymonic6` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_user`
--

LOCK TABLES `role_user` WRITE;
/*!40000 ALTER TABLE `role_user` DISABLE KEYS */;
INSERT INTO `role_user` VALUES (1,1),(2,2),(3,3),(3,4),(4,4);
/*!40000 ALTER TABLE `role_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sinh_vien`
--

DROP TABLE IF EXISTS `sinh_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sinh_vien` (
  `lop_chinh_quy_id` int DEFAULT NULL,
  `state` tinyint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_q1cpx54t8e46er0e4vmpli0tb` (`user_id`),
  KEY `FKegmc7t6gacb8jfbo55psppqx3` (`lop_chinh_quy_id`),
  CONSTRAINT `FK4dlfshhipx7htiiwgqhu86nyi` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKegmc7t6gacb8jfbo55psppqx3` FOREIGN KEY (`lop_chinh_quy_id`) REFERENCES `lop_chinh_quy` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinh_vien`
--

LOCK TABLES `sinh_vien` WRITE;
/*!40000 ALTER TABLE `sinh_vien` DISABLE KEYS */;
INSERT INTO `sinh_vien` VALUES (NULL,NULL,1,'SV_00001'),(NULL,NULL,8,'SV_00002'),(NULL,NULL,9,'SV_00003'),(NULL,NULL,10,'SV_00004'),(NULL,NULL,27,'SV_00005'),(NULL,NULL,28,'SV_00006'),(NULL,NULL,29,'SV_00007'),(NULL,NULL,30,'SV_00008'),(NULL,NULL,31,'SV_00009'),(NULL,NULL,32,'SV_00010'),(NULL,NULL,33,'SV_00011'),(NULL,NULL,34,'SV_00012'),(NULL,NULL,35,'SV_00013'),(NULL,NULL,36,'SV_00014'),(NULL,NULL,37,'SV_00015'),(NULL,NULL,38,'SV_00016'),(NULL,NULL,39,'SV_00017'),(NULL,NULL,40,'SV_00018'),(NULL,NULL,41,'SV_00019'),(NULL,NULL,42,'SV_00020');
/*!40000 ALTER TABLE `sinh_vien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sv_seq`
--

DROP TABLE IF EXISTS `sv_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sv_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sv_seq`
--

LOCK TABLES `sv_seq` WRITE;
/*!40000 ALTER TABLE `sv_seq` DISABLE KEYS */;
INSERT INTO `sv_seq` VALUES (1),(1);
/*!40000 ALTER TABLE `sv_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thoi_khoa_bieu`
--

DROP TABLE IF EXISTS `thoi_khoa_bieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thoi_khoa_bieu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `lop_mon_hoc_id` int DEFAULT NULL,
  `so_tiet` int DEFAULT NULL,
  `tiet_bat_dau` int DEFAULT NULL,
  `thu` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi3rhw9e1tyfq9vn8io0bvo5nx` (`lop_mon_hoc_id`),
  CONSTRAINT `FKi3rhw9e1tyfq9vn8io0bvo5nx` FOREIGN KEY (`lop_mon_hoc_id`) REFERENCES `lop_mon_hoc` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thoi_khoa_bieu`
--

LOCK TABLES `thoi_khoa_bieu` WRITE;
/*!40000 ALTER TABLE `thoi_khoa_bieu` DISABLE KEYS */;
INSERT INTO `thoi_khoa_bieu` VALUES (1,1,3,1,4),(2,1,3,1,5),(32,NULL,NULL,NULL,NULL),(33,NULL,NULL,NULL,NULL),(37,2,3,4,2),(38,2,3,4,5),(39,3,2,3,3),(40,3,2,3,6);
/*!40000 ALTER TABLE `thoi_khoa_bieu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `gioi_tinh` tinyint DEFAULT NULL,
  `state` tinyint DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ngay_sinh` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `ho` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (NULL,1,1,NULL,NULL,'Duc','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Huy','SV_00001'),(NULL,1,2,NULL,NULL,'Thien','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Lam','GV_00001'),(NULL,1,3,NULL,NULL,'Minh','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Tien','QLK_00001'),(NULL,1,4,NULL,NULL,'Quang','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Minh','admin'),(NULL,1,5,NULL,NULL,'Thien','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Lam 2','GV_00002'),(NULL,1,6,NULL,NULL,'Thien','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Lam 3','GV_00003'),(NULL,1,7,NULL,NULL,'Thien','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Lam 4','GV_00004'),(NULL,1,8,NULL,NULL,'Duc','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Huy 1','SV_00002'),(NULL,1,9,NULL,NULL,'Duc','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Huy 2','SV_00003'),(NULL,1,10,NULL,NULL,'Duc','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Huy 3','SV_00004'),(NULL,1,11,NULL,NULL,'Bùi Đức','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Anh','GV_00005'),(NULL,1,12,NULL,NULL,'Trần Anh','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Đức','GV_00006'),(NULL,1,13,NULL,NULL,'Quán Xuân','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Đương','GV_00007'),(NULL,1,14,NULL,NULL,'Hà Văn','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Hậu','GV_00008'),(NULL,1,15,NULL,NULL,'Đinh Đức','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Hiếu','GV_00009'),(NULL,1,16,NULL,NULL,'Nông Minh','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Hiếu','GV_00010'),(NULL,1,17,NULL,NULL,'Đoàn Gia','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Hòa','GV_00011'),(NULL,1,18,NULL,NULL,'Nguyễn Thu','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Hoài','GV_00012'),(NULL,1,19,NULL,NULL,'Đặng Thế','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Hoàn','GV_00013'),(NULL,1,20,NULL,NULL,'Đào Trọng','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Hoàn','GV_00014'),(NULL,1,21,NULL,NULL,'Đỗ Huy','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Hoàng','GV_00015'),(NULL,1,22,NULL,NULL,'Trịnh Minh','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Hoàng','GV_00016'),(NULL,1,23,NULL,NULL,'Trương Việt','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Hoàng','GV_00017'),(NULL,1,24,NULL,NULL,'Nguyễn Trọng','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Hùng','GV_00018'),(NULL,1,25,NULL,NULL,'Nguyễn Phúc','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Hưng','GV_00019'),(NULL,1,26,NULL,NULL,'Nguyễn Quang','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Hưng','GV_00020'),(NULL,1,27,NULL,NULL,'Phạm Việt','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Hưng','SV_00005'),(NULL,1,28,NULL,NULL,'Nguyễn An','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Huy','SV_00006'),(NULL,1,29,NULL,NULL,'Phùng Nguyễn','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Huy','SV_00007'),(NULL,1,30,NULL,NULL,'Trần Đức','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Huy','SV_00008'),(NULL,1,31,NULL,NULL,'Phạm Văn','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Khải','SV_00009'),(NULL,1,32,NULL,NULL,'Nguyễn Văn','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Khanh','SV_00010'),(NULL,1,33,NULL,NULL,'Tạ Trung','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Kiên','SV_00011'),(NULL,1,34,NULL,NULL,'Bùi Hoàng','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Lâm','SV_00012'),(NULL,1,35,NULL,NULL,'Nguyễn Thiện','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Lâm','SV_00013'),(NULL,1,36,NULL,NULL,'Thái Ngọc','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Linh','SV_00014'),(NULL,1,37,NULL,NULL,'Lưu Hải','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Long','SV_00015'),(NULL,1,38,NULL,NULL,'Nguyễn Bảo','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Long','SV_00016'),(NULL,1,39,NULL,NULL,'Nguyễn Văn','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Luận','SV_00017'),(NULL,1,40,NULL,NULL,'Ngô Đức','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Lưu','SV_00018'),(NULL,1,41,NULL,NULL,'Đặng Văn','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Mạnh','SV_00019'),(NULL,1,42,NULL,NULL,'Nguyễn Hoàng','$2a$10$PKUexTjMK70kYixB/sGpcOTPwkEWcAibVq3EQ901e9pw/A.f8Je9G','Nam','SV_00020');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ttcn_nhom2'
--

--
-- Dumping routines for database 'ttcn_nhom2'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-31 23:19:37
