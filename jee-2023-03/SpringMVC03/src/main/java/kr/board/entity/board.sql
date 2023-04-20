select * from myboard order by idx desc;

select * from myboard where idx=1;
select * from myboard;

create table myboard(
    idx int not null auto_increment,
    memID varchar(20) not null,
    title varchar(100) not null,
    content varchar(2000) not null,
    writer varchar(30) not null,
    indate datetime default now(),
    count int default 0,
    primary key(idx)
);

drop table myboard;



create table mem_tbl(
    memIdx int auto_increment,
    memID varchar(20) not null,
    memPassword varchar(20) not null,
    memName varchar(20) not null,
    memAge int,
    memGender varchar(20),
    memEmail varchar(50),
    memprofile varchar(50), --프로필
    primary key (memIdx) --프라이머리키
);

SELECT * FROM MEM_TBL