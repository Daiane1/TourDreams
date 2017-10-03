-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 10.107.134.11    Database: db_tourdreams
-- ------------------------------------------------------
-- Server version	5.7.10-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `fotos_produtos`
--

DROP TABLE IF EXISTS `fotos_produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fotos_produtos` (
  `id_fotos` int(11) NOT NULL,
  `id_produtos` int(11) NOT NULL,
  KEY `id_fotos_produtos_idx` (`id_fotos`),
  KEY `id_produtos_fotos_idx` (`id_produtos`),
  CONSTRAINT `id_fotos_produtos` FOREIGN KEY (`id_fotos`) REFERENCES `tbl_fotos` (`id_fotos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_produtos_fotos` FOREIGN KEY (`id_produtos`) REFERENCES `tbl_produto` (`id_produto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fotos_produtos`
--

LOCK TABLES `fotos_produtos` WRITE;
/*!40000 ALTER TABLE `fotos_produtos` DISABLE KEYS */;
/*!40000 ALTER TABLE `fotos_produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_administradores`
--

DROP TABLE IF EXISTS `tbl_administradores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_administradores` (
  `id_administrador` int(11) NOT NULL AUTO_INCREMENT,
  `id_nivel_usuario` int(11) NOT NULL,
  `nome_administrador` varchar(100) NOT NULL,
  `email_empresa` varchar(150) NOT NULL,
  `cidade_nascimento` varchar(100) NOT NULL,
  `estado_nascimento` varchar(80) NOT NULL,
  `dt_nasc` date NOT NULL,
  `foto` varchar(200) NOT NULL DEFAULT '',
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`id_administrador`),
  KEY `id_adms_nivelUsuario_idx` (`id_nivel_usuario`),
  CONSTRAINT `id_adms_nivelUsuario` FOREIGN KEY (`id_nivel_usuario`) REFERENCES `tbl_nivel_usuario` (`id_nivel_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_administradores`
--

LOCK TABLES `tbl_administradores` WRITE;
/*!40000 ALTER TABLE `tbl_administradores` DISABLE KEYS */;
INSERT INTO `tbl_administradores` VALUES (14,1,'João Alves Sampaio','joao123@tourdreams.com.br','Itapevi','São Paulo','1985-07-14','a0ad444a60738f403eb9ef4fc6f8051a.jpg','123456');
/*!40000 ALTER TABLE `tbl_administradores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_avaliacoes`
--

DROP TABLE IF EXISTS `tbl_avaliacoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_avaliacoes` (
  `id_avaliacoes` int(11) NOT NULL AUTO_INCREMENT,
  `id_milhas` int(11) NOT NULL,
  `id_reserva` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `media_avaliacoes` float NOT NULL,
  `nota_limpeza` float NOT NULL,
  `nota_restaurante` float NOT NULL,
  `nota_atendimento` float NOT NULL,
  `nota_lazer` float NOT NULL,
  PRIMARY KEY (`id_avaliacoes`),
  KEY `id_avaliacoes_milhas_idx` (`id_milhas`),
  KEY `id_avaliacoes_reserva_idx` (`id_reserva`),
  KEY `id_avaliacoes_cliente_idx` (`id_cliente`),
  CONSTRAINT `id_avaliacoes_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `tbl_cliente` (`id_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_avaliacoes_milhas` FOREIGN KEY (`id_milhas`) REFERENCES `tbl_milhas` (`id_milhas`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_avaliacoes_reserva` FOREIGN KEY (`id_reserva`) REFERENCES `tbl_reserva` (`id_reserva`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_avaliacoes`
--

LOCK TABLES `tbl_avaliacoes` WRITE;
/*!40000 ALTER TABLE `tbl_avaliacoes` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_avaliacoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_blog`
--

DROP TABLE IF EXISTS `tbl_blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_blog` (
  `id_conheca_destino` int(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` int(11) NOT NULL,
  `id_reserva` int(11) NOT NULL,
  `foto_blog` varchar(200) NOT NULL,
  `descricao_blog` text NOT NULL,
  `data_publicacao` date NOT NULL,
  PRIMARY KEY (`id_conheca_destino`),
  KEY `id_conhecaDestino_cliente_idx` (`id_cliente`),
  KEY `id_conhecaDestino_reserva_idx` (`id_reserva`),
  CONSTRAINT `id_blog_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `tbl_cliente` (`id_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_reserva_blog` FOREIGN KEY (`id_reserva`) REFERENCES `tbl_reserva` (`id_reserva`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_blog`
--

LOCK TABLES `tbl_blog` WRITE;
/*!40000 ALTER TABLE `tbl_blog` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_brindes`
--

DROP TABLE IF EXISTS `tbl_brindes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_brindes` (
  `id_brinde` int(11) NOT NULL AUTO_INCREMENT,
  `nome_brinde` varchar(45) NOT NULL,
  PRIMARY KEY (`id_brinde`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_brindes`
--

LOCK TABLES `tbl_brindes` WRITE;
/*!40000 ALTER TABLE `tbl_brindes` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_brindes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_caracteristicas`
--

DROP TABLE IF EXISTS `tbl_caracteristicas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_caracteristicas` (
  `id_caracteristicas` int(11) NOT NULL AUTO_INCREMENT,
  `nome_caracteristica` varchar(45) NOT NULL,
  `foto_caracteristica` varchar(200) NOT NULL,
  PRIMARY KEY (`id_caracteristicas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_caracteristicas`
--

LOCK TABLES `tbl_caracteristicas` WRITE;
/*!40000 ALTER TABLE `tbl_caracteristicas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_caracteristicas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_caracteristicas_produto`
--

DROP TABLE IF EXISTS `tbl_caracteristicas_produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_caracteristicas_produto` (
  `id_produto` int(11) NOT NULL,
  `id_caracteristicas` int(11) NOT NULL,
  `qtde_caracteristica` int(11) DEFAULT NULL,
  KEY `id_caracteristicas_produto_idx` (`id_caracteristicas`),
  KEY `id_produto_caracteristicas_idx` (`id_produto`),
  CONSTRAINT `id_caracteristicas_produto` FOREIGN KEY (`id_caracteristicas`) REFERENCES `tbl_caracteristicas` (`id_caracteristicas`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_produto_caracteristicas` FOREIGN KEY (`id_produto`) REFERENCES `tbl_produto` (`id_produto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_caracteristicas_produto`
--

LOCK TABLES `tbl_caracteristicas_produto` WRITE;
/*!40000 ALTER TABLE `tbl_caracteristicas_produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_caracteristicas_produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_cep`
--

DROP TABLE IF EXISTS `tbl_cep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_cep` (
  `id_cep` int(11) NOT NULL AUTO_INCREMENT,
  `numero_cep` varchar(45) NOT NULL,
  `logradouro` varchar(150) NOT NULL,
  `numero` int(11) NOT NULL,
  `complemento` varchar(30) DEFAULT NULL,
  `bairro` varchar(100) NOT NULL,
  `cidade` varchar(100) NOT NULL,
  `uf` varchar(4) NOT NULL,
  PRIMARY KEY (`id_cep`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_cep`
--

LOCK TABLES `tbl_cep` WRITE;
/*!40000 ALTER TABLE `tbl_cep` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_cep` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_cliente`
--

DROP TABLE IF EXISTS `tbl_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `milhas` int(11) DEFAULT NULL,
  `nome_cliente` varchar(100) NOT NULL,
  `rg_cliente` varchar(45) NOT NULL,
  `cpf_cliente` varchar(45) NOT NULL,
  `email_cliente` varchar(120) NOT NULL,
  `senha_cliente` varchar(45) NOT NULL,
  `celular_cliente` varchar(20) NOT NULL,
  `foto_cliente` varchar(200) DEFAULT NULL,
  `dt_nasc` date NOT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `cpf_cliente_UNIQUE` (`cpf_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_cliente`
--

LOCK TABLES `tbl_cliente` WRITE;
/*!40000 ALTER TABLE `tbl_cliente` DISABLE KEYS */;
INSERT INTO `tbl_cliente` VALUES (1,500,'Jailson Mendes','39.779.185-9','465.953.468-50','jailson@tourdreams.com','123456','(11) 97137-8841',NULL,'2000-08-08'),(2,NULL,'Taina','64555845','787.987.484-84','taina@gmail.com','123','(11) 79748-9478',NULL,'0000-00-00'),(3,NULL,'nicolas','15815','151.555.551-51','dai123@tourdreams.com.br','123','(54) 18518-5185',NULL,'2000-08-09'),(6,NULL,'Tainá','4854848','848.484.848-48','taina123@tourdreams.com.br','1234','(78) 74878-7877',NULL,'5858-09-08'),(12,NULL,'Jao','8548884','848.484.884-84','joa@gmail.com','123','(84) 98484-8484',NULL,'1993-02-11');
/*!40000 ALTER TABLE `tbl_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_comentario`
--

DROP TABLE IF EXISTS `tbl_comentario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_comentario` (
  `id_comentario` int(11) NOT NULL AUTO_INCREMENT,
  `id_milhas` int(11) NOT NULL,
  `id_reserva` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `comentario` text NOT NULL,
  PRIMARY KEY (`id_comentario`),
  KEY `id_comentario_milhas_idx` (`id_milhas`),
  KEY `id_comentario_reserva_idx` (`id_reserva`),
  KEY `id_comentario_cliente_idx` (`id_cliente`),
  CONSTRAINT `id_comentario_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `tbl_cliente` (`id_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_comentario_milhas` FOREIGN KEY (`id_milhas`) REFERENCES `tbl_milhas` (`id_milhas`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_comentario_reserva` FOREIGN KEY (`id_reserva`) REFERENCES `tbl_reserva` (`id_reserva`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_comentario`
--

LOCK TABLES `tbl_comentario` WRITE;
/*!40000 ALTER TABLE `tbl_comentario` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_comentario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_estilo_produto`
--

DROP TABLE IF EXISTS `tbl_estilo_produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_estilo_produto` (
  `id_estilo_produto` int(11) NOT NULL AUTO_INCREMENT,
  `nome_estilo_produto` varchar(45) NOT NULL,
  PRIMARY KEY (`id_estilo_produto`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_estilo_produto`
--

LOCK TABLES `tbl_estilo_produto` WRITE;
/*!40000 ALTER TABLE `tbl_estilo_produto` DISABLE KEYS */;
INSERT INTO `tbl_estilo_produto` VALUES (1,'Hotel'),(2,'Pousada'),(3,'Resort');
/*!40000 ALTER TABLE `tbl_estilo_produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_fale_conosco`
--

DROP TABLE IF EXISTS `tbl_fale_conosco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_fale_conosco` (
  `id_fale_conosco` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `email` varchar(130) NOT NULL,
  `celular` varchar(20) NOT NULL,
  `observacao` text NOT NULL,
  PRIMARY KEY (`id_fale_conosco`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_fale_conosco`
--

LOCK TABLES `tbl_fale_conosco` WRITE;
/*!40000 ALTER TABLE `tbl_fale_conosco` DISABLE KEYS */;
INSERT INTO `tbl_fale_conosco` VALUES (16,'Carlos Morais Silva','carlos.silva2017@hotmail.com','(11) 97852-3365','Muito Bom, melhor portal de viagens do Brasil!');
/*!40000 ALTER TABLE `tbl_fale_conosco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_fotos`
--

DROP TABLE IF EXISTS `tbl_fotos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_fotos` (
  `id_fotos` int(11) NOT NULL AUTO_INCREMENT,
  `foto_produto` varchar(200) NOT NULL,
  PRIMARY KEY (`id_fotos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_fotos`
--

LOCK TABLES `tbl_fotos` WRITE;
/*!40000 ALTER TABLE `tbl_fotos` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_fotos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_funcionarios`
--

DROP TABLE IF EXISTS `tbl_funcionarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_funcionarios` (
  `id_funcionarios` int(11) NOT NULL AUTO_INCREMENT,
  `id_nivel_usuario` int(11) NOT NULL,
  `nome_funcionario` varchar(100) NOT NULL,
  `email_empresa` varchar(150) NOT NULL,
  `cidade_nascimento` varchar(100) NOT NULL,
  `estado_nascimento` varchar(80) NOT NULL,
  `dt_nasc` int(11) NOT NULL,
  `foto` varchar(200) NOT NULL,
  PRIMARY KEY (`id_funcionarios`),
  KEY `id_funcionario_nivelUsuario_idx` (`id_nivel_usuario`),
  CONSTRAINT `id_funcionario_nivelUsuario` FOREIGN KEY (`id_nivel_usuario`) REFERENCES `tbl_nivel_usuario` (`id_nivel_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_funcionarios`
--

LOCK TABLES `tbl_funcionarios` WRITE;
/*!40000 ALTER TABLE `tbl_funcionarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_funcionarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_milhas`
--

DROP TABLE IF EXISTS `tbl_milhas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_milhas` (
  `id_milhas` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_milhas` varchar(70) NOT NULL,
  `qtd_milhas` int(11) NOT NULL,
  PRIMARY KEY (`id_milhas`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_milhas`
--

LOCK TABLES `tbl_milhas` WRITE;
/*!40000 ALTER TABLE `tbl_milhas` DISABLE KEYS */;
INSERT INTO `tbl_milhas` VALUES (1,'Reserva',700),(2,'Comentário',485),(3,'Avaliação',567);
/*!40000 ALTER TABLE `tbl_milhas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_nivel_usuario`
--

DROP TABLE IF EXISTS `tbl_nivel_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_nivel_usuario` (
  `id_nivel_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome_nivel` varchar(45) NOT NULL,
  PRIMARY KEY (`id_nivel_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_nivel_usuario`
--

LOCK TABLES `tbl_nivel_usuario` WRITE;
/*!40000 ALTER TABLE `tbl_nivel_usuario` DISABLE KEYS */;
INSERT INTO `tbl_nivel_usuario` VALUES (1,'Administrador'),(2,'Marketing');
/*!40000 ALTER TABLE `tbl_nivel_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_parceiros`
--

DROP TABLE IF EXISTS `tbl_parceiros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_parceiros` (
  `id_parceiro` int(11) NOT NULL AUTO_INCREMENT,
  `nome_empresa` varchar(100) NOT NULL,
  `nome_fantasia` varchar(100) NOT NULL,
  `cnpj` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `nome_gerente` varchar(150) NOT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `celular` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `milhas_parceiro` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_parceiro`),
  UNIQUE KEY `cnpj_UNIQUE` (`cnpj`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_parceiros`
--

LOCK TABLES `tbl_parceiros` WRITE;
/*!40000 ALTER TABLE `tbl_parceiros` DISABLE KEYS */;
INSERT INTO `tbl_parceiros` VALUES (1,'ewfefg','rwgrg','58418541','788745','grgrhgr','(54) 18518-5185','961691696','dai123@tourdreams.com.br',NULL);
/*!40000 ALTER TABLE `tbl_parceiros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_planejamento`
--

DROP TABLE IF EXISTS `tbl_planejamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_planejamento` (
  `id_planejamento` int(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` int(11) NOT NULL,
  `id_reserva` int(11) NOT NULL,
  `nome_planejamento` varchar(100) NOT NULL,
  `ponto_turistico` text NOT NULL,
  `dia_planejamento` datetime NOT NULL,
  PRIMARY KEY (`id_planejamento`),
  KEY `id_planejamento_cliente_idx` (`id_cliente`),
  KEY `id_planejamento_reserva_idx` (`id_reserva`),
  CONSTRAINT `id_planejamento_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `tbl_cliente` (`id_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_planejamento_reserva` FOREIGN KEY (`id_reserva`) REFERENCES `tbl_reserva` (`id_reserva`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_planejamento`
--

LOCK TABLES `tbl_planejamento` WRITE;
/*!40000 ALTER TABLE `tbl_planejamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_planejamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_produto`
--

DROP TABLE IF EXISTS `tbl_produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_produto` (
  `id_produto` int(11) NOT NULL AUTO_INCREMENT,
  `id_status` int(11) NOT NULL,
  `id_tipo_viagem` int(11) NOT NULL,
  `id_estilo_produto` int(11) NOT NULL,
  `id_milhas` int(11) DEFAULT NULL,
  `id_parceiro` int(11) NOT NULL,
  `id_cep` int(11) NOT NULL,
  PRIMARY KEY (`id_produto`),
  KEY `id_produto_status_idx` (`id_status`),
  KEY `id_produto_tipoViagem_idx` (`id_tipo_viagem`),
  KEY `id_produto_estiloViagem_idx` (`id_estilo_produto`),
  KEY `id_produto_milhas_idx` (`id_milhas`),
  KEY `id_produto_parceiro_idx` (`id_parceiro`),
  KEY `id_produto_local_idx` (`id_cep`),
  CONSTRAINT `id_produto_cep` FOREIGN KEY (`id_cep`) REFERENCES `tbl_cep` (`id_cep`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_produto_estiloProduto` FOREIGN KEY (`id_estilo_produto`) REFERENCES `tbl_estilo_produto` (`id_estilo_produto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_produto_milhas` FOREIGN KEY (`id_milhas`) REFERENCES `tbl_milhas` (`id_milhas`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_produto_parceiro` FOREIGN KEY (`id_parceiro`) REFERENCES `tbl_parceiros` (`id_parceiro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_produto_status` FOREIGN KEY (`id_status`) REFERENCES `tbl_status` (`id_status`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_produto_tipoViagem` FOREIGN KEY (`id_tipo_viagem`) REFERENCES `tbl_tipo_viagem` (`id_tipo_viagem`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_produto`
--

LOCK TABLES `tbl_produto` WRITE;
/*!40000 ALTER TABLE `tbl_produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_promocoes`
--

DROP TABLE IF EXISTS `tbl_promocoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_promocoes` (
  `id_promocoes` int(11) NOT NULL AUTO_INCREMENT,
  `id_produto` int(11) NOT NULL,
  `id_brinde` int(11) NOT NULL,
  `milhas_necessarias` int(11) NOT NULL,
  PRIMARY KEY (`id_promocoes`),
  KEY `id_promocao_produto_idx` (`id_produto`),
  KEY `id_promocao_brinde_idx` (`id_brinde`),
  CONSTRAINT `id_promocao_brinde` FOREIGN KEY (`id_brinde`) REFERENCES `tbl_brindes` (`id_brinde`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_promocao_produto` FOREIGN KEY (`id_produto`) REFERENCES `tbl_produto` (`id_produto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_promocoes`
--

LOCK TABLES `tbl_promocoes` WRITE;
/*!40000 ALTER TABLE `tbl_promocoes` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_promocoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_qtdadultos`
--

DROP TABLE IF EXISTS `tbl_qtdadultos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_qtdadultos` (
  `id_adulto` int(11) NOT NULL AUTO_INCREMENT,
  `qtd_adulto` int(11) NOT NULL,
  PRIMARY KEY (`id_adulto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_qtdadultos`
--

LOCK TABLES `tbl_qtdadultos` WRITE;
/*!40000 ALTER TABLE `tbl_qtdadultos` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_qtdadultos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_qtdcriancas`
--

DROP TABLE IF EXISTS `tbl_qtdcriancas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_qtdcriancas` (
  `id_crianca` int(11) NOT NULL AUTO_INCREMENT,
  `qtd_criancas` int(11) NOT NULL,
  PRIMARY KEY (`id_crianca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_qtdcriancas`
--

LOCK TABLES `tbl_qtdcriancas` WRITE;
/*!40000 ALTER TABLE `tbl_qtdcriancas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_qtdcriancas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_qtdquartos`
--

DROP TABLE IF EXISTS `tbl_qtdquartos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_qtdquartos` (
  `id_quarto` int(11) NOT NULL AUTO_INCREMENT,
  `qtd_quarto` int(11) NOT NULL,
  PRIMARY KEY (`id_quarto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_qtdquartos`
--

LOCK TABLES `tbl_qtdquartos` WRITE;
/*!40000 ALTER TABLE `tbl_qtdquartos` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_qtdquartos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_reserva`
--

DROP TABLE IF EXISTS `tbl_reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_reserva` (
  `id_reserva` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `dt_entrada` date NOT NULL,
  `dt_saida` date NOT NULL,
  `nome_responsavel` varchar(100) NOT NULL,
  `id_quarto` int(11) NOT NULL,
  `id_adulto` int(11) NOT NULL,
  `id_crianca` int(11) NOT NULL,
  PRIMARY KEY (`id_reserva`),
  KEY `id_reserva_produto_idx` (`id_produto`),
  KEY `id_cliente_reserva_idx` (`id_cliente`),
  KEY `id_qtd_quarto_idx` (`id_quarto`),
  KEY `id_qtd_reserva_adulto_idx` (`id_adulto`),
  KEY `id_qtd_reserva_crianca_idx` (`id_crianca`),
  CONSTRAINT `id_cliente_reserva` FOREIGN KEY (`id_cliente`) REFERENCES `tbl_cliente` (`id_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_qtd_reserva_adulto` FOREIGN KEY (`id_adulto`) REFERENCES `tbl_qtdadultos` (`id_adulto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_qtd_reserva_crianca` FOREIGN KEY (`id_crianca`) REFERENCES `tbl_qtdcriancas` (`id_crianca`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_qtd_reserva_quarto` FOREIGN KEY (`id_quarto`) REFERENCES `tbl_qtdquartos` (`id_quarto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_reserva_produto` FOREIGN KEY (`id_produto`) REFERENCES `tbl_produto` (`id_produto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_reserva`
--

LOCK TABLES `tbl_reserva` WRITE;
/*!40000 ALTER TABLE `tbl_reserva` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_sobre`
--

DROP TABLE IF EXISTS `tbl_sobre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_sobre` (
  `id_sobre` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` text NOT NULL,
  `foto_descricao` varchar(200) NOT NULL,
  PRIMARY KEY (`id_sobre`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_sobre`
--

LOCK TABLES `tbl_sobre` WRITE;
/*!40000 ALTER TABLE `tbl_sobre` DISABLE KEYS */;
INSERT INTO `tbl_sobre` VALUES (14,'TourDreams #viagem','2f936b5635f24617126c016b4e27a7c9.png');
/*!40000 ALTER TABLE `tbl_sobre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_status`
--

DROP TABLE IF EXISTS `tbl_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_status` (
  `id_status` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`id_status`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_status`
--

LOCK TABLES `tbl_status` WRITE;
/*!40000 ALTER TABLE `tbl_status` DISABLE KEYS */;
INSERT INTO `tbl_status` VALUES (1,'Pendente'),(2,'Aprovado'),(3,'Recusado');
/*!40000 ALTER TABLE `tbl_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_tipo_viagem`
--

DROP TABLE IF EXISTS `tbl_tipo_viagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_tipo_viagem` (
  `id_tipo_viagem` int(11) NOT NULL AUTO_INCREMENT,
  `nome_tipo_viagem` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tipo_viagem`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_tipo_viagem`
--

LOCK TABLES `tbl_tipo_viagem` WRITE;
/*!40000 ALTER TABLE `tbl_tipo_viagem` DISABLE KEYS */;
INSERT INTO `tbl_tipo_viagem` VALUES (1,'Família'),(2,'Trabalho'),(3,'Casal'),(4,'Todos');
/*!40000 ALTER TABLE `tbl_tipo_viagem` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-03 16:57:55
