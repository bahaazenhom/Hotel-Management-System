USE [master]
GO
/****** Object:  Database [Hotell]    Script Date: 6/3/2022 3:17:16 PM ******/
CREATE DATABASE [Hotell]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'hotel', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\hotel.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'hotel_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\hotel_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [Hotell] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Hotell].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Hotell] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Hotell] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Hotell] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Hotell] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Hotell] SET ARITHABORT OFF 
GO
ALTER DATABASE [Hotell] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [Hotell] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Hotell] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Hotell] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Hotell] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Hotell] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Hotell] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Hotell] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Hotell] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Hotell] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Hotell] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Hotell] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Hotell] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Hotell] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Hotell] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Hotell] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Hotell] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Hotell] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Hotell] SET  MULTI_USER 
GO
ALTER DATABASE [Hotell] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Hotell] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Hotell] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Hotell] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Hotell] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Hotell] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [Hotell] SET QUERY_STORE = OFF
GO
USE [Hotell]
GO
/****** Object:  Table [dbo].[Booking]    Script Date: 6/3/2022 3:17:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Booking](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[date] [date] NULL,
	[check_in_date] [varchar](50) NOT NULL,
	[check_out_date] [varchar](50) NULL,
	[employee_ID] [int] NOT NULL,
	[guest_ID] [int] NOT NULL,
	[payment_ID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[booking_has_service]    Script Date: 6/3/2022 3:17:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[booking_has_service](
	[booking_ID] [int] NOT NULL,
	[service_ID] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[credit]    Script Date: 6/3/2022 3:17:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[credit](
	[card_num] [varchar](50) NOT NULL,
	[expire_date] [varchar](50) NOT NULL,
	[CVV] [varchar](10) NOT NULL,
	[guest_id] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Department]    Script Date: 6/3/2022 3:17:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Department](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[description] [varchar](50) NULL,
	[manager_ID] [int] NULL,
	[hotel_branch_ID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Employee]    Script Date: 6/3/2022 3:17:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Employee](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[proof_ID] [varchar](50) NOT NULL,
	[first_name] [varchar](50) NOT NULL,
	[second_name] [varchar](50) NOT NULL,
	[role] [varchar](50) NOT NULL,
	[salary] [float] NOT NULL,
	[contuct_num] [varchar](50) NOT NULL,
	[dep_ID] [int] NOT NULL,
	[Access] [bit] NULL,
	[email] [varchar](50) NOT NULL,
	[password] [varchar](50) NULL,
	[address] [nchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[guest]    Script Date: 6/3/2022 3:17:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[guest](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[first_name] [varchar](50) NOT NULL,
	[second_name] [varchar](50) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[contuct_num] [varchar](50) NOT NULL,
	[hotel_ID] [int] NOT NULL,
	[proof_ID] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Hotels]    Script Date: 6/3/2022 3:17:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Hotels](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[manager] [varchar](50) NOT NULL,
	[contact_num] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[payment]    Script Date: 6/3/2022 3:17:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[payment](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[type] [varchar](50) NOT NULL,
	[date] [date] NOT NULL,
	[guest_ID] [int] NOT NULL,
	[total_payment] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[room]    Script Date: 6/3/2022 3:17:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[room](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[type] [varchar](50) NOT NULL,
	[floor] [char](1) NOT NULL,
	[air_conditions] [bit] NULL,
	[smoke_fiendly] [bit] NULL,
	[pet_fiendly] [bit] NULL,
	[availability] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[rooms_booked]    Script Date: 6/3/2022 3:17:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[rooms_booked](
	[booking_ID] [int] NOT NULL,
	[room_ID] [int] NOT NULL,
UNIQUE NONCLUSTERED 
(
	[room_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[room_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Service]    Script Date: 6/3/2022 3:17:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Service](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[description] [varchar](50) NULL,
	[cost] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Booking] ADD  DEFAULT (getdate()) FOR [date]
GO
ALTER TABLE [dbo].[Employee] ADD  DEFAULT ((0)) FOR [Access]
GO
ALTER TABLE [dbo].[guest] ADD  CONSTRAINT [DF_guest_hotel_ID]  DEFAULT ((1)) FOR [hotel_ID]
GO
ALTER TABLE [dbo].[payment] ADD  CONSTRAINT [DF_payment_date]  DEFAULT (getdate()) FOR [date]
GO
ALTER TABLE [dbo].[room] ADD  DEFAULT ((0)) FOR [smoke_fiendly]
GO
ALTER TABLE [dbo].[room] ADD  DEFAULT ((0)) FOR [pet_fiendly]
GO
ALTER TABLE [dbo].[Booking]  WITH CHECK ADD  CONSTRAINT [FK_Booking_Employee] FOREIGN KEY([employee_ID])
REFERENCES [dbo].[Employee] ([ID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Booking] CHECK CONSTRAINT [FK_Booking_Employee]
GO
ALTER TABLE [dbo].[Booking]  WITH CHECK ADD  CONSTRAINT [FK_Booking_guest] FOREIGN KEY([guest_ID])
REFERENCES [dbo].[guest] ([ID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Booking] CHECK CONSTRAINT [FK_Booking_guest]
GO
ALTER TABLE [dbo].[Booking]  WITH CHECK ADD  CONSTRAINT [FK_Booking_payment] FOREIGN KEY([payment_ID])
REFERENCES [dbo].[payment] ([ID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Booking] CHECK CONSTRAINT [FK_Booking_payment]
GO
ALTER TABLE [dbo].[booking_has_service]  WITH CHECK ADD  CONSTRAINT [FK_booking_has_service_Booking] FOREIGN KEY([booking_ID])
REFERENCES [dbo].[Booking] ([ID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[booking_has_service] CHECK CONSTRAINT [FK_booking_has_service_Booking]
GO
ALTER TABLE [dbo].[booking_has_service]  WITH CHECK ADD  CONSTRAINT [FK_booking_has_service_Service] FOREIGN KEY([service_ID])
REFERENCES [dbo].[Service] ([ID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[booking_has_service] CHECK CONSTRAINT [FK_booking_has_service_Service]
GO
ALTER TABLE [dbo].[credit]  WITH CHECK ADD  CONSTRAINT [FK_credit_guest] FOREIGN KEY([guest_id])
REFERENCES [dbo].[guest] ([ID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[credit] CHECK CONSTRAINT [FK_credit_guest]
GO
ALTER TABLE [dbo].[Department]  WITH CHECK ADD  CONSTRAINT [FK_Department_Employee] FOREIGN KEY([manager_ID])
REFERENCES [dbo].[Employee] ([ID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Department] CHECK CONSTRAINT [FK_Department_Employee]
GO
ALTER TABLE [dbo].[Department]  WITH CHECK ADD  CONSTRAINT [FK_Department_Hotels] FOREIGN KEY([hotel_branch_ID])
REFERENCES [dbo].[Hotels] ([ID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Department] CHECK CONSTRAINT [FK_Department_Hotels]
GO
ALTER TABLE [dbo].[Employee]  WITH CHECK ADD  CONSTRAINT [FK_Employee_Department] FOREIGN KEY([dep_ID])
REFERENCES [dbo].[Department] ([ID])
GO
ALTER TABLE [dbo].[Employee] CHECK CONSTRAINT [FK_Employee_Department]
GO
ALTER TABLE [dbo].[guest]  WITH CHECK ADD  CONSTRAINT [FK_guest_Hotels] FOREIGN KEY([hotel_ID])
REFERENCES [dbo].[Hotels] ([ID])
GO
ALTER TABLE [dbo].[guest] CHECK CONSTRAINT [FK_guest_Hotels]
GO
ALTER TABLE [dbo].[payment]  WITH CHECK ADD  CONSTRAINT [FK_payment_guest] FOREIGN KEY([guest_ID])
REFERENCES [dbo].[guest] ([ID])
GO
ALTER TABLE [dbo].[payment] CHECK CONSTRAINT [FK_payment_guest]
GO
ALTER TABLE [dbo].[rooms_booked]  WITH CHECK ADD  CONSTRAINT [FK_rooms_booked_Booking] FOREIGN KEY([booking_ID])
REFERENCES [dbo].[Booking] ([ID])
GO
ALTER TABLE [dbo].[rooms_booked] CHECK CONSTRAINT [FK_rooms_booked_Booking]
GO
ALTER TABLE [dbo].[rooms_booked]  WITH CHECK ADD  CONSTRAINT [FK_rooms_booked_room] FOREIGN KEY([room_ID])
REFERENCES [dbo].[room] ([ID])
GO
ALTER TABLE [dbo].[rooms_booked] CHECK CONSTRAINT [FK_rooms_booked_room]
GO
USE [master]
GO
ALTER DATABASE [Hotell] SET  READ_WRITE 
GO
