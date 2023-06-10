-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 10, 2023 at 07:14 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `clinic_appointments`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointments`
--

CREATE TABLE `appointments` (
  `id` int(255) NOT NULL,
  `appointmentdate` varchar(100) NOT NULL,
  `appointmentday` varchar(150) NOT NULL,
  `appointmenttime` varchar(100) NOT NULL,
  `status` enum('free','booked') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `appointments`
--

INSERT INTO `appointments` (`id`, `appointmentdate`, `appointmentday`, `appointmenttime`, `status`) VALUES
(17, '18-5-2023', 'Wednesday', '15:40:00', 'booked'),
(18, '10-5-2023', 'Tuesday', '12:30:00', 'booked'),
(19, '11-5-2023', 'Monday', '15:00:00', 'booked'),
(22, '19-5-2023', 'Wednesday', '10:10:00', 'booked'),
(23, '13-5-2023', 'Thursday', '12:20:00', 'booked'),
(24, '10-6-2023', 'starday', '12:30:00', 'booked');

-- --------------------------------------------------------

--
-- Table structure for table `booked_appointments`
--

CREATE TABLE `booked_appointments` (
  `id` int(255) NOT NULL,
  `appointmentid` int(255) NOT NULL,
  `userid` int(255) NOT NULL,
  `status` enum('waiting','finished') NOT NULL,
  `doctorcommnet` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `booked_appointments`
--

INSERT INTO `booked_appointments` (`id`, `appointmentid`, `userid`, `status`, `doctorcommnet`) VALUES
(8, 17, 22, 'waiting', ''),
(9, 18, 19, 'finished', 'وقف علاج'),
(10, 17, 14, 'finished', 'حبة كل 84 ساعة '),
(11, 18, 12, 'finished', 'حبة كل 12 ساعة '),
(12, 19, 12, 'waiting', ''),
(13, 23, 12, 'waiting', ''),
(15, 22, 27, 'finished', 'حبة اكمول عند اللزوم'),
(16, 24, 27, 'waiting', '');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(255) NOT NULL,
  `username` varchar(150) NOT NULL,
  `password` varchar(250) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `age` int(100) NOT NULL,
  `email` varchar(150) NOT NULL,
  `phone` bigint(20) NOT NULL,
  `gender` enum('male','female') NOT NULL,
  `role` enum('admin','patient') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `firstname`, `lastname`, `age`, `email`, `phone`, `gender`, `role`) VALUES
(12, 'mohamed', 'mohamed', 'mohamed', 'mohamed', 123, 'mohamed', 123, 'male', 'patient'),
(14, 'zyad', 'zyad2344', 'zyad', 'zyad', 20, 'zyad', 84, 'male', 'patient'),
(19, 'zooz', 'zooz', 'zooz', 'zooz', 21, 'zooz', 12, 'male', 'patient'),
(21, 'zyadmo', '123', 'zyad', 'shehab', 20, 'zyadq@gmail.com', 123456789, 'male', 'admin'),
(22, 'ahmed', 'ahmed', 'ahmed', 'ahmed', 50, 'ahmed', 123, 'male', 'patient'),
(26, 'admin', 'admin', 'zyad', 'shehab', 20, 'zyad.com', 15487554, 'male', 'admin'),
(27, 'ali', 'ali', 'ali', 'ahmed', 23, 'ali.com', 9384103, 'male', 'patient');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointments`
--
ALTER TABLE `appointments`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `booked_appointments`
--
ALTER TABLE `booked_appointments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `appointment_id` (`appointmentid`),
  ADD KEY `user_id` (`userid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointments`
--
ALTER TABLE `appointments`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `booked_appointments`
--
ALTER TABLE `booked_appointments`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `booked_appointments`
--
ALTER TABLE `booked_appointments`
  ADD CONSTRAINT `booked_appointments_ibfk_1` FOREIGN KEY (`appointmentid`) REFERENCES `appointments` (`id`),
  ADD CONSTRAINT `booked_appointments_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
