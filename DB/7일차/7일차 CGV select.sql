-- cgv 강남 지점에서 12월 1일 상영 시간표를 확인 
select mo_title as '영화이름', mg_ge_name as '영화장르', mo_runtime as '런타임시간', mo_date as '개봉일', mo_age as '관람등급', 
	sc_option as '옵션', sc_room_num as '관번호', sc_total_seat as '총좌석', sc_time as '상영시간', sc_seat as '남은좌석' from `schedule`
	join theater
    on sc_th_num = th_num
    join movie
    on sc_mo_num = mo_num
    join movie_genre
    on mo_num = mg_mo_num
    where th_name = 'CGV강남' and sc_date = '2021-12-01';

-- CGV강남 12월1일 21:20분 1관에서 하는 영화에서 예매 가능한 좌석을 확인 
-- CGV강남점 1관의 전체 좌석 정보 
select th_name, st_room_num, st_name from seat
	join theater on th_num = st_th_num
    where th_name = 'CGV강남' and st_room_num = 1;
-- CGV강남, 12월1일 21:20분 1관에서 하는 영화 예매 내역 
select * from ticketing_list
	join ticketing on tl_tk_num = tk_num
    join `schedule` on tk_sc_num = sc_num
    where sc_th_num = 1 and sc_room_num = 1 and sc_date = '2021-12-01' and sc_time = '21:20';
select * from ticketing_list
	join ticketing on tl_tk_num = tk_num
    where tk_sc_num = 2;
    
-- 예약가능한 좌석확인 
select st_name from seat left 
	join(select * from ticketing_list
		join ticketing on tl_tk_num = tk_num
		where tk_sc_num = 2) as tl on st_num = tl_st_num
        where st_th_num = 1 and st_room_num = 1 and tl_num is null;
 

select * from ticketing_list;
