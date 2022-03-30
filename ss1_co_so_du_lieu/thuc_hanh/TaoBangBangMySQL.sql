-- drop table if exists `student_management`.`student`; 
create table `student_management`.`student` (
`id` int not null, 
`name` varchar(45) null,
`age` INT NULL,
`country` varchar(45) null,
primary key (`id`)
);
select * from student;
create table `student_management`.`class` (
`id` int not null, 
`name` varchar(45) null,
primary key (`id`)
);
select * from class;
create table `student_management`.`teacher` (
`id` int not null, 
`name` varchar(45) null,
`age` INT NULL,
`country` varchar(45) null,
primary key (`id`)
);
select * from teacher;