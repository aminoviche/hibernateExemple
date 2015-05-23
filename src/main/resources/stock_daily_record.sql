-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le : Sam 02 Mai 2015 à 12:56
-- Version du serveur: 5.5.40
-- Version de PHP: 5.3.10-1ubuntu3.15

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `mkyongdb`
--

-- --------------------------------------------------------

--
-- Structure de la table `stock_daily_record`
--

CREATE TABLE IF NOT EXISTS `stock_daily_record` (
  `RECORD_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `PRICE_OPEN` float(6,2) DEFAULT NULL,
  `PRICE_CLOSE` float(6,2) DEFAULT NULL,
  `PRICE_CHANGE` float(6,2) DEFAULT NULL,
  `VOLUME` bigint(20) unsigned DEFAULT NULL,
  `DATE` date NOT NULL,
  `STOCK_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`RECORD_ID`) USING BTREE,
  KEY `FK_STOCK_TRANSACTION_STOCK_ID` (`STOCK_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=55 ;

--
-- Contenu de la table `stock_daily_record`
--

INSERT INTO `stock_daily_record` (`RECORD_ID`, `PRICE_OPEN`, `PRICE_CLOSE`, `PRICE_CHANGE`, `VOLUME`, `DATE`, `STOCK_ID`) VALUES
(52, 1.20, 1.10, 10.00, 3000000, '2014-11-23', 50),
(53, 1.20, 1.10, 10.00, 3000000, '2015-05-02', 51),
(54, 1.20, 1.10, 10.00, 3000000, '2015-05-02', 53);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `stock_daily_record`
--
ALTER TABLE `stock_daily_record`
  ADD CONSTRAINT `FK_STOCK_TRANSACTION_STOCK_ID` FOREIGN KEY (`STOCK_ID`) REFERENCES `stock` (`STOCK_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
