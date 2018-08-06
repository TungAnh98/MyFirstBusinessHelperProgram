USE [master]
GO
/****** Object:  Database [TungAnh]    Script Date: 7/19/2018 3:57:52 PM ******/
CREATE DATABASE [TungAnh]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'TungAnh', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.MSSQLSERVER\MSSQL\DATA\TungAnh.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'TungAnh_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.MSSQLSERVER\MSSQL\DATA\TungAnh_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [TungAnh] SET COMPATIBILITY_LEVEL = 130
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [TungAnh].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [TungAnh] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [TungAnh] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [TungAnh] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [TungAnh] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [TungAnh] SET ARITHABORT OFF 
GO
ALTER DATABASE [TungAnh] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [TungAnh] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [TungAnh] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [TungAnh] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [TungAnh] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [TungAnh] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [TungAnh] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [TungAnh] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [TungAnh] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [TungAnh] SET  DISABLE_BROKER 
GO
ALTER DATABASE [TungAnh] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [TungAnh] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [TungAnh] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [TungAnh] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [TungAnh] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [TungAnh] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [TungAnh] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [TungAnh] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [TungAnh] SET  MULTI_USER 
GO
ALTER DATABASE [TungAnh] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [TungAnh] SET DB_CHAINING OFF 
GO
ALTER DATABASE [TungAnh] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [TungAnh] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [TungAnh] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [TungAnh] SET QUERY_STORE = OFF
GO
USE [TungAnh]
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO
USE [TungAnh]
GO
/****** Object:  Table [dbo].[History]    Script Date: 7/19/2018 3:57:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[History](
	[Room] [varchar](50) NULL,
	[XucXich] [int] NULL,
	[RedBull] [int] NULL,
	[StingVang] [int] NULL,
	[StingDo] [int] NULL,
	[Gia] [int] NULL,
	[TimeOrder] [varchar](50) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ReceiveOrder]    Script Date: 7/19/2018 3:57:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ReceiveOrder](
	[Room] [varchar](50) NULL,
	[XucXich] [int] NULL,
	[RedBull] [int] NULL,
	[StingVang] [int] NULL,
	[StingDo] [int] NULL,
	[Gia] [int] NULL,
	[TimeOrder] [varchar](50) NULL
) ON [PRIMARY]
GO
USE [master]
GO
ALTER DATABASE [TungAnh] SET  READ_WRITE 
GO
