create Database `multiuserlogin`;
use multiuserlogin;

-- --------------------------------------------------------

--
-- Table structure for table `coursedetails`
--

DROP TABLE IF EXISTS `coursedetails`;
CREATE TABLE IF NOT EXISTS `coursedetails` (
  `Semester` int NOT NULL,
  `coursename` varchar(20) NOT NULL,
  `Course_id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Course_id`),
  UNIQUE KEY `Semester` (`coursename`)
);

--
-- Dumping data for table `coursedetails`
--

INSERT INTO `coursedetails` (`Semester`, `coursename`, `Course_id`) VALUES
(3, 'Maths-3', 2),
(4, 'Maths-4', 3),
(2, 'DSA', 4),
(3, 'AP', 7),
(4, 'OS', 8),
(3, 'IDBMS', 9),
(3, 'COA', 10),
(3, 'OTA', 11),
(4, 'PTS', 12),
(3, 'EFE', 14),
(4, 'Statistics', 15);

-- --------------------------------------------------------

--
-- Table structure for table `studentdetails`
--

DROP TABLE IF EXISTS `studentdetails`;
CREATE TABLE IF NOT EXISTS `studentdetails` (
  `username` varchar(20) NOT NULL,
  `FirstName` varchar(20) NOT NULL,
  `LastName` varchar(20) NOT NULL,
  `DOB` date NOT NULL,
  `password` varchar(20) NOT NULL,
  `address` varchar(50) NOT NULL ,
  `Stream` varchar(20) NOT NULL ,
  `BloodGroup` varchar(3) NOT NULL ,
  `Semester` int NOT NULL ,
  `contact` varchar(13) NOT NULL,
  PRIMARY KEY (`username`)
) ;

--
-- Dumping data for table `studentdetails`
--

INSERT INTO `studentdetails` (`username`, `FirstName`, `LastName`, `DOB`, `password`, `address`, `Stream`, `BloodGroup`, `Semester`, `contact`) VALUES
('student', 'AKSHAY', 'Kumar', '2008-07-04', 'student', 'delhi, India', 'CSE', 'B+', 3, '919352481747'),
('19ucs100', 'Ram', 'Shetty', '2002-12-11', '100', 'Changing me', 'CSE', 'B+', 3, '9829866678'),
('19ucs002', 'Ekta', 'Malla', '2008-10-04', '002', 'Jaipur', 'B-TECH CSE', 'O+', 3, '98989898989'),
('RajaS', 'Raja', 'Sethi', '2000-12-11', 'rajaji', 'Jaipur, Rajasthan', 'CSE', 'O+', 3, '9876489054');

-- --------------------------------------------------------

--
-- Table structure for table `tutordetails`
--

DROP TABLE IF EXISTS `tutordetails`;
CREATE TABLE IF NOT EXISTS `tutordetails` (
  `username` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `DOB` date NOT NULL,
  `DOJ` date NOT NULL,
  `contact` varchar(13) NOT NULL,
  `degree` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `postassigned` varchar(20) NOT NULL,
  `salary` varchar(20) NOT NULL,
  `address` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
);

--
-- Dumping data for table `tutordetails`
--

INSERT INTO `tutordetails` (`username`, `name`, `DOB`, `DOJ`, `contact`, `degree`, `password`, `postassigned`, `salary`, `address`) VALUES
('RajaS', 'Raja', '2244-11-30', '1888-12-11', '9898989898', 'Phd', 'raja', 'Director', '2345654346', 'Jaipur');

-- --------------------------------------------------------

--
-- Table structure for table `taughtby`
--

DROP TABLE IF EXISTS `taughtby`;
CREATE TABLE IF NOT EXISTS `taughtby` (
  `Course_Id` int NOT NULL,
  `tusername` varchar(20) NOT NULL,
  constraint `pk_taughtby` PRIMARY KEY (`tusername`,`Course_Id`),
  constraint `fk_taughtby_course` foreign key (`Course_Id`) references coursedetails(`Course_Id`),
  constraint `fk_taughtby_username` foreign key (`tusername`) references tutordetails(`username`)
);

--
-- Dumping data for table `taughtby`
--

INSERT INTO `taughtby` (`Course_Id`, `tusername`) VALUES
(7, 'RajaS');

-- --------------------------------------------------------

--
-- Table structure for table `marks`
--

DROP TABLE IF EXISTS `marks`;
CREATE TABLE IF NOT EXISTS `marks` (
  `coursename` varchar(20) NOT NULL,
  `studusername` varchar(20) NOT NULL,
  `marks` int NOT NULL,
  constraint `pk_marks` primary key (`coursename`,`studusername`),
  constraint `fk_marks_student` foreign key (`studusername`) references studentdetails(`username`)
);

--
-- Dumping data for table `marks`
--

INSERT INTO `marks` (`coursename`, `studusername`, `marks`) VALUES
('COA', 'student', 100),
('AP', 'student', 100),
('OTA', 'student', 75),
('Maths-3', 'student', 63),
('IDBMS', '19ucs100', 99),
('OTA', '19ucs002', 89),
('OTA', '19ucs100', 1000);

-- --------------------------------------------------------

--
-- Table structure for table `userlogin`
--

DROP TABLE IF EXISTS `userlogin`;
CREATE TABLE IF NOT EXISTS `userlogin` (
  `usertype` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  constraint`pk_userlogin`  PRIMARY KEY (`usertype`,`username`)
);

--
-- Dumping data for table `userlogin`
--

INSERT INTO `userlogin` (`usertype`, `username`, `password`) VALUES
('admin', 'admin', 'admin'),
('tutor', 'RajaS', 'raja'),
('student', 'student', 'student'),
('student', '19ucs002', '002'),
('student', '19ucs100', '100'),
('student', 'RajaS', 'rajaji');

COMMIT;

