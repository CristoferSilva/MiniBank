-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.6.5-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para bankdatabase
CREATE DATABASE IF NOT EXISTS `bankdatabase` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `bankdatabase`;

-- Copiando estrutura para tabela bankdatabase.addresses
CREATE TABLE IF NOT EXISTS `addresses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(1000) NOT NULL,
  `owner` varchar(50) DEFAULT 'client',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela bankdatabase.addresses: ~15 rows (aproximadamente)
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT IGNORE INTO `addresses` (`id`, `address`, `owner`) VALUES
	(1, '"cep": "54100-313","endereco": "3ª Travessa Riacho Vila Rica","numero": 266,"bairro": "Centro","cidade": "Jaboatão dos Guararapes","estado": "PE"', 'client'),
	(2, '"cep": "88303-590","endereco": "Rua Ernesto Polydoro Ferreira","numero": 477,"bairro": "Dom Bosco","cidade": "Itajaí","estado": "SC"', 'client'),
	(3, '"cep": "69093-415","endereco": "Avenida Torquato Tapajós","numero": 218,"bairro": "Colônia Terra Nova","cidade": "Manaus","estado": "AM"', 'client'),
	(4, '"cep": "29108-130","endereco": "Rua São Mateus","numero": 591,"bairro": "Santa Inês","cidade": "Vila Velha","estado": "ES"', 'client'),
	(5, '"cep": "65606-525","endereco": "Rodovia BR-316","numero": 340,"bairro": "Volta Redonda","cidade": "Caxias","estado": "MA"', 'client'),
	(6, '"cep": "88819-472","endereco": "Rua Antônio Possa","numero": 444,"bairro": "Mina do Toco","cidade": "Criciúma","estado": "SC"', 'client'),
	(7, '"cep": "76801-081","endereco": "Avenida Campos Sales","numero": 404,"bairro": "Centro","cidade": "Porto Velho","estado": "RO"', 'client'),
	(8, '"cep": "81820-470","endereco": "Rua Helena Carvalho da Silva Corrêa","numero": 861,"bairro": "Pinheirinho","cidade": "Curitiba","estado": "PR"', 'client'),
	(9, '"cep": "36080-490","endereco": "Rua Maria Luiza Tostes","numero": 107,"bairro": "Esplanada","cidade": "Juiz de Fora","estado": "MG"', 'client'),
	(10, '"endereco": "Avenida Iguaçu da Glória","numero": 422,"bairro": "Vitória","cidade": "Rio Branco","estado": "AC"', 'client'),
	(11, '"cep": "74355-478","endereco": "Rua 30","numero": 410,"bairro": "Condomínio das Esmeraldas","cidade": "Goiânia","estado": "GO"', 'agency'),
	(12, '"cep": "14165-434","endereco": "Rua Pedro Montenegro","numero": 622,"bairro": "Jardim Santa Marta","cidade": "Sertãozinho","estado": "SP"', 'agency'),
	(13, '"cep": "52221-035","endereco": "Avenida Beberibe","numero": 568,"bairro": "Cajueiro","cidade": "Recife","estado": "PE"', 'agency'),
	(14, '"cep": "64031-092","endereco": "Rua I","numero": 167,"bairro": "Bela Vista","cidade": "Teresina","estado": "PI"', 'agency'),
	(15, '"cep": "49003-307","endereco": "Acesso Quinze","numero": 516,"bairro": "17 de Março","cidade": "Aracaju","estado": "SE"', 'agency');
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;

-- Copiando estrutura para tabela bankdatabase.agencies
CREATE TABLE IF NOT EXISTS `agencies` (
  `id` int(11) NOT NULL,
  `address_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_address_id` (`address_id`),
  CONSTRAINT `fk_address_id` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela bankdatabase.agencies: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `agencies` DISABLE KEYS */;
INSERT IGNORE INTO `agencies` (`id`, `address_id`) VALUES
	(409, 11),
	(410, 12),
	(411, 13),
	(412, 14),
	(413, 15);
/*!40000 ALTER TABLE `agencies` ENABLE KEYS */;

-- Copiando estrutura para tabela bankdatabase.bankaccounts
CREATE TABLE IF NOT EXISTS `bankaccounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` int(11) NOT NULL,
  `agency_id` int(11) NOT NULL,
  `accountNumber` varchar(50) NOT NULL DEFAULT '0',
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `accountNumber` (`accountNumber`),
  KEY `FK_bankaccounts_agencies` (`agency_id`),
  CONSTRAINT `FK_bankaccounts_agencies` FOREIGN KEY (`agency_id`) REFERENCES `agencies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela bankdatabase.bankaccounts: ~20 rows (aproximadamente)
/*!40000 ALTER TABLE `bankaccounts` DISABLE KEYS */;
INSERT IGNORE INTO `bankaccounts` (`id`, `value`, `agency_id`, `accountNumber`, `type`) VALUES
	(1, 495, 409, '34058', 'checking'),
	(2, 1000, 409, '34059', 'savings'),
	(3, 3005, 410, '35058', 'checking'),
	(4, 500, 410, '35059', 'savings'),
	(5, 980, 411, '36058', 'checking'),
	(6, 180, 411, '36059', 'saving'),
	(7, 975, 412, '37058', 'checking'),
	(8, 68, 412, '37059', 'savings'),
	(9, 1754, 413, '38058', 'checking'),
	(10, 754, 413, '38059', 'savings'),
	(11, 1654, 409, '39058', 'checking'),
	(12, 678, 409, '39059', 'saving'),
	(13, 1289, 410, '40058', 'checking'),
	(14, 1547, 410, '40059', 'savings'),
	(15, 7845, 411, '41058', 'checking'),
	(16, 874, 411, '41059', 'saving'),
	(17, 4587, 412, '42058', 'checking'),
	(18, 587, 412, '42059', 'saving'),
	(19, 7456, 413, '43058', 'checking'),
	(20, 879, 413, '43059', 'saving');
/*!40000 ALTER TABLE `bankaccounts` ENABLE KEYS */;

-- Copiando estrutura para tabela bankdatabase.bankbills
CREATE TABLE IF NOT EXISTS `bankbills` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `barCode` varchar(50) NOT NULL,
  `value` int(11) NOT NULL,
  `dueDate` date NOT NULL,
  `creationDate` date NOT NULL,
  `bankBill_card_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `barCode` (`barCode`),
  KEY `fk_bankBill_card_id` (`bankBill_card_id`),
  CONSTRAINT `fk_bankBill_card_id` FOREIGN KEY (`bankBill_card_id`) REFERENCES `customercards` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela bankdatabase.bankbills: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `bankbills` DISABLE KEYS */;
INSERT IGNORE INTO `bankbills` (`id`, `barCode`, `value`, `dueDate`, `creationDate`, `bankBill_card_id`) VALUES
	(1, '123456789012', 20, '2023-12-03', '2021-12-27', 1),
	(2, '555444332221', 100, '2023-02-05', '2021-12-02', 3);
/*!40000 ALTER TABLE `bankbills` ENABLE KEYS */;

-- Copiando estrutura para tabela bankdatabase.clients
CREATE TABLE IF NOT EXISTS `clients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullName` varchar(50) NOT NULL,
  `cpf` varchar(50) NOT NULL,
  `phoneNumber1` varchar(50) NOT NULL,
  `phoneNumber2` varchar(50) DEFAULT NULL,
  `country` varchar(50) NOT NULL DEFAULT 'Brasil',
  `salary` int(11) NOT NULL,
  `card_id` int(11) NOT NULL,
  `client_address_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf` (`cpf`),
  UNIQUE KEY `phoneNumber1` (`phoneNumber1`),
  UNIQUE KEY `phoneNumber2` (`phoneNumber2`),
  KEY `fk_card_id` (`card_id`),
  KEY `fk_client_address_id` (`client_address_id`),
  CONSTRAINT `fk_card_id` FOREIGN KEY (`card_id`) REFERENCES `customercards` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_client_address_id` FOREIGN KEY (`client_address_id`) REFERENCES `addresses` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela bankdatabase.clients: ~10 rows (aproximadamente)
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT IGNORE INTO `clients` (`id`, `fullName`, `cpf`, `phoneNumber1`, `phoneNumber2`, `country`, `salary`, `card_id`, `client_address_id`) VALUES
	(1, 'Natália Simone Aurora Duarte', '676.456.003-06', '(81) 98517-0716', '(81) 3602-2976', 'Brasil', 3000, 1, 1),
	(2, 'Bruna Francisca Bernardes', '413.594.300-40', '(86) 2833-0260', '(86) 98608-5264', 'Brasil', 4000, 2, 2),
	(3, 'Joaquim Daniel Fernandes', '523.475.026-46', '(79) 2810-7643', '(79) 98251-1738', 'Brasil', 5000, 3, 3),
	(4, 'Elza Adriana Peixoto', '763.128.441-53', '(81) 2724-4249', '(81) 98590-5396', 'Brasil', 1500, 4, 4),
	(5, 'Carlos Osvaldo da Silva', '849.855.251-62', '(47) 3713-5001', '(47) 99914-0625', 'Brasil', 7550, 5, 5),
	(6, 'Bento Ryan Mendes', '190.230.965-09', '(92) 2558-0167', '(92) 98946-2566', 'Brasil', 1225, 6, 6),
	(7, 'Benedito Vicente Gael da Cruz', '244.707.274-07', '(27) 3656-5014', '(27) 98747-7320', 'Brasil', 5596, 7, 7),
	(8, 'Allana Stella Farias', '920.308.729-03', '(99) 2953-6362', '(99) 98657-5977', 'Brasil', 1547, 8, 8),
	(9, 'Daniel Enrico Galvão', '995.470.447-70', '(48) 3592-4689', '(48) 99687-9046', 'Brasil', 5876, 9, 9),
	(10, 'Geraldo Cauê Juan Moraes', '491.370.316-19', '(69) 98384-8501', '(69) 98384-8501', 'Brasil', 6587, 10, 10);
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;

-- Copiando estrutura para tabela bankdatabase.customercards
CREATE TABLE IF NOT EXISTS `customercards` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cardNumber` varchar(1000) NOT NULL DEFAULT '',
  `password` varchar(50) NOT NULL,
  `creditLimit` int(11) NOT NULL,
  `creditGiven` int(11) NOT NULL,
  `dueDate` date NOT NULL,
  `checkingAccount_id` int(11) NOT NULL,
  `savingAccount_id` int(11) NOT NULL,
  `PIXkey` varchar(50) NOT NULL,
  `owner_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `PIXkey` (`PIXkey`),
  UNIQUE KEY `cardNumber` (`cardNumber`) USING HASH,
  KEY `fk_checkingAccount_id` (`checkingAccount_id`),
  KEY `fk_savingAccount_id` (`savingAccount_id`),
  KEY `fk_owner_id` (`owner_id`),
  CONSTRAINT `fk_checkingAccount_id` FOREIGN KEY (`checkingAccount_id`) REFERENCES `bankaccounts` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_owner_id` FOREIGN KEY (`owner_id`) REFERENCES `clients` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_savingAccount_id` FOREIGN KEY (`savingAccount_id`) REFERENCES `bankaccounts` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela bankdatabase.customercards: ~10 rows (aproximadamente)
/*!40000 ALTER TABLE `customercards` DISABLE KEYS */;
INSERT IGNORE INTO `customercards` (`id`, `cardNumber`, `password`, `creditLimit`, `creditGiven`, `dueDate`, `checkingAccount_id`, `savingAccount_id`, `PIXkey`, `owner_id`) VALUES
	(1, '5294995792483419', '26023757', 500, 20, '2022-12-02', 1, 2, 'xwxrxysbxyux7897', 1),
	(2, '5255019823466314', '31318553', 1000, 0, '2023-12-02', 3, 4, '12345', 2),
	(3, '5359490250344826', '19617920', 900, 100, '2023-11-02', 5, 6, '123456', 3),
	(4, '5571805367384492', '16926639', 878, 0, '2024-10-03', 7, 8, '1234567', 4),
	(5, '5252634283524338', '33171744', 1450, 0, '2024-12-04', 9, 10, '12345678', 5),
	(6, '5311057321049515', '98673115', 1745, 0, '2025-12-02', 11, 12, '123456789', 6),
	(7, '5156400614334244', '07786998', 897, 0, '2026-12-02', 13, 14, '1234567891', 7),
	(8, '5204240341719545', '58115409', 1524, 0, '2027-01-02', 15, 16, '12345678912', 8),
	(9, '5133786186764190', '82699139', 897, 0, '2022-03-02', 17, 18, '123456789123', 9),
	(10, '5444699294557147', '99621782', 788, 0, '2022-05-04', 19, 20, 'ffffff8785', 10);
/*!40000 ALTER TABLE `customercards` ENABLE KEYS */;

-- Copiando estrutura para tabela bankdatabase.employees
CREATE TABLE IF NOT EXISTS `employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  `fullNamer` varchar(50) NOT NULL,
  `cpf` varchar(50) NOT NULL,
  `phoneNumber1` varchar(50) NOT NULL,
  `phoneNumber2` varchar(50) DEFAULT NULL,
  `country` varchar(50) NOT NULL,
  `salary` int(11) NOT NULL,
  `employee_address_id` int(11) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `employee_id` (`employee_id`),
  UNIQUE KEY `cpf` (`cpf`),
  UNIQUE KEY `phoneNumber1` (`phoneNumber1`),
  UNIQUE KEY `phoneNumber2` (`phoneNumber2`),
  KEY `fk_employee_address_id` (`employee_address_id`),
  CONSTRAINT `fk_employee_address_id` FOREIGN KEY (`employee_address_id`) REFERENCES `addresses` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela bankdatabase.employees: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
