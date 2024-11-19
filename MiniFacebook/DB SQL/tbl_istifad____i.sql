-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 19, 2024 at 06:37 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mini_facebook`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_istifadəçi`
--

CREATE TABLE `tbl_istifadəçi` (
  `epoçt` varchar(50) NOT NULL,
  `şifrə` varchar(20) NOT NULL,
  `ad` varchar(20) NOT NULL,
  `soyad` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_istifadəçi`
--

INSERT INTO `tbl_istifadəçi` (`epoçt`, `şifrə`, `ad`, `soyad`) VALUES
('leyla@gmail.com', '123', 'Leyla', 'Qulamoğlu'),
('nimtac@gmail.com', '123', 'Nimtac', 'Qulamqızı'),
('qulam@gmail.com', '123', 'Qulam', 'Eldaroğlu'),
('yusif@gmail.com', '123', 'Yusif', 'Qulamoğlu');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_istifadəçi`
--
ALTER TABLE `tbl_istifadəçi`
  ADD PRIMARY KEY (`epoçt`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
