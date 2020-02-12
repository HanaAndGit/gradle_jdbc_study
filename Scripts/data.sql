select user(), database ();

select emp_no, emp_name, title, manager, salary, dept, hire_date, pic from employee where emp_no=1003;
insert into title values
(1, '사장'),
(2, '부장'),
(3, '과장'),
(4, '대리'),
(5, '사원');

-- department
desc department ;
desc employee ;

select * from department;
insert into department values
(1, '영업', 8),
(2, '기획', 10),
(3, '개발', 9),
(4, '총무', 7);

-- employee
insert into employee(emp_no, emp_name, title, manager, salary, dept, password, hire_date) values
(4377, '이성래', 1, null, 5000000, 2, password('1234567'), '2000-03-01'),
(3426, '박영권', 3, 4377, 3000000, 1, password('1234567'), '2000-07-01'),
(1003, '조민희', 3, 4377, 3000000, 2, password('1234567'), '2005-07-01'),
(3011, '이수민', 2, 4377, 4000000, 3, password('1234567'), '2007-07-01'),
(2106, '김창섭', 4, 1003, 2000000, 2, password('1234567'), '2010-12-01'),
(3427, '최종철', 3, 1003, 1500000, 3, password('1234567'), '2010-12-01');



-- 테스트

select * from title;
select * from department;
select * from employee;
select emp_no, emp_name, pic from employee e;
select emp_no, emp_name, title, manager, salary, dept, password, hire_date from employee where dept=2; 
select emp_no, emp_name, t.title_name 
	from employee e left join title t on e.title = t.title_no 
where dept = 2;

-- 조민희가 로그인 하려고 할 경우

select emp_no, emp_name, title, manager, salary, dept, hire_date
	 from employee 
		where emp_no = 1003 and password = password('1234567');

-- insert

insert into employee(emp_no, emp_name, title, manager, salary, dept, password, hire_date) values(1004, '수지', 5, 1003, 2000000, 3, password('1234567'), '2010-05-01');

-- delete

delete from employee where emp_no = 1004; 

