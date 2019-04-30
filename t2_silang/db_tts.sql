-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 30, 2019 at 05:06 AM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_tts`
--

-- --------------------------------------------------------

--
-- Table structure for table `tanya_jawab`
--

CREATE TABLE `tanya_jawab` (
  `id` int(11) NOT NULL,
  `no_soal` int(11) NOT NULL,
  `jenis` varchar(8) NOT NULL,
  `tanya` text NOT NULL,
  `jawab` varchar(9) NOT NULL,
  `kolom` int(11) NOT NULL,
  `baris` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tanya_jawab`
--

INSERT INTO `tanya_jawab` (`id`, `no_soal`, `jenis`, `tanya`, `jawab`, `kolom`, `baris`) VALUES
(1, 1, 'mendatar', 'banyak pelek(inggris)', 'rims', 0, 0),
(2, 1, 'menurun', 'bagian yg berguna mengurangi kecepatan kendaraan', 'rem', 0, 0),
(3, 2, 'menurun', 'bagian motor yg biasa di pegang', 'stang', 3, 0),
(4, 3, 'menurun', 'kendaraan kecil yg di produksi', 'motor', 5, 0),
(5, 4, 'mendatar', 'PT. __ Honda Motor', 'astra', 3, 2),
(6, 5, 'menurun', 'salah satu alat safety kendaraan(inggris)', 'helmet', 1, 3),
(7, 6, 'mendatar', 'asal kata pelek', 'velg', 0, 4),
(8, 7, 'menurun', 'pelumas(inggris)', 'oil', 4, 5),
(9, 8, 'mendatar', 'yg tidak di produksi PT.Astra Honda Motor', 'mobil', 1, 6),
(10, 9, 'mendatar', 'tim pengurus mobile app Honda', 'it', 0, 8),
(11, 10, 'mendatar', 'cuaca yg buruk untuk berkendara(inggris)', 'rain', 5, 4),
(12, 11, 'menurun', 'bagian belakang motor (______T)', 'knalpo', 8, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tanya_jawab`
--
ALTER TABLE `tanya_jawab`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tanya_jawab`
--
ALTER TABLE `tanya_jawab`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
