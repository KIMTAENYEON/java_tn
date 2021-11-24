-- 컴퓨터 개론 3분반 강의를 듣는 학생들의 명단을 확인하는 쿼리를 작성하세요.
-- 컴퓨터 개론 3분반 강의를 수강하는 학생들의 명단을 확인하는 쿼리를 작성하세요.
select st_num, st_name from course
	join subject
    on co_su_num = su_num
    join student
    on co_st_num = st_num
    where su_title = '컴퓨터 개론' and su_class_num = 3;
    
-- 2021160123 학번인 홍길동 학생이 수강한 모든 과목명을 확인하는 쿼리를 작성하세요.
select su_title from course
	join subject
    on co_su_num = su_num
    where co_st_num = 2021160123;

-- 이순신 교수님의 강의를 듣는 학생들 명단을 확인하는 쿼리를 작성하세요.
select st_name from lecture
	join professor
    on le_pr_num = pr_num
    join course
    on co_su_num = le_su_num
    join student
    on co_st_num = st_num
    where pr_name = '이순신';
    
-- 2021160001학번 학생이 1번 강의인 컴퓨터 개론 3분반 강의를 신청했다. 이 때 알맞은 쿼리를 작성하세요
-- insert into course (co_st_num, co_su_num)
-- 	values('2021160001', '1');
-- select * from course;

-- 2021160015학번 학생이 컴퓨터 개론 3분반 강의를 신청했다 이 때 알맞은 쿼리를 작성하세요.
-- insert into course (co_st_num, co_su_num) 
-- select '2021160015', su_num from subject	where su_class_num = 3 and su_title = '컴퓨터 개론';

-- 2021160123 학번 홍길동 학생이 수강중인 컴퓨터 개론 3분반 성적이 A+이 나왔다 이 때 알맞은 쿼리를 작성하세요.
-- update course set co_score = 'A+' where co_st_num = '2021160123' and co_su_num = 1;
-- select * from course;  

-- 홍길동 학생이 수강한 수강 과목의 수를 확인
select count(*) as '홍길동 학생 수강 과목 수' from course
    join student
    on st_num = co_st_num
    where st_name = '홍길동';
    
-- 컴퓨터 개론 3분반 현재 수강 신청 학생수를 확인
select count(*) as '컴퓨터 개론 3분반 현재 수강 학생 수' from course
	join subject
    on co_su_num = su_num
    where su_title = '컴퓨터 개론' and su_class_num = 3;

-- 이순신 교수님이 강의하는 강의 수
select count(*) as '이순신 교수 강의 수' from lecture
	join professor
    on le_pr_num = pr_num
    where pr_name = '이순신';
    
select count(*) as '이순신 교수 강의 수' from lecture
	join(select * from professor where pr_name = '이순신') as t
    on le_pr_num = pr_num;
    