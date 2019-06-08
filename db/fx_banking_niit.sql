-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 08, 2019 at 02:25 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fx_banking_niit`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `Acct_id` int(11) NOT NULL,
  `a_fname` varchar(30) NOT NULL,
  `a_lname` varchar(30) NOT NULL,
  `a_phone` varchar(25) NOT NULL,
  `a_email` varchar(30) NOT NULL,
  `a_dob` varchar(10) NOT NULL,
  `a_city` varchar(30) NOT NULL,
  `a_address` varchar(100) NOT NULL,
  `a_gender` varchar(10) NOT NULL,
  `a_national` varchar(30) NOT NULL,
  `a_acctNo` int(11) NOT NULL,
  `a_acctBal` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`Acct_id`, `a_fname`, `a_lname`, `a_phone`, `a_email`, `a_dob`, `a_city`, `a_address`, `a_gender`, `a_national`, `a_acctNo`, `a_acctBal`) VALUES
(1, 'Ferdinand', 'Eke', '08035868983', 'razi@gmail.com', '7/1/1991', 'Atlanta', 'Atlanta Georgia', 'Male', 'USA', 550, 41000),
(2, 'Donald', 'Trump', '08157050520', 'donT@g.com', '5/1/1944', 'New York', 'Smallvile', 'Male', 'USA', 5676, 8000),
(3, 'nino', 'ferzi', '0803123', 'ni@g.com', '5/2/1991', 'Carli', 'Carlifonia', 'Male', 'USA', 4871, 10000),
(4, 'Pedro', 'Uzoma', '08060393914', 'uzo@gmail.com', '8/20/1992', 'PortHarc', 'Oyigbo', 'Male', 'Nigeria', 665, 6000),
(5, 'Emeka', 'Ekeke', '08039463706', 'mek@gmail.com', '9/30/1993', 'PortHarc', 'Ogbunabali', 'Male', 'Nigeria', 9814, 15000),
(6, 'Immaculata', 'Eke', '07069736686', 'imma@gmail.com', '4/14/1993', 'Toronto', 'Yorkville', 'Female', 'Canada', 8204, 25000),
(7, 'Nasa', 'Eke', '08135083511', 'nasa@gmail.com', '6/17/1987', 'London', 'North London', 'Female', 'UK', 6591, 30000),
(8, 'David', 'Cameron', '08157050520', 'cameron@gmail.com', '5/1/1987', 'Baltonmore', 'Nwe York', 'Male', 'USA', 7665, 1000);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `sid` int(11) NOT NULL,
  `s_fname` varchar(20) NOT NULL,
  `s_lname` varchar(20) NOT NULL,
  `s_phone` varchar(20) NOT NULL,
  `s_dob` varchar(20) NOT NULL,
  `s_email` varchar(30) NOT NULL,
  `s_pass` varchar(30) NOT NULL,
  `s_address` varchar(100) NOT NULL,
  `s_role` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`sid`, `s_fname`, `s_lname`, `s_phone`, `s_dob`, `s_email`, `s_pass`, `s_address`, `s_role`) VALUES
(1, 'a', 'b', '1', '5/5/2019', 'g@g.com', '1', 'abj', 'Admin'),
(9, 'f', 'g', '2340803', '5/5/2019', 'a@g.com', 'ok', 'abj', 'User'),
(10, 'Awazi', 'Ibrahim', '08036693224', '1/2/1994', 'awa@gmail.com', '1234', 'Kuje', 'User'),
(11, 'Dave', 'Carter', '08035868983', '6/1/1995', 'dave@gmail.com', '123', 'wuse', 'User');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`Acct_id`),
  ADD UNIQUE KEY `a_acctNo` (`a_acctNo`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`sid`),
  ADD UNIQUE KEY `s_email` (`s_email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accounts`
--
ALTER TABLE `accounts`
  MODIFY `Acct_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `sid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
