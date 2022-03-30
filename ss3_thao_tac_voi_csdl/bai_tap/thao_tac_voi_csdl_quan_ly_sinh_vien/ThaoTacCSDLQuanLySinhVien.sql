use quanlysinhvien;
select * from quanlysinhvien.student
where studentname like 'h%';

select * from quanlysinhvien.class
where month(startdate) = 12;

select * from quanlysinhvien.subject
where credit >=3 and credit <=5;

set sql_safe_updates = 0;
update quanlysinhvien.student 
set classid = 2 
where studentname = 'hung';
set sql_safe_updates = 1;

SELECT S.StudentName, Sub.SubName, M.Mark
FROM Student S join Mark M on S.StudentId = M.StudentId join Subject Sub on M.SubId = Sub.SubId
order by mark desc , s.studentname;

