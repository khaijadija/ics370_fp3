-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 05, 2021 at 03:52 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `omdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `ms_test_data`
--

CREATE TABLE `ms_test_data` (
  `ID` int(11) NOT NULL,
  `native_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `year_made` int(4) NOT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `execution_status` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `ms_test_data`
--

INSERT INTO `ms_test_data` (`ID`, `native_name`, `year_made`, `title`, `execution_status`) VALUES
(1, 'Frozen', 2013, 'Frozen Heart', 'To Be Processed'),
(2, 'Frozen', 2013, 'Do you want to build a snowman', 'To Be Processed'),
(3, 'Frozen', 2013, 'For the first time in forever', 'To Be Processed'),
(4, 'Frozen', 2013, 'Love is an open door', 'To Be Processed'),
(5, 'Frozen', 2013, 'Let it Go', 'To Be Processed'),
(6, 'Frozen', 2013, 'Frozen Heart', 'To Be Processed'),
(7, 'Frozen', 2013, 'Do you want to build a snowman', 'To Be Processed'),
(8, 'Frozen', 2014, 'Let it Go', 'To Be Processed'),
(9, 'Frozen', 2013, 'Let it Go', 'To Be Processed'),
(10, 'Frozen', 2013, 'Let it Go', 'To Be Processed'),
(11, 'West Side Story', 1961, 'Jet Song', 'To Be Processed'),
(12, 'West Side Story', 1961, 'Something Coming', 'To Be Processed'),
(13, 'West Side Story', 1961, 'Maria', 'To Be Processed'),
(14, 'West Side Story', 1961, 'Dance at the Gym', 'To Be Processed'),
(15, 'West Side Story', 1961, 'Something Coming', 'To Be Processed'),
(16, 'West Side Story', 1961, 'Maria', 'To Be Processed'),
(17, 'West Side Story', 1961, 'Dance at the Gym', 'To Be Processed'),
(18, 'West Side Story', 1961, 'Something Coming', 'To Be Processed'),
(19, 'West Side Story', 1961, 'Maria', 'To Be Processed'),
(20, 'West Side Story', 1961, 'Dance at the Gym', 'To Be Processed'),
(21, 'West Side Story', 1961, 'Something Coming', 'To Be Processed'),
(22, 'West Side Story', 1961, 'Jet Song', 'To Be Processed');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ms_test_data`
--
ALTER TABLE `ms_test_data`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ms_test_data`
--
ALTER TABLE `ms_test_data`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
