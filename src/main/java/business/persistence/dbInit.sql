/*
    You might want to rename the database to your own needs.
    If so, please substitute `startcode` with whatever your project is called.
 */

CREATE DATABASE  IF NOT EXISTS `startcode`;

USE `startcode`;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(90) NOT NULL,
  `address` varchar(90) NOT NULL,
  `tele_number` INT NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(20) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES
(1,'Jens','jens@somewhere.com','jensensvej' , '88888888', 'jensen','customer'),
(2, 'Ken','ken@somewhere.com', 'kensensvej', '33333333','kensen','customer'),
(3, 'Robin','robin@somewhere.com', 'robinsvej', '74747474','batman','employee');
UNLOCK TABLES;

