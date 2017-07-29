CREATE DATABASE  IF NOT EXISTS `persons_and_groups`;
USE `persons_and_groups`;

DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

LOCK TABLES `group` WRITE;
INSERT INTO `group` VALUES (1,'low'),(2,'medium'),(3,'high');
UNLOCK TABLES;

DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `person_id` int(11) NOT NULL AUTO_INCREMENT,
  `person_name` varchar(45) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `group_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`person_id`),
  KEY `fg_idx` (`group_number`),
  CONSTRAINT `fk` FOREIGN KEY (`group_number`) REFERENCES `group` (`group_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

LOCK TABLES `person` WRITE;
INSERT INTO `person` VALUES (1,'John','1999-05-11',2),(2,'Jane','2005-01-08',1),(3,'Steve','1977-12-15',3),(4,'Paul','1998-01-12',1);
UNLOCK TABLES;
