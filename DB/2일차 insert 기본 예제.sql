-- insert into student values('2021160123', 'hong', 'hong', '홍길동', '020101-3456789');
-- id : hong123, pw : pw123으로 하려고 했으나 순서를 착각해서 잘못 입력했더니 원하지 않은 결과가 발생
-- insert into student values('2021160124', 'pw123','hong123', '홍길동', '020505-3123456');

-- insert into student (st_num, st_id, st_pw, st_name, st_reg_num)
-- 	values('2021116001', 'kang', 'kang', '강감찬', '021225-3654321');
-- id : kimid, pw : pwkim으로 하기 위해 속성 순서를 st_pw, st_id 순으로 바꿔서 원하는 결과가 나옴
-- insert into student (st_num, st_pw, st_id, st_name, st_reg_num)
-- 	values('2021160015', 'pwkim', 'kimid', '김영희', '021225-4654321');
-- insert into student values	('2021123005', 'pack', 'packpw', '박철수', '021221-4443332'),
-- 							('2021456005', 'packidstudentstudent', 'packpw', '박수철', '020808-3985612');
-- select * from university_tn.student;

-- 교수번호가 2000160001인 이순신 교수님의 정보를 추가하는 쿼리문을 작성하세요.
-- id : Lee, pw : leelee, 주민번호 : 550505-1234567
-- insert into professor (pr_num, pr_id, pr_pw, pr_name, pr_reg_num)
-- 	values ('2000160001', 'Lee', 'leelee', '이순신', '550505-1234567');
-- select * from professor;

-- 과목명이 컴퓨터 개론이고, 과목 코드는 MSC001, 일정과 분반은 미정인 과목을 추가하는 쿼리문을 작성하세요.
-- insert into subject (su_title, su_code)
-- 	values ('컴퓨터 개론', 'MSC001');

-- 2000160001교수님이 1번 과목을 강의한다. 이 내용을 lecture 테이블에 추가하는 코드를 작성하세요.
--  insert into lecture (le_pr_num, le_su_num)
-- 	values ('2000160001','1');
-- select * from lecture;

-- 2021160123 홍길동 학생이 1번 과목을 수강신청 했다. 이 내용을 추가하는 코드를 작성하세요.
-- insert into course (co_st_num, co_su_num)
-- 	values ('2021160123', '1');
-- select * from course;

