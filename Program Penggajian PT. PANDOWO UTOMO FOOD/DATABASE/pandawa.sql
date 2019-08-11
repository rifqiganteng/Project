-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 07, 2019 at 03:53 PM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 5.6.36

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pandawa`
--

-- --------------------------------------------------------

--
-- Table structure for table `bpjs_kesehatan`
--

CREATE TABLE `bpjs_kesehatan` (
  `id_tbpjs_kesehatan` varchar(20) DEFAULT NULL,
  `id_tpegawai` varchar(20) DEFAULT NULL,
  `nomor_bpjs` varchar(25) DEFAULT NULL,
  `faskes` varchar(25) DEFAULT NULL,
  `nominal` double(16,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bpjs_kesehatan`
--

INSERT INTO `bpjs_kesehatan` (`id_tbpjs_kesehatan`, `id_tpegawai`, `nomor_bpjs`, `faskes`, `nominal`) VALUES
('BPKS1', 'PEG1', '007', 'Dr Dodi Setiawan', 89000.00),
('BPKS2', 'PEG2', '0', '-', 0.00),
('BPKS3', 'PEG3', '0', '-', 0.00),
('BPKS4', 'PEG4', '0', '-', 0.00);

-- --------------------------------------------------------

--
-- Table structure for table `bpjs_ketenagakerjaan`
--

CREATE TABLE `bpjs_ketenagakerjaan` (
  `id_tbpjs_tenagakerja` varchar(20) DEFAULT NULL,
  `id_tpegawai` varchar(20) DEFAULT NULL,
  `nominal` double(16,2) DEFAULT NULL,
  `nomor_bpjs` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bpjs_ketenagakerjaan`
--

INSERT INTO `bpjs_ketenagakerjaan` (`id_tbpjs_tenagakerja`, `id_tpegawai`, `nominal`, `nomor_bpjs`) VALUES
('BPKT1', 'PEG1', 1077.00, '70000'),
('BPKT2', 'PEG2', 0.00, '0'),
('BPKT3', 'PEG3', 0.00, '0'),
('BPKT4', 'PEG4', 0.00, '0');

-- --------------------------------------------------------

--
-- Table structure for table `gaji`
--

CREATE TABLE `gaji` (
  `id_tgaji` varchar(20) NOT NULL,
  `id_tpegawai` varchar(20) NOT NULL,
  `gaji_pokok` double(16,2) NOT NULL,
  `t_struktural` double(16,2) NOT NULL,
  `t_fungsional` double(16,2) NOT NULL,
  `uang_makan` double(16,2) NOT NULL,
  `sewa_motor` double(16,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gaji`
--

INSERT INTO `gaji` (`id_tgaji`, `id_tpegawai`, `gaji_pokok`, `t_struktural`, `t_fungsional`, `uang_makan`, `sewa_motor`) VALUES
('G1', 'PEG1', 5000000.00, 400000.00, 300000.00, 15000.00, 50000.00),
('G2', 'PEG2', 3000000.00, 0.00, 0.00, 0.00, 0.00),
('G3', 'PEG3', 0.00, 0.00, 0.00, 0.00, 0.00),
('G4', 'PEG4', 0.00, 0.00, 0.00, 0.00, 0.00);

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `id_tpegawai` varchar(20) NOT NULL,
  `nama` text NOT NULL,
  `jenis_kelamin` varchar(20) NOT NULL,
  `no_ktp` varchar(20) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `no_tlp` varchar(20) NOT NULL,
  `agama` text NOT NULL,
  `pendidikan_terakhir` varchar(40) NOT NULL,
  `status` text NOT NULL,
  `nip` varchar(20) NOT NULL,
  `tgl_masuk` date NOT NULL,
  `bagian` varchar(40) NOT NULL,
  `jabatan` varchar(40) NOT NULL,
  `alamat` varchar(80) NOT NULL,
  `image` varchar(500) NOT NULL,
  `darah` varchar(10) NOT NULL,
  `alamat_sementara` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`id_tpegawai`, `nama`, `jenis_kelamin`, `no_ktp`, `tgl_lahir`, `no_tlp`, `agama`, `pendidikan_terakhir`, `status`, `nip`, `tgl_masuk`, `bagian`, `jabatan`, `alamat`, `image`, `darah`, `alamat_sementara`) VALUES
('PEG1', 'contoh', 'perempuan', '0099847758237728', '1990-01-02', '098776212334', 'Islam', 'sarjana teknik sipil', 'Menikah', '11111111111111111111', '2016-03-10', 'Distribusi Jawa Tengah', 'Kabag ADM', 'semarang', 'F:\\gambar\\28428060_151397705673018_2899572167156957184_n.jpg', 'AB', 'semarang'),
('PEG2', 'Budi Nuryoko', 'laki-laki', '3374041102970001', '1997-02-11', '089666619162', 'Islam', 'SMA', 'Belum Menikah', '11111111111111111111', '2016-12-30', 'Distribusi Jawa Tengah', 'Helper', 'Kp. Sawah Besar X RT.06/RW.05 Kaligawe, Gayamsari, Semarang', 'F:\\gambar\\6084350_86a5f4bf-5fe0-449a-a1f2-d944e8b430f4.jpg', 'B', 'Kp. Sawah Besar X RT.06/RW.05 Kaligawe, Gayamsari, Semarang'),
('PEG3', 'Rizky Danang Adriyanto', 'laki-laki', '3374081702970003', '1997-02-17', '\'085742408720', 'PILIH AGAMA', 'SMK', 'Belum Menikah', '22222222222222222222', '2018-01-28', 'Distribusi Jawa Tengah', 'Helper', 'Jl Kagok Rt06 Rw 05 Kel Wonotingal kec Candisari Semarang', 'F:\\gambar\\d7263243ddf849c5012fc8cb843f9992.jpg', 'O', 'Jl Kagok Rt06 Rw 05 Kel Wonotingal kec Candisari Semarang'),
('PEG4', 'Mursyid Alkahfi', 'laki-laki', '3387766377718263', '1993-02-10', '089665390894', 'Kristen', 'Sarjana 1', 'Menikah', '33333333333333333333', '2019-04-18', 'Produksi Gendro', 'Kepala Cabang', 'sumatra', 'C:\\Users\\RIFQI\\Pictures\\beautiful_house_wallpapers_35-roomwall-blog.jpg', 'O', 'jl feteran');

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE `petugas` (
  `id` varchar(10) NOT NULL,
  `nama` text NOT NULL,
  `jenis_kel` text NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `hak_akses` text NOT NULL,
  `alamat` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`id`, `nama`, `jenis_kel`, `username`, `password`, `hak_akses`, `alamat`) VALUES
('PET1', 'rifqi', 'perempuan', 'rifqi', 'rifqi', 'Admin', 'pati'),
('PET2', 'sulung', 'laki-laki', 'sulung', 'sulung', 'Petugas', 'ciamis jabar'),
('PET3', 'admin', 'perempuan', 'admin', 'admin', 'Admin', 'admin12'),
('PET4', 'lala', 'laki-laki', 'lala', 'lala', 'Petugas', 'gapunya');

-- --------------------------------------------------------

--
-- Table structure for table `piutang`
--

CREATE TABLE `piutang` (
  `id_piutang` varchar(20) DEFAULT NULL,
  `id_tpegawai` varchar(20) DEFAULT NULL,
  `nominal_sebelum` double(20,2) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `nominal_sesudah` double(20,2) DEFAULT NULL,
  `jumlah_piutang` double(20,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `piutang`
--

INSERT INTO `piutang` (`id_piutang`, `id_tpegawai`, `nominal_sebelum`, `tanggal`, `nominal_sesudah`, `jumlah_piutang`) VALUES
('P1', 'PEG1', 70000.00, '2019-03-05', 40000.00, 74000.00),
('P2', 'PEG2', 4000000.00, '2019-02-28', 80000.00, 4008000.00),
('P3', 'PEG3', 0.00, '2018-01-28', 0.00, 0.00),
('P4', 'PEG4', 0.00, '2019-04-18', 0.00, 0.00);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
