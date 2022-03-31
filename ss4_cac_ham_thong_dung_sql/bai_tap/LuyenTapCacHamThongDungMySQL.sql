use quanlysinhvien;

select 
    *
from
    `subject`
where
    credit = (select 
            max(credit)
        from
            `subject`);

select 
    *
from
    `subject`
        join
    mark m ON `subject`.SubId = m.SubId
where
    mark = (select 
            max(mark)
        from
            mark);

select 
    student.studentid, studentname, avg(mark) as avg
from
    student
        join
    mark m ON student.studentid = m.studentid
group by student.studentid
order by avg;