insert into fruit value ('딸기', 15000, 0);
insert into trade (tr_date, tr_fr_name, tr_amount, tr_price, tr_type)
	value('2021-06-15', '딸기', 100, 10000, 'buy');
update fruit set fr_amount = fr_amount + 100 where fr_name = '딸기';
insert into trade (tr_date, tr_fr_name, tr_amount, tr_price, tr_type)
	value('2021-06-15', '딸기', 1, 15000, 'sell');
update fruit set fr_amount = fr_amount - 1 where fr_name = '딸기';
select * from trade;

select sum(tr_amount * tr_price) as '2021-06-15 판매액' from trade
	where tr_date like '2021-06-15%' and tr_type = 'sell';
    
select fr_amount as '딸기 재고량' from fruit 
	where fr_name = '딸기';