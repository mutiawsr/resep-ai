-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 12, 2022 at 06:07 PM
-- Server version: 5.7.17-log
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `resepai-db-loreg`
--

-- --------------------------------------------------------

--
-- Table structure for table `bahan`
--

CREATE TABLE `bahan` (
  `id` int(11) NOT NULL,
  `nama_bahan` varchar(200) NOT NULL,
  `harga` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bahan`
--

INSERT INTO `bahan` (`id`, `nama_bahan`, `harga`) VALUES
(1, 'ayam', 28000),
(2, 'jeruk nipis', 6000),
(3, 'bumbu ayam goreng', 2000),
(4, 'daun salam', 5000),
(5, 'daun jeruk', 1000),
(6, 'sere', 1000),
(7, 'garam', 1000),
(8, 'minyak goreng', 5000),
(9, 'sambal penyet jadi', 20000),
(10, 'cabe rawit', 20000),
(11, 'cabe merah', 15000),
(12, 'bawang kating', 1000),
(13, 'bawang merah', 500),
(14, 'gula', 500),
(15, 'nasi', 3000),
(16, 'fillet ayam', 5000),
(17, 'daun kemanggi', 2000),
(18, 'kecap manis', 7000),
(19, 'bawang putih', 1000),
(20, 'kemiri', 1000),
(21, 'jahe', 1500),
(22, 'tomat', 1000),
(23, 'kaldu ayam jadi', 1000),
(24, 'merica', 500),
(25, 'daging kambing', 10000),
(26, 'cengkeh', 1000),
(27, 'kemiri', 500),
(28, 'kunyit', 1000),
(29, 'lengkuas', 1000),
(30, 'ketumbar', 500),
(31, 'tempe', 3000),
(32, 'buncis', 1000),
(33, 'saos tiram', 1000),
(34, 'bawang bombai', 3000),
(35, 'daun bawang', 1000),
(36, 'santan', 1000),
(37, 'kunyit', 1500),
(38, 'seledri', 1000),
(39, 'telur', 1500),
(40, 'udang', 2000),
(41, 'tahu', 5000);

-- --------------------------------------------------------

--
-- Table structure for table `daftar_bahan`
--

CREATE TABLE `daftar_bahan` (
  `id_daftar` int(11) NOT NULL,
  `id_bahan` int(11) NOT NULL,
  `id_resep` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `daftar_bahan`
--

INSERT INTO `daftar_bahan` (`id_daftar`, `id_bahan`, `id_resep`) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 1),
(4, 4, 1),
(5, 5, 1),
(6, 6, 1),
(7, 7, 1),
(8, 8, 1),
(9, 9, 1),
(10, 10, 1),
(11, 11, 1),
(12, 12, 1),
(13, 13, 1),
(14, 14, 1),
(15, 15, 2),
(16, 16, 2),
(17, 4, 2),
(18, 6, 2),
(19, 17, 2),
(20, 11, 2),
(21, 18, 2),
(22, 8, 2),
(23, 13, 2),
(24, 19, 2),
(25, 20, 2),
(26, 28, 2),
(27, 21, 2),
(28, 22, 2),
(29, 14, 2),
(30, 23, 2),
(31, 24, 2),
(32, 25, 3),
(33, 6, 3),
(34, 4, 3),
(35, 5, 3),
(36, 11, 3),
(37, 26, 3),
(38, 13, 3),
(39, 19, 3),
(40, 20, 3),
(41, 28, 3),
(42, 21, 3),
(43, 29, 3),
(44, 30, 3),
(45, 24, 3),
(46, 7, 3),
(47, 14, 3),
(48, 31, 4),
(49, 32, 4),
(50, 18, 4),
(51, 14, 4),
(52, 7, 4),
(53, 11, 4),
(54, 10, 4),
(55, 19, 4),
(56, 13, 4),
(57, 31, 5),
(58, 13, 5),
(59, 19, 5),
(60, 29, 5),
(61, 7, 5),
(62, 14, 5),
(63, 39, 5),
(64, 41, 6),
(65, 8, 6),
(66, 19, 6),
(67, 24, 6),
(68, 7, 6),
(69, 40, 7),
(70, 21, 7),
(71, 33, 7),
(72, 22, 7),
(73, 7, 7),
(74, 14, 7),
(75, 19, 7),
(76, 13, 7),
(77, 11, 7),
(78, 10, 7),
(79, 24, 7);

-- --------------------------------------------------------

--
-- Table structure for table `kategoritb`
--

CREATE TABLE `kategoritb` (
  `id` int(10) NOT NULL,
  `nama_kategori` varchar(100) NOT NULL,
  `image_url` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `kategoritb`
--

INSERT INTO `kategoritb` (`id`, `nama_kategori`, `image_url`) VALUES
(4, 'Apptizer', 'https://storage.googleapis.com/image-url/Apptizer.jpeg'),
(5, 'Chinesefood', 'https://storage.googleapis.com/image-url/Chinesefood.jpeg'),
(6, 'japanese', 'https://storage.googleapis.com/image-url/japanese.jpeg'),
(7, 'korean', 'https://storage.googleapis.com/image-url/korean.jpeg');

-- --------------------------------------------------------

--
-- Table structure for table `resep`
--

CREATE TABLE `resep` (
  `id` int(8) NOT NULL,
  `nama_resep` varchar(150) NOT NULL,
  `kategori` varchar(150) NOT NULL,
  `langkah` varchar(10000) NOT NULL,
  `likes` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `resep`
--

INSERT INTO `resep` (`id`, `nama_resep`, `kategori`, `langkah`, `likes`) VALUES
(1, 'Ayam penyet rumahan', 'Indonesian', 'Ungkep ayam bersama bumbu jadi, daun salam, daun jeruk, sere,dan garam,tambah sedikit penyedap apinya kecil ajah ya. \r\nLalu tutup Apabila sudah empuk dan matang goreng dalam minyak panas dan banyak sampe warna kuning kecoklatan, \r\nangkat Sementara lagi goreng ayam, kita siapkan sambel dulu, uleg semua cabe, dan bawang merah garam,sedikit gula dan penyedap,\r\nsetelah agak halus kumpulin sambalnya di tengah cobek \r\nlalu siram dengan minyak panas bekas goreng ayam tadi lalu uleg lagi supaya rata \r\nMasukan ayam goreng ke dalam cobek lalu penyet pake ulegan, siap di hidangkan\r\nSelamat mencoba\r\n', 210),
(2, 'nasi bakar ayam', 'Indonesian', 'Tumis bumbu halus, masukkan daun salam, serai\r\nMasukkan potongan ayam, kecap dan air, masak hingga air menyusut dan koreksi rasa\r\nMasukkan irisan cabe merah dan daun kemangi, aduk sebentar dan matikan api\r\nTata daun pisang, tata nasi di atas daun, beri isian ayam atau bisa juga nasi di campur dan diaduk dulu dengan ayam baru di tata di daun Pisang, bunbu ayam akan lebih meresap ke nasi\r\nSetelah nasi di bungkus, barulah nasi di bakar, aku bakar pake teflon biar cepet \r\nSajikan selagi hangat \r\nNote: Jangan membakar terlalu lama biar nasi ga kotor dari daun yg di bakar kering\r\n', 108),
(3, 'gulai kambing', 'Indonesian', 'Rebus dgng kambing dgn jahe krng lbh 20 menit lalu buang airnya,cuci bersih\r\nTumis bumbu yg sudah dihaluskn,masukn semua bahan Dan bumbu\r\nRebus sampe empuk--Terakhir masukn santan, tes rasa\r\nSajikan dimangkok\r\n', 45),
(4, 'oseng tempe buncis', 'Indonesian', 'Tumis bumbu iris, daun salam, lengkuas smp harum \r\nlalu masukan buncis smp agak layu masukan tempe, saos tiram,kecap manis, masako ayam, bwang bombai & air scukupny \r\nlalu cek rasa jika sdh pas matikan api dan sajikan', 12),
(5, 'perkedel tempe', 'Indonesian', 'Kukus tempe kurleb 20-30 menit. Haluskan selagi hangat\r\nMasukkan semua bahan jadi satu, aduk rata.\r\nGoreng dalam minyak panas. Biarkan kering dan hanya dibalik satu kali supaya tidak hancur dan tidak berminyak\r\nAngkat, tiriskan dan sajikan\r\n', 56),
(6, 'tahu bulat', 'Indonesian', 'Haluskan tahu dengan garpu.\r\nSaring tahu dengan kain berpori halus, peras pelan pelan hingga kadar airnya berkurang banyak. \r\nCara menyaring tahu begini sebaiknya sedikit sedikit dan memerasnya jangan terlalu kuat.\r\nSetelah airnya di peras,campurÂ tahuÂ dengan bumbu halus, aduk rata. bentuk bulat.\r\nPanaskan minyak dengan api sedang. \r\nMasukanÂ tahuÂ bulat, goreng hingga kuning kecokelatan.\r\nSajikan hangat.\r\n', 27),
(7, 'udang saos padang', 'Indonesian', 'Haluskan bumbu, tumis di atas wajan dengan minyak secukupnya\r\nMasukkan udang, tomat, dan air\r\nBeri gula, garam, saos tiram dan sambal, aduk rata, kemudian tes rasanya\r\nsajikan\r\n', 30);

-- --------------------------------------------------------

--
-- Table structure for table `usertb`
--

CREATE TABLE `usertb` (
  `userid` int(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL DEFAULT '',
  `no_hp` varchar(20) NOT NULL DEFAULT '',
  `alamat` varchar(100) NOT NULL DEFAULT '',
  `photourl` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usertb`
--

INSERT INTO `usertb` (`userid`, `email`, `username`, `password`, `name`, `no_hp`, `alamat`, `photourl`) VALUES
(1, 'admin@gmail.com', 'newadmin', 'admin1234', 'admin', '6387129031', 'Jalan kaki', 'https://storage.googleapis.com/image-url/profileimage.png'),
(2, 'admin1@gmail.com', 'admin1', 'admin12345', 'admin1', '87654321', 'jalani saja', 'https://storage.googleapis.com/image-url/profileimage.png'),
(13, 'admin12@gmail.com', 'newadminr35', '$2b$10$GrhdLf5LM/.QRU7nP9SJe.bGhSOPX4lnVvCeFGOe0NfVDz6OIAyXK', 'newadminr35', '', '', 'https://storage.googleapis.com/image-url/profileimage.png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bahan`
--
ALTER TABLE `bahan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `daftar_bahan`
--
ALTER TABLE `daftar_bahan`
  ADD PRIMARY KEY (`id_daftar`),
  ADD KEY `id_resep` (`id_resep`),
  ADD KEY `id_bahan` (`id_bahan`);

--
-- Indexes for table `kategoritb`
--
ALTER TABLE `kategoritb`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `resep`
--
ALTER TABLE `resep`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usertb`
--
ALTER TABLE `usertb`
  ADD PRIMARY KEY (`userid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bahan`
--
ALTER TABLE `bahan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;
--
-- AUTO_INCREMENT for table `daftar_bahan`
--
ALTER TABLE `daftar_bahan`
  MODIFY `id_daftar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=80;
--
-- AUTO_INCREMENT for table `kategoritb`
--
ALTER TABLE `kategoritb`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `resep`
--
ALTER TABLE `resep`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `usertb`
--
ALTER TABLE `usertb`
  MODIFY `userid` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `daftar_bahan`
--
ALTER TABLE `daftar_bahan`
  ADD CONSTRAINT `daftar_bahan_ibfk_1` FOREIGN KEY (`id_resep`) REFERENCES `resep` (`id`),
  ADD CONSTRAINT `daftar_bahan_ibfk_2` FOREIGN KEY (`id_bahan`) REFERENCES `bahan` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
