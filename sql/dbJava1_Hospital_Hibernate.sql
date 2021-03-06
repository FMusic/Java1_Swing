--create baze Java1_Hospital sa SQL loginom, JavaHospital, JavaHospital

USE [master]
GO

/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [JavaHospital]    Script Date: 1/21/2020 1:19:43 PM ******/
CREATE LOGIN [JavaHospital] WITH PASSWORD=N'hNxWqxP7vCskK3GCGU8KBn14UskNgttMGZxdTa7Luj8=', DEFAULT_DATABASE=[Java1_Hospital], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO

ALTER LOGIN [JavaHospital] DISABLE
GO

ALTER SERVER ROLE [serveradmin] ADD MEMBER [JavaHospital]
GO

ALTER SERVER ROLE [dbcreator] ADD MEMBER [JavaHospital]
GO
drop database[Java1_Hospital]
create database [Java1_Hospital]
go
USE [Java1_Hospital]
GO
/****** Object:  User [JavaHospital]    Script Date: 1/21/2020 1:18:49 PM ******/
CREATE USER [JavaHospital] FOR LOGIN [JavaHospital] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_owner] ADD MEMBER [JavaHospital]
GO
ALTER ROLE [db_datareader] ADD MEMBER [JavaHospital]
GO
ALTER ROLE [db_datawriter] ADD MEMBER [JavaHospital]
GO
