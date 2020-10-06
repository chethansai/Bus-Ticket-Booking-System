-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 20, 2020 at 11:58 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.2.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `bus10`
--

CREATE TABLE `bus10` (
  `uid` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `seatno` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bus10`
--

INSERT INTO `bus10` (`uid`, `username`, `seatno`, `status`) VALUES
(NULL, NULL, '1', '0'),
(NULL, NULL, '2', '0'),
(NULL, NULL, '3', '0'),
(NULL, NULL, '4', '0'),
(NULL, NULL, '5', '0'),
(NULL, NULL, '6', '0'),
(NULL, NULL, '7', '0'),
(NULL, NULL, '8', '0'),
(NULL, NULL, '9', '0'),
(NULL, NULL, '10', '0'),
(NULL, NULL, '11', '0'),
('ram', 'ram', '12', '1'),
('ram', 'ram', '13', '1'),
(NULL, NULL, '14', '0'),
(NULL, NULL, '15', '0');

-- --------------------------------------------------------

--
-- Table structure for table `bus11`
--

CREATE TABLE `bus11` (
  `uid` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `seatno` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bus11`
--

INSERT INTO `bus11` (`uid`, `username`, `seatno`, `status`) VALUES
('ram', 'kasyap', '1', '1'),
('ram', 'kasyap', '2', '1'),
('ram', 'kasyap', '3', '1'),
(NULL, NULL, '4', '0'),
(NULL, NULL, '5', '0'),
(NULL, NULL, '6', '0'),
(NULL, NULL, '7', '0'),
(NULL, NULL, '8', '0'),
(NULL, NULL, '9', '0'),
(NULL, NULL, '10', '0'),
(NULL, NULL, '11', '0'),
(NULL, NULL, '12', '0'),
(NULL, NULL, '13', '0'),
(NULL, NULL, '14', '0'),
(NULL, NULL, '15', '0'),
(NULL, NULL, '16', '0'),
(NULL, NULL, '17', '0'),
(NULL, NULL, '18', '0'),
(NULL, NULL, '19', '0'),
(NULL, NULL, '20', '0');

-- --------------------------------------------------------

--
-- Table structure for table `bus12`
--

CREATE TABLE `bus12` (
  `uid` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `seatno` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bus12`
--

INSERT INTO `bus12` (`uid`, `username`, `seatno`, `status`) VALUES
('kalyan', 'kalyan', '1', '1'),
('kalyan', 'kalyan', '2', '1'),
('kalyan', 'kalyan', '3', '1'),
('kalyan', 'kalyan', '4', '1'),
(NULL, NULL, '5', '0'),
(NULL, NULL, '6', '0'),
(NULL, NULL, '7', '0'),
(NULL, NULL, '8', '0'),
(NULL, NULL, '9', '0'),
(NULL, NULL, '10', '0'),
(NULL, NULL, '11', '0'),
(NULL, NULL, '12', '0'),
(NULL, NULL, '13', '0'),
(NULL, NULL, '14', '0'),
(NULL, NULL, '15', '0'),
(NULL, NULL, '16', '0'),
(NULL, NULL, '17', '0'),
(NULL, NULL, '18', '0'),
(NULL, NULL, '19', '0'),
(NULL, NULL, '20', '0'),
(NULL, NULL, '21', '0'),
(NULL, NULL, '22', '0'),
(NULL, NULL, '23', '0'),
(NULL, NULL, '24', '0'),
(NULL, NULL, '25', '0');

-- --------------------------------------------------------

--
-- Table structure for table `bus25`
--

CREATE TABLE `bus25` (
  `uid` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `seatno` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bus25`
--

INSERT INTO `bus25` (`uid`, `username`, `seatno`, `status`) VALUES
('ram', 'ram', '1', '1'),
(NULL, NULL, '2', '0'),
(NULL, NULL, '3', '0'),
(NULL, NULL, '4', '0'),
(NULL, NULL, '5', '0'),
(NULL, NULL, '6', '0'),
(NULL, NULL, '7', '0'),
(NULL, NULL, '8', '0'),
(NULL, NULL, '9', '0'),
(NULL, NULL, '10', '0'),
(NULL, NULL, '11', '0'),
(NULL, NULL, '12', '0'),
(NULL, NULL, '13', '0'),
(NULL, NULL, '14', '0'),
(NULL, NULL, '15', '0');

-- --------------------------------------------------------

--
-- Table structure for table `bus40`
--

CREATE TABLE `bus40` (
  `uid` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `seatno` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bus40`
--

INSERT INTO `bus40` (`uid`, `username`, `seatno`, `status`) VALUES
(NULL, NULL, '1', '0'),
(NULL, NULL, '2', '0'),
(NULL, NULL, '3', '0'),
(NULL, NULL, '4', '0'),
(NULL, NULL, '5', '0'),
(NULL, NULL, '6', '0'),
(NULL, NULL, '7', '0'),
(NULL, NULL, '8', '0'),
(NULL, NULL, '9', '0'),
(NULL, NULL, '10', '0');

-- --------------------------------------------------------

--
-- Table structure for table `bus_details`
--

CREATE TABLE `bus_details` (
  `busno` int(100) NOT NULL,
  `source` varchar(100) NOT NULL,
  `dest` varchar(100) NOT NULL,
  `dept` varchar(100) NOT NULL,
  `seats` varchar(100) NOT NULL,
  `price` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bus_details`
--

INSERT INTO `bus_details` (`busno`, `source`, `dest`, `dept`, `seats`, `price`) VALUES
(40, 'rajasthan', 'goa', '21august2020', '10', '400'),
(25, 'delhi', 'jammu', '25august2020', '15', '700'),
(10, 'hyderabad', 'goa', '25 august 2020', '15', '700'),
(11, 'hyderabad', 'goa', '23august2020', '20', '300'),
(12, 'hyderabad', 'goa', '25august2020', '25', '200');

-- --------------------------------------------------------

--
-- Table structure for table `regtable`
--

CREATE TABLE `regtable` (
  `fname` varchar(100) NOT NULL,
  `lname` varchar(100) NOT NULL,
  `mno` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `uid` varchar(100) NOT NULL,
  `pass` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `regtable`
--

INSERT INTO `regtable` (`fname`, `lname`, `mno`, `email`, `uid`, `pass`) VALUES
('kasyap', 'b', '12345', 'kb@gmail.com', 'kasyap', 'kasyap'),
('ram', 'krishna', '456789', 'ram@gmail.com', 'ram', 'ram'),
('sai', 'tej', '34567', 'tej@gmail.com', 'tej', 'tej'),
('shalini', 'reddy', '45678', 'shalini@gmail.com', 'shalini', 'shalini'),
('vishal', 'surya', '23456', 'vishal@gmail.com', 'vishal', 'vishal'),
('hari', 'teja', '1234567890', 'hari@gmail.com', 'hari', 'hari@1234'),
('kalyan', 'kumar', '1234567890', 'kalyan@gmail.com', 'kalyan', 'kalyan@123');

-- --------------------------------------------------------

--
-- Table structure for table `show_user`
--

CREATE TABLE `show_user` (
  `uid` varchar(100) NOT NULL,
  `busno` varchar(100) NOT NULL,
  `source` varchar(100) NOT NULL,
  `dest` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `show_user`
--

INSERT INTO `show_user` (`uid`, `busno`, `source`, `dest`, `username`) VALUES
('ram', '25 ', 'delhi', 'jammu', 'ram'),
('kalyan', '12 ', 'hyderabad', 'goa', 'kalyan'),
('ram', '11 ', 'hyderabad', 'goa', 'kasyap'),
('ram', '10 ', 'hyderabad', 'goa', 'ram');

-- --------------------------------------------------------

--
-- Table structure for table `usr_book`
--

CREATE TABLE `usr_book` (
  `username` varchar(100) NOT NULL,
  `seats` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usr_book`
--

INSERT INTO `usr_book` (`username`, `seats`) VALUES
('ram', '1'),
('ram', '2'),
('ram', '3'),
('kasyap', '4');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
