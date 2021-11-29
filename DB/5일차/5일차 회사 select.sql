/* 홍길동 사원의 급여를 확인하는 쿼리문 : 기본급 + 호봉년차 * 추가금
*/
select em_name, sum(sa_base_salary + sa_add_salary * em_year) as '급여' from employee
	join salary
    on em_sa_level = sa_level
    where em_name = '홍길동';
    
/* 각 부서별 평균 급여를 출력하는 쿼리를 작성하세요. 단, 직원이 등록된 부서만
*/
select em_de_department as '부서명', avg(sa_base_salary + sa_add_salary * em_year) as '평균급여' from employee
	join salary
    on em_sa_level = sa_level 
    group by em_de_department;
    
