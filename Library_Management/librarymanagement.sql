-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 10, 2019 at 06:43 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `librarymanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `booktable`
--

CREATE TABLE `booktable` (
  `BOOKID` int(11) NOT NULL,
  `BOOKNAME` varchar(70) NOT NULL,
  `BOOKAUTHOR` varchar(50) NOT NULL,
  `BOOKPUBLISHER` varchar(70) NOT NULL,
  `BOOKAVAILABLE` int(11) NOT NULL,
  `MEMBERID` varchar(30) DEFAULT NULL,
  `ISSUEDATE` varchar(40) NOT NULL,
  `LASTDATE` int(11) NOT NULL DEFAULT '5',
  `FINES` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booktable`
--

INSERT INTO `booktable` (`BOOKID`, `BOOKNAME`, `BOOKAUTHOR`, `BOOKPUBLISHER`, `BOOKAVAILABLE`, `MEMBERID`, `ISSUEDATE`, `LASTDATE`, `FINES`) VALUES
(123, ' ejfk ', ' rnbkrn ', ' nejng', 1, '123', '2019-04-09 00:00:00', 10, 0),
(2, 'A', ' J', ' L  ', 0, '123', '2019-04-11', 5, 0),
(3456, ' fghjk ', ' dfghj ', ' dfbnm', 1, '', '2019-04-09 20:48:36', 5, 0),
(678, ' fgn ', ' iyutr ', ' vbnm', 1, '123', '2019-04-09', 5, 0),
(132, ' ad ', ' das ', ' acd', 1, '123', '2019-04-11', 10, 0),
(4, ' x ', ' y ', ' u', 1, '0', '0', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `membertable`
--

CREATE TABLE `membertable` (
  `MEMBERID` varchar(50) NOT NULL,
  `MEMBERNAME` varchar(50) NOT NULL,
  `MEMBERPHONE` varchar(50) NOT NULL,
  `MEMBEREMAIL` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `membertable`
--

INSERT INTO `membertable` (`MEMBERID`, `MEMBERNAME`, `MEMBERPHONE`, `MEMBEREMAIL`) VALUES
('123', ' jkl ', ' 123 ', ' efeb@gmail.com'),
('12345', ' Datt ', ' 00002 ', ' dsjg@gmail.com');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
