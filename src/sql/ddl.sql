create user 'project'@'localhost' identified by 'project';

create database YouCanDance character set=utf8;

grant all privileges on YouCanDance.* to 'project'@'localhost';

create table YouCanDance.MEMBER(
	ID int auto_increment primary key,
    EMAIL varchar(255),
    PASSWORD varchar(100),
    NAME varchar(100),
    REGDATE datetime,
    unique key (EMAIL)
) engine=InnoDB character set = utf8;

create table YouCanDance.BOARD(
	ID int auto_increment primary key,
    SUBJECT varchar(255),
    CONTENT varchar(1000),
    NAME varchar(100),
    REGDATE datetime,
    READCOUNT int
) engine=InnoDB character set = utf8;

create table YouCanDance.STUDIO(
	ID int auto_increment primary key,
    NAME varchar(100),
    LOCATE varchar(255),
    INFO varchar(255)
) engine=InnoDB character set = utf8;

create table YouCanDance.INSTRUCTOR(
	ID int auto_increment primary key,
    NAME varchar(100),
    STUDIO_ID int,
    foreign key (STUDIO_ID) references YouCanDance.STUDIO(ID)
) engine=InnoDB character set = utf8;

create table YouCanDance.CLASS(
	ID int auto_increment primary key,
	STUDIO_ID int,
	INSTRUCTOR_ID int,
    START_TIME datetime,
    END_TIME datetime,
    GENRE varchar(100),
    DIFFICULTY varchar(100),
    APPLY varchar(255),
    foreign key (STUDIO_ID) references YouCanDance.STUDIO(ID),
    foreign key (INSTRUCTOR_ID) references YouCanDance.INSTRUCTOR(ID)
) engine=InnoDB character set = utf8;