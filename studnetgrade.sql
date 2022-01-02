/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.26 : Database - studnetgrade
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`studnetgrade` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `studnetgrade`;

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `Cno` char(20) NOT NULL,
  `Cname` char(14) DEFAULT NULL,
  `Cgrade` int(11) DEFAULT NULL,
  `Ctime` int(11) DEFAULT NULL,
  `Ctype` char(14) DEFAULT NULL,
  PRIMARY KEY (`Cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `course` */

insert  into `course`(`Cno`,`Cname`,`Cgrade`,`Ctime`,`Ctype`) values ('C001','数据库原理',4,42,'考试课'),('C002','大学物理',5,64,'考试课'),('C003','java程序设计',4,32,'考试课');

/*Table structure for table `sc` */

DROP TABLE IF EXISTS `sc`;

CREATE TABLE `sc` (
  `Sno` char(20) NOT NULL,
  `Cno` char(20) NOT NULL,
  `Scg` int(11) DEFAULT NULL,
  PRIMARY KEY (`Sno`,`Cno`),
  KEY `Cno` (`Cno`),
  CONSTRAINT `sc_ibfk_3` FOREIGN KEY (`Cno`) REFERENCES `course` (`Cno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sc_ibfk_4` FOREIGN KEY (`Sno`) REFERENCES `student` (`Sno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sc` */

insert  into `sc`(`Sno`,`Cno`,`Scg`) values ('00001','c001',87),('00001','C002',70),('00001','C003',70),('00002','C001',70),('00002','C002',60),('00002','C003',90),('00003','c001',70),('00003','C002',80),('00003','C003',84),('00004','C001',80),('00004','C002',78),('00004','C003',69),('00005','C001',98),('00005','C002',84),('00005','C003',80),('00006','C001',78),('00006','C002',87),('00006','C003',98);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `Sno` char(20) NOT NULL,
  `Sname` char(8) NOT NULL,
  `Ssex` char(2) DEFAULT NULL,
  `Sage` int(11) DEFAULT NULL,
  `Sdept` char(20) DEFAULT NULL,
  `Clno` char(20) DEFAULT NULL,
  PRIMARY KEY (`Sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`Sno`,`Sname`,`Ssex`,`Sage`,`Sdept`,`Clno`) values ('00001','李勇','男',20,'Cs','1'),('00002','李林','女',19,'MI','1'),('00003','王刚','男',21,'DB','2'),('00004','张伟','男',20,'DB','1'),('00005','赵云','男',19,'cs','2'),('00006','王芳','女',20,'DB','2');

/*Table structure for table `tc` */

DROP TABLE IF EXISTS `tc`;

CREATE TABLE `tc` (
  `Stno` char(20) NOT NULL,
  `Cno` char(20) NOT NULL,
  `Clno` int(11) NOT NULL,
  PRIMARY KEY (`Stno`,`Cno`),
  KEY `Cno` (`Cno`),
  CONSTRAINT `tc_ibfk_1` FOREIGN KEY (`Stno`) REFERENCES `teacher` (`Stno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tc_ibfk_2` FOREIGN KEY (`Cno`) REFERENCES `course` (`Cno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc` */

insert  into `tc`(`Stno`,`Cno`,`Clno`) values ('10001','C001',1),('10002','C002',1),('10003','C003',2);

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `Stno` char(20) NOT NULL,
  `Stname` char(8) NOT NULL,
  `Stsex` char(2) DEFAULT NULL,
  `Stage` int(11) DEFAULT NULL,
  `Sto` char(20) DEFAULT NULL,
  PRIMARY KEY (`Stno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

insert  into `teacher`(`Stno`,`Stname`,`Stsex`,`Stage`,`Sto`) values ('10001','李斯','女',35,'老师'),('10002','李伟','男',40,'副教授'),('10003','张伟','男',30,'老师');

/*Table structure for table `userperson` */

DROP TABLE IF EXISTS `userperson`;

CREATE TABLE `userperson` (
  `Susername` char(20) NOT NULL,
  `Spassword` char(20) NOT NULL,
  `Sno` char(8) NOT NULL,
  `SID` char(20) NOT NULL,
  PRIMARY KEY (`Susername`),
  UNIQUE KEY `SID` (`SID`),
  UNIQUE KEY `SID_2` (`SID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `userperson` */

insert  into `userperson`(`Susername`,`Spassword`,`Sno`,`SID`) values ('00001','a00001','student','00001'),('00002','a00002','student','00002'),('00003','a00003','student','00003'),('00004','a00004','student','00004'),('00005','a00005','student','00005'),('00006','a00006','student','00006'),('10001','b10001','teacher','10001'),('10002','b10002','teacher','10002'),('10003','b10003','teacher','10003'),('c001','c001','manager','001'),('c002','c002','manager','002');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
